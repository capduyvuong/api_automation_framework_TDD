package ReferralChallenge;

import APIsReferralChallengeFunctional.*;
import Utils.GetVuiToken;
import Utils.HelperMethods;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestReferralChallenge {
    @BeforeTest(description = "Run 4 APIs Referral Challenge",
            groups = "Referral Challenge")
    public void setup() throws IOException {
        GetVuiToken.getVuiToken();
        GetRunningReferralChallenge.getRunningReferralChallenge();
//        CreateRefCode.createRefCode();
//        GetRunningReferralChallenge.getRunningReferralChallenge();
        VerifyRefCode.verifyRefCode();
        GetMileStoneDetail.getMileStoneDetail();
        RegisterNewReferee.registerNewReferee();
    }

//  Test API Running Referral Challenge

    @Test(description = "Verify status code of API Running Referral Challenge",
            groups = {"Referral Challenge"})
    public void getStatusCodeRunningReferral(){
        System.out.println("Status code of API Get All Running Referral Challenge is: " + GetRunningReferralChallenge.statusCode);
        HelperMethods.verifyStatusCode(GetRunningReferralChallenge.statusCode);
    }

    @Test(description = "Verify referral code of Running Referral Challenge",
            groups = {"Referral Challenge"})
    public void getRunningReferralCodeAndName(){
        System.out.println("Referral code of Running Referral Challenge is: " + GetRunningReferralChallenge.refCode);
        System.out.println("MileStone Id of Running Referral Challenge is: " + GetRunningReferralChallenge.milestoneId);
        System.out.println("Referral code of Running Referral Challenge is: " + GetRunningReferralChallenge.runningRefName);
    }

//  Test API create Referral Code

//    @Test(description = "Verify status code of API create Referral Code",
//            groups = {"Referral Challenge"})
//    public void getStatusCodeCreateReferralCode(){
//        System.out.println("Status code of API create Referral Code is: " + CreateRefCode.statusCode);
//        HelperMethods.verifyStatusCode(CreateRefCode.statusCode);
//    }
//
//    @Test(description = "Verify created referral code",
//            groups = {"Referral Challenge"})
//    public void verifyCreatedReferralCode(){
//        System.out.println("Referral code of Running Referral Challenge is: " + CreateRefCode.actualRefCode);
//        HelperMethods.verifyCreatedRefCode();
//    }

    //  Test API Verify created Referral Code

    @Test(description = "Verify status code of API verify created Referral Code",
            groups = {"Referral Challenge"})
    public void getStatusCodeVerifyCreateReferralCode(){
        System.out.println("Status code of API Verify Created Referral Challenge is: " + VerifyRefCode.statusCode);
//        HelperMethods.verifyStatusCode(VerifyRefCode.statusCode);
    }

    @Test(description = "Verify message content",
            groups = "Referral Challenge")
    public void verifyMessageContent(){
        System.out.println("Message content is: " + VerifyRefCode.messageContent);
        HelperMethods.verifyMessageContent(VerifyRefCode.messageContent);
    }

    //  Test API Get MileStone Detail

    @Test(description = "Verify status code of API Referral MileStone Detail",
            groups = {"Referral Challenge"})
    public void getStatusCodeReferralMileStoneDetail(){
        System.out.println("Status code of API Referral MileStone Detail is: " + GetMileStoneDetail.statusCode);
        HelperMethods.verifyStatusCode(GetMileStoneDetail.statusCode);
    }

    @Test(description = "Verify ID of MileStone Detail",
            groups = {"Referral Challenge"})
    public void getMileStoneDetailIdAndName() {
        System.out.println("ID of Referral MileStone Detail is: " + GetMileStoneDetail.mileStoneDetailId);
        System.out.println("Name of Referral MileStone is: " + GetMileStoneDetail.mileStoneName);
        HelperMethods.verifyMileStoneDetailId();
    }

    //  Test API Register Referee

    @Test(description = "Verify status code of API Register Referee",
            groups = {"Referral Challenge"})
    public void getStatusCodeRegisterReferee(){
        System.out.println("Status code of API Register Referee is: " + RegisterNewReferee.statusCode);
        HelperMethods.verifyStatusCode(RegisterNewReferee.statusCode);
    }
}
