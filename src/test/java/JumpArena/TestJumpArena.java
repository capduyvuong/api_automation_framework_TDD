package JumpArena;

import APIsJumpArenaFunctional.CreateCustomerJA;
import APIsJumpArenaFunctional.GetTokenJA;
import Utils.HelperMethods;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestJumpArena {
    @BeforeTest(description = "Run Jump Arena APIs",
            groups = "Jump Arena")
    public void setup() throws IOException {
        GetTokenJA.getTokenJA();
        CreateCustomerJA.createCustomerJA();
    }

    // Test Getting JA Token
    @Test(description = "Verify status code of API Generate JA Token",
            groups = "Jump Arena")
    public void getStatusCodeTokenJA(){
        System.out.println("Status code of API Jump Arena Token is: " + GetTokenJA.statusCode);
        HelperMethods.verifyStatusCode(GetTokenJA.statusCode);
    }
    // Test Getting JA Token
    @Test(description = "Verify status code of API Generate JA Token",
            groups = "Jump Arena")
    public void testCreatingCustomerJA(){
        System.out.println("Status code of API Create Customer Jump Arena is: " + CreateCustomerJA.statusCode);
        HelperMethods.verifyMessageCreatingCustomerJA(CreateCustomerJA.message);
    }

}
