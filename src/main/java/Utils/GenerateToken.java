package Utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class GenerateToken {
    public static int statusCodeGenerateToken;
    public static String sessionId;

    public static final String FILE_CONFIG = "\\configs\\configuration.properties";

    public static void generateToken() throws IOException {
        InputStream inputStream = null;
        String currentDir = System.getProperty("user.dir");
        inputStream = new FileInputStream(currentDir + FILE_CONFIG);
        Properties properties = new Properties();
        properties.load(inputStream);
        RestAssured.baseURI = properties.getProperty("gateway_host_mobile_service");
        String tokenGenerationJsonBody =
                "{\n" +
                "\"mobile\": \"" + properties.getProperty("customer_phone_number") + "\",\n" +
                "\"deviceId\": \"" + properties.getProperty("device_id") + "\",\n" +
                "\"brand\": \"" + properties.getProperty("brand") + "\" \n" +
                "}";
        Response response = given()
                .contentType("application/json")
                .body(tokenGenerationJsonBody)
                .when()
                .post("/api/mobile-service/v1/auth/token/generate")
                .then().log().body().extract().response();
        statusCodeGenerateToken = response.getStatusCode();
        sessionId = response.getBody().jsonPath().getString("user.sessionId");
    }
}
