package APIsReferralChallengeFunctional;

import Utils.GetVuiToken;
import Utils.ValidateOTP;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class VerifyRefCode {
    public static int statusCode;
    public static String messageContent;
    public static final String FILE_CONFIG = "\\configs\\configuration.properties";

    public static void verifyRefCode() throws IOException{
        InputStream inputStream = null;
        String currentDir = System.getProperty("user.dir");
        inputStream = new FileInputStream(currentDir + FILE_CONFIG);
        Properties properties = new Properties();
        properties.load(inputStream);
        RestAssured.baseURI = properties.getProperty("gateway_host_referral");
        Response response = given()
                .header("Authorization", "Bearer " + GetVuiToken.accessToken)
                .param("refcode", CreateRefCode.actualRefCode)
                .when()
                .get("/api/referral/v1/customers/refcode/check")
                .then().log().body().extract().response();
        statusCode = response.getStatusCode();
        messageContent = response.getBody().jsonPath().getString("message");
    }
}
