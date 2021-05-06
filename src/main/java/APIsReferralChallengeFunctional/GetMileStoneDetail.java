package APIsReferralChallengeFunctional;

import Utils.GetVuiToken;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class GetMileStoneDetail {
    public static int statusCode;
    public static String mileStoneDetailId;
    public static String mileStoneName;
    public static final String FILE_CONFIG = "\\configs\\configuration.properties";

    public static void getMileStoneDetail() throws IOException{
        InputStream inputStream = null;
        String currentDir = System.getProperty("user.dir");
        inputStream = new FileInputStream(currentDir + FILE_CONFIG);
        Properties properties = new Properties();
        properties.load(inputStream);
        RestAssured.baseURI = properties.getProperty("gateway_host_referral");
//        String mileStoneDetailJsonBody = "{" +
//                "\n" +
//                "\"refcode\": \"" + expectedRefCode + "\"" +
//                ",\n" +
//                " \"mobile\": \"" + properties.getProperty("customer_phone_number") + "\"" +
//                "\n" +
//                "}";
        Response response = given()
                .header("Authorization", "Bearer " + GetVuiToken.accessToken)
                .param("mobile", properties.getProperty("customer_phone_number"))
//                .body(mileStoneDetailJsonBody)
                .when()
                .get("/api/referral/v1/challenges/mo/milestones/" + GetRunningReferralChallenge.milestoneId)
                .then().log().body().extract().response();
        statusCode = response.getStatusCode();
        mileStoneDetailId = response.getBody().jsonPath().getString("data.id");
        mileStoneName = response.getBody().jsonPath().getString("data.name");
    }
}
