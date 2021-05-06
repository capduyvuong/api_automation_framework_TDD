package GameChallenge;

import APIsGameChallengeFunctional.AddTransaction;
import Utils.HelperMethods;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestAddTransaction {
    @BeforeTest (description = "Run API Add Transaction to win game challenge",
        groups = "Game Challenge")
    public void setup() throws IOException {
        AddTransaction.addTransaction();
    }

    @Test (description = "Verify the status code of API Add Transaction",
        groups = "Game Challenge")
    public void getStatusCodeAPIAddTransaction(){
        System.out.println("The status code of API Add Transaction is: " + AddTransaction.statusCode);
        HelperMethods.verifyStatusCode(AddTransaction.statusCode);
    }
}
