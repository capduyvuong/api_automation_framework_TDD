package APIsGameChallengeFunctional;

import Utils.GetVuiToken;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class JoinChallenge {
    public static int statusCode;
    public static String challengeStatus;
    public static final String FILE_CONFIG = "\\configs\\configuration.properties";

    public static void joinChallenge() throws IOException {
        InputStream inputStream = null;
        String currentDir = System.getProperty("user.dir");
        inputStream = new FileInputStream(currentDir + FILE_CONFIG);
        Properties properties = new Properties();
        properties.load(inputStream);
        RestAssured.baseURI = properties.getProperty("base_apiGwDev_Url");
        Response response = (Response) given()
                .header("Authorization", "Bearer " + GetVuiToken.accessToken)
                .param("id", GetAllRunningChallenges.firstChallengeId)
                .param("phoneNumber", properties.getProperty("customer_phone_number"))
                .when()
                .post("/api/game-multi-brand/mobile/challenges/join/")
                .then().log().body().extract().response();
        statusCode = response.getStatusCode();
        challengeStatus = response.getBody().jsonPath().getString("data.customerchallenge.status");
    }
}
