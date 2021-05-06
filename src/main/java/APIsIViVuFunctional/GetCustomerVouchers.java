package APIsIViVuFunctional;

import Utils.HelperMethods;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.given;

public class GetCustomerVouchers {
    public static int statusCode;
    public static ResponseBody body;
    public static void getCustomerVouchers(){
        RestAssured.baseURI = "https://apigwdev.taptap.com.vn/api/ivivu";
        Response response = given()
                .contentType("application/json;charset=UTF-8")
                .header("Authorization", "Bearer " + HelperMethods.environmentAccessToken())
//                .param("brand", "swensen")
                .when()
                .get("/v1/customers/" + HelperMethods.environmentCustomerId() + "voucher?brand=changthai")
                .then().log().body().extract().response();
        statusCode = response.getStatusCode();
//        JsonPath jsonPathEvaluator = response.jsonPath();
//        List<String> allIssuedVoucherCode = jsonPathEvaluator.getList("data.code");
//        for(String issuedVoucherCode : allIssuedVoucherCode)
//        {
//            return issuedVoucherCode;
//        }
        // Retrieve the body of the Response
        body = response.getBody();
//        return issuedVoucherCode;
    }
}
