package APIsManageVoucherFunctional;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class IssueVoucher {
    public static int statusCode;
    public static String voucherCode;
    public static final String FILE_CONFIG = "\\configs\\configuration.properties";

    public static void issueVoucher() throws IOException {
        File issueVoucherData = new File("src\\main\\resources\\IssueVoucherData");
        InputStream inputStream = null;
        String currentDir = System.getProperty("user.dir");
        inputStream = new FileInputStream(currentDir + FILE_CONFIG);
        Properties properties = new Properties();
        properties.load(inputStream);
        RestAssured.baseURI = properties.getProperty("base_capillary_Url");
        Response response = given()
                .auth()
                .preemptive()
                .basic("vig.apiauthentication", "b540003a6fbdf297ed1357288fb65460")
                .contentType("application/json")
                .body(issueVoucherData)
                .when()
                .post("/v1.1/coupon/issue?format=json")
                .then().log().body().extract().response();
        statusCode = response.getStatusCode();
        voucherCode = response.jsonPath().getString("response.coupon.code");
    }
}
