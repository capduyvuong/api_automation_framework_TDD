package Utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static io.restassured.RestAssured.given;
public class GetVuiToken {
    public static int statusCode;
    public static String accessToken;
    public static final String FILE_CONFIG = "\\configs\\configuration.properties";

    public static void getVuiToken() throws IOException {
        InputStream inputStream = null;
        String currentDir = System.getProperty("user.dir");
        inputStream = new FileInputStream(currentDir + FILE_CONFIG);
        Properties properties = new Properties();
        properties.load(inputStream);
        RestAssured.baseURI = properties.getProperty("base_uukUat_Url");
        Response response = given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("grant_type", "client_credentials")
                .formParam("client_id", "mobile-client")
                .formParam("client_secret","ec761ae9-4ee9-497f-ba00-64d25e0c7854")
                .when()
                .post("/auth/realms/mobile/protocol/openid-connect/token")
                .then().log().body().extract().response();
        statusCode = response.getStatusCode();
        accessToken = response.getBody().jsonPath().getString("access_token");
    }
}

