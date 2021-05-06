package APIsIViVuFunctional;

import Utils.HelperMethods;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.*;
import java.util.Properties;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class LinkCustomer {
    public static int statusCode;
    public static String customerId;
    public static String expectedMobileNumber;
    public static final String FILE_CONFIG = "\\configs\\configuration.properties";

    public static void linkCustomer() throws IOException {
        File customerData = new File("src\\main\\resources\\LinkedCustomerData");
        InputStream inputStream = null;
        String currentDir = System.getProperty("user.dir");
        inputStream = new FileInputStream(currentDir + FILE_CONFIG);
        Properties properties = new Properties();
        properties.load(inputStream);
        RestAssured.baseURI = properties.getProperty("base_apiGwDev_Url");
        Response response = given()
                .contentType(JSON)
                .header("Authorization", "Bearer " + HelperMethods.environmentAccessToken())
                .body(customerData)
                .when()
                .post("/api/ivivu/v1/customers/link")
                .then().log().body().extract().response();
        statusCode = response.getStatusCode();
        customerId = response.jsonPath().getString("data.id");
        expectedMobileNumber = response.jsonPath().getString("data.mobile");
    }
}
