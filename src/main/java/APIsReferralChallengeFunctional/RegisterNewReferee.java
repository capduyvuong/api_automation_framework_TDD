package APIsReferralChallengeFunctional;

import Utils.GetVuiToken;
import Utils.RandomPhoneNumber;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class RegisterNewReferee {
    public static int statusCode;
    public static String actualRefCode;
    public static final String FILE_CONFIG = "\\configs\\configuration.properties";
    static String expectedRefCode = GetRunningReferralChallenge.refCode;

    public static void registerNewReferee() throws IOException{
        InputStream inputStream = null;
        String currentDir = System.getProperty("user.dir");
        inputStream = new FileInputStream(currentDir + FILE_CONFIG);
        Properties properties = new Properties();
        properties.load(inputStream);
        RestAssured.baseURI = properties.getProperty("gateway_host_referral");
        String registerNewRefereeJsonBody = "{" +
                "\n" +
                "\"refcode\": \"" + expectedRefCode + "\"" +
                ",\n" +
                " \"mobile\": \"" + RandomPhoneNumber.randomPhoneNumber + "\"" +
                "\n" +
                " \"name\": \"" + properties.getProperty("referee_name") + "\"" +
                "\n" +
                "}";

        Response response = given()
                .header("Authorization", "Bearer " + GetVuiToken.accessToken)
                .contentType("application/json")
                .body(registerNewRefereeJsonBody)
                .when()
                .post("/api/referral/v1/referee/register")
                .then().log().body().extract().response();
        statusCode = response.getStatusCode();
    }
}
