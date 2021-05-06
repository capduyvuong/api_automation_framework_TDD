package APIsIViVuFunctional;

import Utils.HelperMethods;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class GetCustomerInformation {
    public static int statusCode;
    public static String actualMobileNumber;
    public static void getCustomerInformation(){
        RestAssured.baseURI ="https://apigwdev.taptap.com.vn/api/ivivu";
        Response response = given()
                .contentType(JSON)
                .header("Authorization", "Bearer " + HelperMethods.environmentAccessToken())
                .param("brand", "ivivu")
                .when()
                .get("/v1/customers/" + HelperMethods.environmentCustomerId())
                .then().log().body().extract().response();
        statusCode = response.getStatusCode();
        actualMobileNumber = response.jsonPath().getString("data.mobile");
    }
}
