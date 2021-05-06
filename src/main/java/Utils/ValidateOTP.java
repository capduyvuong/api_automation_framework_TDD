package Utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class ValidateOTP {
    public static int statusCodeValidateOTP;

    public static String cap_access_token;
    public static String vui_access_token;

    public static final String FILE_CONFIG = "\\configs\\configuration.properties";

    public static void validateOTP() throws IOException {
        InputStream inputStream = null;
        String currentDir = System.getProperty("user.dir");
        inputStream = new FileInputStream(currentDir + FILE_CONFIG);
        Properties properties = new Properties();
        properties.load(inputStream);
        RestAssured.baseURI = properties.getProperty("gateway_host_mobile_service");
        String OTPValidationJsonBody =
                "{\n" +
                        "\"mobile\": \"" + properties.getProperty("customer_phone_number") + "\",\n" +
                        "\"deviceId\": \"" + properties.getProperty("device_id") + "\",\n" +
                        "\"brand\": \"" + properties.getProperty("brand") + "\",\n" +
                        "\"brand\": \"" + GenerateToken.sessionId + "\",\n" +
                        "\"otp\": \"" + 999999 + "\" \n" +
                        "}";
        Response response = given()
                .contentType("application/json")
                .body(OTPValidationJsonBody)
                .when()
                .post("/api/mobile-service/v1/auth/otp/validate")
                .then().log().body().extract().response();
        statusCodeValidateOTP = response.getStatusCode();
        cap_access_token = response.getBody().jsonPath().getString("auth.token");
        vui_access_token = response.getBody().jsonPath().getString("auth.vuiAccessToken");
    }
}
