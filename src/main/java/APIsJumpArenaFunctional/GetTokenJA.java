package APIsJumpArenaFunctional;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class GetTokenJA {
    public static int statusCode;
    public static String accessTokenJA;
    public static final String FILE_CONFIG = "\\configs\\configuration.properties";

    public static void getTokenJA() throws IOException {
        InputStream inputStream = null;
        String currentDir = System.getProperty("user.dir");
        inputStream = new FileInputStream(currentDir + FILE_CONFIG);
        Properties properties = new Properties();
        properties.load(inputStream);
        RestAssured.baseURI = properties.getProperty("gateway_host_jump_arena");
        String getTokenJAJsonBody =
                "{\n" +
                        "\"grant_type\": \"" + "client_credentials" + "\",\n" +
                        "\"client_id\": \"" + properties.getProperty("client_id_ja") + "\",\n" +
                        "\"client_secret\": \"" + properties.getProperty("client_secret_ja") + "\" \n" +
                        "}";
        Response response = given()
                .contentType("application/json")
                .body(getTokenJAJsonBody)
                .when()
                .post("/v2/auth/token")
                .then().log().body().extract().response();
        statusCode = response.getStatusCode();
        accessTokenJA = response.getBody().jsonPath().getString("access_token");
    }
}
