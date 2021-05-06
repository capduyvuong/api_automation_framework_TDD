package APIsGameChallengeFunctional;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class AddTransaction {
    public static int statusCode;
    public static final String FILE_CONFIG = "\\configs\\configuration.properties";

    public static void addTransaction() throws IOException {
        File transactionData = new File("src\\main\\resources\\TransactionData");
        InputStream inputStream = null;
        String currentDir = System.getProperty("user.dir");
        inputStream = new FileInputStream(currentDir + FILE_CONFIG);
        Properties properties = new Properties();
        properties.load(inputStream);
        RestAssured.baseURI = properties.getProperty("base_apiGwDev_Url");
        Response response = given()
        .header("Authorization", "Basic ZHdodGVzdGFjYzp0ZXN0c3luREB3aA==")
        .contentType("application/json")
        .body(transactionData)
        .when()
        .post("/api/dwh/v1.0.0/transactions")
        .then().log().body().extract().response();
        statusCode = response.getStatusCode();
    }
}
