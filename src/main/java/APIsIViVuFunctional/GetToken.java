package APIsIViVuFunctional;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetToken {
    public static int statusCode;
    public static String accessToken;
    public static void getToken() {
        RestAssured.baseURI = "https://uukuat.taptap.com.vn"; //Setup Base URI
        Response response = given()
                .auth()
                .preemptive()
                .basic("ivivu-client", "a9c86361-f0db-421f-a3c5-2724c4fe5793")
                .contentType("application/x-www-form-urlencoded")
                .formParam("grant_type", "client_credentials")
                .when()
                .post("/auth/realms/mobile/protocol/openid-connect/token")
                .then().log().body().extract().response();
        statusCode = response.getStatusCode();
        accessToken = response.jsonPath().get("access_token");
    }
}
