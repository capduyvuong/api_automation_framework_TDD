package GameChallenge;

import APIsGameChallengeFunctional.*;
import Utils.GetVuiToken;
import Utils.HelperMethods;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestGameChallenge {
    @BeforeTest(description = "Run APIs",
            groups = "Game Challenge")
    public void setup() throws IOException {
        GetVuiToken.getVuiToken();
        GetAllRunningChallenges.getAllRunningChallenges();
        GetChallengeDetail.getChallengesDetail();
        JoinChallenge.joinChallenge();
        VerifyCustomerJoinedChallengeOnDB.verifyCustomerJoinedChallengeOnDB();
    }

    //  Test Get Token
    @Test(description = "Verify status code of API get token Game Challenge",
            groups = {"Game Challenge"})
    public void getStatusCodeAccessToken(){
        System.out.println("Status code of API Get Access Token is: " + GetVuiToken.statusCode);
        HelperMethods.verifyStatusCode(GetVuiToken.statusCode);
    }

    @Test(description = "Verify access token of API get token Game Challenge",
            groups = {"Game Challenge"})
    public void getAccessToken(){
        System.out.println("Access token is: " + GetVuiToken.accessToken);
    }

    //  Test all running challenge
    @Test (description = "Verify status code of API Get All Running Challenges",
            groups = "Game Challenge")
    public void getStatusCodeOfAllRunningChallenges(){
        System.out.println("Status code of API Get All Running Challenges: " + GetAllRunningChallenges.statusCode);
        HelperMethods.verifyStatusCode(GetAllRunningChallenges.statusCode);
    }

    @Test (description = "Verify Total of All Running Challenges",
            groups = "Game Challenge")
    public void getTotalOfAllRunningChallenges(){
        System.out.println("Total of All Running Challenges: " + GetAllRunningChallenges.totalOfChallenges);
        System.out.println("First Running Challenges ID: " + GetAllRunningChallenges.firstChallengeId);
        System.out.println("First Running Challenges Name: " + GetAllRunningChallenges.firstChallengeName);
    }

    //  Test Challenge Detail
    @Test (description = "Verify status code of API Get Challenge Detail",
            groups = "Game Challenge")
    public void getStatusCodeOfChallengeDetail(){
        System.out.println("Status code of API Challenges Detail: " + GetChallengeDetail.statusCode);
        HelperMethods.verifyStatusCode(GetChallengeDetail.statusCode);
    }

    @Test (description = "Verify Challenges name and status before joining game",
            groups = "Game Challenge")
    public void getChallengesNameAndStatusBeforeJoining(){
        System.out.println("Challenge name is: " + GetChallengeDetail.challengeName);
        System.out.println("Challenge status before joining game is: " + GetChallengeDetail.challengeJoinStatus);
        HelperMethods.verifyChallengeJoinStatusBeforeJoining(GetChallengeDetail.challengeJoinStatus);
    }

    //  Test Join Challenge
    @Test (description = "Verify status code of API Join Challenge",
            groups = "Game Challenge")
    public void getStatusCodeOfJoinChallenge(){
        System.out.println("Status code of API Challenges Detail: " + JoinChallenge.statusCode);
        HelperMethods.verifyStatusCode(JoinChallenge.statusCode);
    }

    @Test (description = "Verify Customer Challenge Status",
            groups = "Game Challenge")
    public void getCustomerChallengeStatus(){
        System.out.println("Customer Challenge Status is: " + JoinChallenge.challengeStatus);
    }

    // Test Joined Challenge on Database
    @Test(description = "Verify Joined Challenge on Database",
            groups = "Game Challenge")
    public void verifyJoinedChallengeOnDatabase() throws IOException {
        VerifyCustomerJoinedChallengeOnDB.verifyCustomerJoinedChallengeOnDB();
    }
}
