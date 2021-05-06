package APIsJumpArenaFunctional;

import Information.CustomerInfo;
import Utils.GetVuiToken;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class CreateCustomerJA {
    public static int statusCode;
    public static String message;
    public static final String FILE_CONFIG = "\\configs\\configuration.properties";

    public static void createCustomerJA() throws IOException {
        File CreateCustomerJA = new File("src\\main\\resources\\CreateCustomerJA1");
        InputStream inputStream = null;
        String currentDir = System.getProperty("user.dir");
        inputStream = new FileInputStream(currentDir + FILE_CONFIG);
        Properties properties = new Properties();
        properties.load(inputStream);
        RestAssured.baseURI = properties.getProperty("gateway_host_jump_arena");

        CustomerInfo customerInfo = new CustomerInfo();
        Faker faker = new Faker();
        customerInfo.setFirstName(faker.name().firstName());
/*        String CreateCustomerJAJsonBody =
                "{" +
                "\"first_name\": \"" + properties.getProperty("first_name_JA") + "\",\n" +
                "\"last_name\": \"" + properties.getProperty("last_name_JA") + "\",\n" +
                "\"email\": \"" + properties.getProperty("email_JA") + "\",\n" +
                "\"mobile\": \"" + properties.getProperty("mobile_JA") + "\",\n" +
                "\"gender\": \"" + properties.getProperty("gender_JA") + "\",\n" +
                "\"dob\": \"" + properties.getProperty("dob_JA") + "\",\n" +
                "\"external_id\": \"" + properties.getProperty("external_id_JA") + "\",\n" +
                "\"created_on\": \"" + properties.getProperty("created_on_JA") + "\",\n" +
                "\"created_by\": \"" + properties.getProperty("created_by_JA") + "\",\n" +
                "\"registered_store\": \"" + properties.getProperty("registered_store_JA") + "\",\n" +
                "\"group\": \"" + properties.getProperty("group_JA") + "\",\n" +
                "\"address\": \"" + properties.getProperty("address_JA") + "\",\n" +
                "\"district\": \"" + properties.getProperty("district_JA") + "\",\n" +
                "\"city\": \"" + properties.getProperty("city_JA") + "\",\n" +
                "\"member_type\": \"" + properties.getProperty("member_type_JA") + "\",\n" +
                "\"description\": \"" + properties.getProperty("description_JA") + "\",\n" +
                "\"residential_type\": \"" + properties.getProperty("residential_type_JA") + "\",\n" +
                "\"acquisition_channel\": \"" + properties.getProperty("acquisition_channel_JA") + "\",\n" +
                "\"source_of_customers\": \"" + properties.getProperty("source_of_customers_JA") + "\",\n" +
                "\"reference_name\": \"" + properties.getProperty("reference_name_JA") + "\",\n" +
                "\"reference_email\": \"" + properties.getProperty("reference_email_JA") + "\",\n" +
                "\"reference_mobile\": \"" + properties.getProperty("reference_mobile_JA") + "\",\n" +
                "\"waiver_skill\": \"" + properties.getProperty("waiver_skill_JA") + "\",\n" +
                "\"social_account\": \"" + properties.getProperty("social_account_JA") + "\",\n" +
                "\"family_member\": " +
                "\"[ { \" " +
                        "\"name\": \"" + properties.getProperty("family_member_name1_JA") + "\",\n" +
                        "\"email\": \"" + properties.getProperty("family_member_email1_JA") + "\",\n" +
                        "\"mobile\": \"" + properties.getProperty("family_member_mobile1_JA") + "\",\n" +
                        "\"gender\": \"" + properties.getProperty("family_member_gender1_JA") + "\",\n" +
                        "\"dob\": \"" + properties.getProperty("family_member_dob1_JA") + "\",\n" +
                        "\"waiver_relationship\": \"" + properties.getProperty("waiver_relationship1_JA") + "\" \n" +
                    "\" },{ \" " +
                            "\"name\": \"" + properties.getProperty("family_member_name2_JA") + "\",\n" +
                            "\"email\": \"" + properties.getProperty("family_member_email2_JA") + "\",\n" +
                            "\"mobile\": \"" + properties.getProperty("family_member_mobile2_JA") + "\",\n" +
                            "\"gender\": \"" + properties.getProperty("family_member_gender2_JA") + "\",\n" +
                            "\"dob\": \"" + properties.getProperty("family_member_dob2_JA") + "\",\n" +
                            "\"waiver_relationship\": \"" + properties.getProperty("waiver_relationship2_JA") + "\" \n" +
                    "\" } ] \" " +
                "}";
 */
        String CreateCustomerJAJsonBody = "{\"first_name\":\"Giang\",\"last_name\":\"Nguyen\",\"email\":\"test84965708094@gmail.com\",\"mobile\":\"84965708094\",\"gender\":\"male\",\"dob\":\"2000-09-20\",\"external_id\":\"JA123\",\"created_on\":\"2020-09-20T10:00:00\",\"created_by\":\"ja q7\",\"registered_store\":\"JAECOM\",\"group\":\"Group\",\"address\":\"Address\",\"district\":\"district\",\"city\":\"City\",\"member_type\":\"member_type\",\"description\":\"description\",\"residential_type\":\"residential_type\",\"acquisition_channel\":\"acquisition_channel\",\"source_of_customers\":\"source_of_customers\",\"reference_name\":\"reference_name\",\"reference_email\":\"reference_email\",\"reference_mobile\":\"reference_mobile\",\"waiver_skill\":\"Waiver_Skill\",\"social_account\":\"Social_account\",\"family_member\":[{\"name\":\"Giang\",\"email\":\"test123@gmail.com\",\"mobile\":\"84965708090\",\"gender\":\"male\",\"dob\":\"2000-09-20\",\"waiver_relationship\":\"waiver_relationship\"},{\"name\":\"Giang\",\"email\":\"test123@gmail.com\",\"mobile\":\"84965708090\",\"gender\":\"male\",\"dob\":\"2000-09-20\",\"waiver_relationship\":\"waiver_relationship\"}]}";
        Response response = given()
                .contentType("application/json")
                .header("Authorization", "Bearer " + GetTokenJA.accessTokenJA)
                .body(CreateCustomerJA)
                .when()
                .post("/v2/customers")
                .then().log().body().extract().response();
        statusCode = response.getStatusCode();
        message = response.getBody().jsonPath().getString("status.success");
    }
}
