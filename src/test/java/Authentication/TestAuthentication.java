package Authentication;

import Utils.GenerateOTP;
import Utils.GenerateToken;
import Utils.HelperMethods;
import Utils.ValidateOTP;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestAuthentication {
    @BeforeTest(description = "Run 3 APIs",
        groups = "Authentication")
    public void setup() throws IOException {
        GenerateToken.generateToken();
        GenerateOTP.generateOTP();
        ValidateOTP.validateOTP();
    }
    // Test Generate Token
    @Test(description = "Verify status code of API Generate Token",
        groups = "Authentication")
    public void getStatusCodeGenerateToken(){
        System.out.println("Status code of API Generate Token is: " + GenerateToken.statusCodeGenerateToken);
        HelperMethods.verifyStatusCode(GenerateToken.statusCodeGenerateToken);
    }

    @Test(description = "Verify session Id of API Generate Token",
        groups = "Authentication")
    public void getSessionId(){
        System.out.println("Session ID of API Generate Token is: " + GenerateToken.sessionId);
    }

    // Test Generate OTP
    @Test(description = "Verify status code of API Generate OTP",
            groups = "Authentication")
    public void getStatusCodeGenerateOTP(){
        System.out.println("Status code of API Generate OTP is: " + GenerateOTP.statusCodeGenerateOTP);
        HelperMethods.verifyStatusCode(GenerateOTP.statusCodeGenerateOTP);
    }

    // Test Validate OTP
    @Test(description = "Verify status code of API Validate OTP",
            groups = "Authentication")
    public void getStatusCodeValidateOTP(){
        System.out.println("Status code of API Validate OTP is: " + ValidateOTP.statusCodeValidateOTP);
        HelperMethods.verifyStatusCode(ValidateOTP.statusCodeValidateOTP);
    }

    @Test(description = "Verify cap_access_token and vui_access_token of API Validate OTP",
            groups = "Authentication")
    public void getCapAndVuiAccessToken() {
        System.out.println("Cap Access Token is: " + ValidateOTP.cap_access_token);
        System.out.println("Vui Access Token is: " + ValidateOTP.vui_access_token);
    }
}
