package APIsGameChallengeFunctional;

import Utils.GetVuiToken;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class GetAllRunningChallenges {
    public static int statusCode;
    public static int totalOfChallenges;
    public static String firstChallengeId;
    public static String firstChallengeName;
    public static final String FILE_CONFIG = "\\configs\\configuration.properties";

    public static void getAllRunningChallenges() throws IOException {
        InputStream inputStream = null;
        String currentDir = System.getProperty("user.dir");
        inputStream = new FileInputStream(currentDir + FILE_CONFIG);
        Properties properties = new Properties();
        properties.load(inputStream);
        RestAssured.baseURI = properties.getProperty("base_apiGwDev_Url");
        Response response = given()
                .header("Authorization", "Bearer " + GetVuiToken.accessToken)
                .when()
                .get("/api/game-multi-brand/mobile/challenges?phoneNumber={phoneNumber}", properties.getProperty("customer_phone_number"))
                .then().log().body().extract().response();
        statusCode = response.getStatusCode();
        totalOfChallenges = response.getBody().jsonPath().getInt("totalRows");
        firstChallengeId = response.getBody().jsonPath().getString("data[0].id");
        firstChallengeName = response.getBody().jsonPath().getString("data[0].name");
    }
}
