package APIsReferralChallengeFunctional;

import Utils.GetVuiToken;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class CreateRefCode {
    public static int statusCode;
    public static String actualRefCode;
    public static final String FILE_CONFIG = "\\configs\\configuration.properties";
    static String expectedRefCode = GetRunningReferralChallenge.refCode;

    public static void createRefCode() throws IOException{
        InputStream inputStream = null;
        String currentDir = System.getProperty("user.dir");
        inputStream = new FileInputStream(currentDir + FILE_CONFIG);
        Properties properties = new Properties();
        properties.load(inputStream);
        RestAssured.baseURI = properties.getProperty("gateway_host_referral");
        String createRefCodeJsonBody = "{" +
                "\n" +
                "\"refcode\": \"" + expectedRefCode + "\"" +
                ",\n" +
                " \"mobile\": \"" + properties.getProperty("referer_phone_number") + "\"" +
                "\n" +
                "}";

        Response response = given()
                .header("Authorization", "Bearer " + GetVuiToken.accessToken)
                .contentType("application/json")
                .body(createRefCodeJsonBody)
                .when()
                .post("/api/referral/v1/customers/refcode")
                .then().log().body().extract().response();
        statusCode = response.getStatusCode();
        actualRefCode = response.getBody().jsonPath().getString("data.refcode");
    }
}
