package APIsGameChallengeFunctional;

import Utils.GetVuiToken;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class GetChallengeDetail {
    public static int statusCode;
    public static String challengeName;
    public static String challengeJoinStatus;
    public static String customerChallengeStatus;
    public static final String FILE_CONFIG = "\\configs\\configuration.properties";
    public static RequestSpecBuilder builder;
    public static RequestSpecification requestSpecification;

    public static void init() throws IOException {
        InputStream inputStream = null;
        String currentDir = System.getProperty("user.dir");
        inputStream = new FileInputStream(currentDir + FILE_CONFIG);
        Properties properties = new Properties();
        properties.load(inputStream);
        RestAssured.baseURI = properties.getProperty("base_apiGwDev_Url");
        builder = new RequestSpecBuilder();
        builder.addParam("id", GetAllRunningChallenges.firstChallengeId);
        builder.addParam("phoneNumber", properties.getProperty("customer_phone_number"));
        builder.addHeader("Authorization", "Bearer " + GetVuiToken.accessToken);
        requestSpecification = builder.build();
    }
    public static void getChallengesDetail() throws IOException {
        init();
        Response response = given()
                .spec(requestSpecification)
                .when()
                .get("/api/game-multi-brand/mobile/challenges/detail/")
                .then().log().body().extract().response();
        statusCode = response.getStatusCode();
        challengeName = response.getBody().jsonPath().getString("data.name");
        challengeJoinStatus = response.getBody().jsonPath().getString("data.joinStatus");
        customerChallengeStatus = response.getBody().jsonPath().getString("data.customerchallenge.status");
    }
}
