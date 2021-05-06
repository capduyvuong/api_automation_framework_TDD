package APIsReferralChallengeFunctional;

import Utils.GetVuiToken;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class GetRunningReferralChallenge {
    public static int statusCode;
    public static String refCode;
    public static String milestoneId;
    public static String runningRefName;
    public static final String FILE_CONFIG = "\\configs\\configuration.properties";

    public static void getRunningReferralChallenge() throws IOException{
        InputStream inputStream = null;
        String currentDir = System.getProperty("user.dir");
        inputStream = new FileInputStream(currentDir + FILE_CONFIG);
        Properties properties = new Properties();
        properties.load(inputStream);
        RestAssured.baseURI = properties.getProperty("gateway_host_referral");
        Response response = given()
                .header("Authorization", "Bearer " + GetVuiToken.accessToken)
                .param("mobile", properties.getProperty("customer_phone_number"))
                .when()
                .get("/api/referral/v1/challenges/mo/running")
                .then().log().body().extract().response();
        statusCode = response.getStatusCode();
        refCode = response.getBody().jsonPath().getString("data.refcode");
        milestoneId = response.getBody().jsonPath().getString("data.milestoneDtos[0].id");
        runningRefName = response.getBody().jsonPath().getString("data.name");
    }
}
