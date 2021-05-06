package Utils;

import APIsIViVuFunctional.GetCustomerInformation;
import APIsIViVuFunctional.GetToken;
import APIsIViVuFunctional.LinkCustomer;
import APIsManageVoucherFunctional.IssueVoucher;
import APIsReferralChallengeFunctional.CreateRefCode;
import APIsReferralChallengeFunctional.GetMileStoneDetail;
import APIsReferralChallengeFunctional.GetRunningReferralChallenge;

import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class HelperMethods {
    /*
    Verify the http response status returned. Check Status Code is 200?
    We can use Rest Assured library's response's getStatusCode method
    */

    public static String voucherCode;
    public static String issuedVoucherCode;
    public static String voucherName;

    static Properties properties = new Properties();

//    public static String baseUukUatUrl = properties.getProperty("base_uukUat_Url");
//    public static final String FILE_CONFIG = "\\configs\\configuration.properties";

//    public static int customerPhoneNumber = Integer.parseInt(properties.getProperty("customer_phone_number"));

//    public static void loadConfiguration() throws IOException {
//        InputStream inputStream = null;
//        String currentDir = System.getProperty("user.dir");
//        inputStream = new FileInputStream(currentDir + FILE_CONFIG);
//        Properties properties = new Properties();
//        properties.load(inputStream);
//    }
//
//    public static void loadGwDevConfiguration() throws IOException {
//        InputStream inputStream = null;
//        String currentDir = System.getProperty("user.dir");
//        inputStream = new FileInputStream(currentDir + FILE_CONFIG);
//        properties.load(inputStream);
//        RestAssured.baseURI = properties.getProperty("base_apiGwDev_Url");
//    }

    public static String environmentAccessToken(){
        return GetToken.accessToken;
    }

    public static String environmentCustomerId(){
        return LinkCustomer.customerId;
    }

    public static String environmentVoucherCode(){
        return IssueVoucher.voucherCode;
    }

    public static void verifyStatusCode(int statusCode){
        if(statusCode == 200)
            System.out.println("TEST PASSED");
        else
            System.out.println("TEST FAILED");
    }

    public static void verifyMessageCreatingCustomerJA(String message){
        if(message == "true")
            System.out.println("TEST PASSED");
        else
            System.out.println("TEST FAILED");
    }

    public static void verifyChallengeJoinStatusBeforeJoining(String ChallengeJoinStatusBeforeJoining){
        if (ChallengeJoinStatusBeforeJoining.equals("NOT_YET"))
            System.out.println("TEST PASSED");
        else
            System.out.println("TEST FAILED");
    }

    public static void verifyChallengeJoinStatusAfterJoining(String ChallengeJoinStatusAfterJoining){
        if (ChallengeJoinStatusAfterJoining.equals("ALREADY"))
            System.out.println("TEST PASSED");
        else
            System.out.println("TEST FAILED");
    }

    public static void verifyCustomerMobileNumber() {
        if (GetCustomerInformation.actualMobileNumber.equals(LinkCustomer.expectedMobileNumber))
            System.out.println("TEST PASSED");
        else
            System.out.println("TEST FAILED");
    }

    public static void verifyCreatedRefCode(){
        if (CreateRefCode.actualRefCode.equals(GetRunningReferralChallenge.refCode))
            System.out.println("TEST PASSED");
        else
            System.out.println("TEST FAILED");
    }

    public static void verifyMessageContent(String messageContent){
        if (messageContent.equals("Mã bị trùng"))
            System.out.println("TEST PASSED");
        else
            System.out.println("TEST FAILED");
    }

    public static void verifyMileStoneDetailId(){
        if (GetMileStoneDetail.mileStoneDetailId.equals(GetRunningReferralChallenge.milestoneId))
            System.out.println("TEST PASSED");
        else
            System.out.println("TEST FAILED");
    }
}
