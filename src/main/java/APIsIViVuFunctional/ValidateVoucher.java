package APIsIViVuFunctional;

import Utils.HelperMethods;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ValidateVoucher {
    public static int statusCode;
    public static String voucherName;
    public static void validateVoucher(){
        RestAssured.baseURI = "https://apigwdev.taptap.com.vn/api/ivivu";
        Response response = given()
                .log().body()
                .contentType("application/json")
                .header("Authorazation","Bearer" + HelperMethods.environmentAccessToken())
                .param("code", HelperMethods.environmentVoucherCode())
                .param("id", HelperMethods.environmentCustomerId())
                .param("store_code", "")
                .when()
                .get("/v1/vouchers/validate")
                .then().log().body().extract().response();
        statusCode = response.getStatusCode();
        voucherName = response.jsonPath().getString("data.name");

    }
}
