package IViVu;

import APIsIViVuFunctional.GetToken;
import Utils.HelperMethods;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class LinkCustomer {

    @BeforeTest (description = "Run API Link Customer",
            groups = {"iViVu"})
    public void setup() throws IOException {
        GetToken.getToken();
        APIsIViVuFunctional.LinkCustomer.linkCustomer();
    }

    @Test(description = "Verify status code of API Link Customer",
            groups = "iViVu")
    public void getStatusCodeLinkCustomer(){
        System.out.println("Status code of API Link Customer is: " + APIsIViVuFunctional.LinkCustomer.statusCode);
        HelperMethods.verifyStatusCode(APIsIViVuFunctional.LinkCustomer.statusCode);
    }

    @Test(description = "Verify Customer Id",
            groups = "iViVu")
    public void getCustomerId(){
        System.out.println("Customer Id of API Link Customer is: " + APIsIViVuFunctional.LinkCustomer.customerId);
    }
}
