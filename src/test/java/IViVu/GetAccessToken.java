package IViVu;

import APIsIViVuFunctional.GetToken;
import Utils.HelperMethods;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetAccessToken {

    @BeforeTest(description = "Run API to get token",
            groups = {"iViVu"})
    public void setup() {
        GetToken.getToken();
    }

    @Test(description = "Verify status code of API get token",
            groups = {"iViVu"})
    public void getStatusCodeAccessToken(){
        System.out.println("Status code of API Get Access Token is: " + GetToken.statusCode);
        HelperMethods.verifyStatusCode(GetToken.statusCode);
    }

    @Test(description = "Verify access token of API get token",
            groups = {"iViVu"})
    public void getAccessToken(){
        System.out.println("Access token is: " + GetToken.accessToken);
    }
}
