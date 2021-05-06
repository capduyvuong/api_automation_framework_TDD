package APIsIViVuFunctional;

import Utils.HelperMethods;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetCustomerVouchersDetail {
    public static int statusCode;
    public static String voucherName;

    public static void getCustomerVouchers(){
        System.out.println("Voucher code of Customer is: " + HelperMethods.environmentVoucherCode());

        RestAssured.baseURI = "https://apigwdev.taptap.com.vn/api/ivivu";
        Response response = given()
                .contentType("application/json")
                .header("Authorization", "Bearer " + HelperMethods.environmentAccessToken())
                .when()
                .get("/v1/customers/" + HelperMethods.environmentCustomerId() + "/voucher/3USZ4FZ")
                .then().log().body().extract().response();
        statusCode = response.getStatusCode();
        voucherName = response.getBody().jsonPath().getString("data.name");
    }
}
