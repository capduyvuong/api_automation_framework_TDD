package IViVu;

import APIsIViVuFunctional.LinkCustomer;
import Utils.HelperMethods;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetCustomerInformation {
    @BeforeTest (description = "Run API to Get List Customer Information",
            groups = "iViVu")
    public void setup() throws IOException {
        LinkCustomer.linkCustomer();
        APIsIViVuFunctional.GetCustomerInformation.getCustomerInformation();
    }

    @Test (description = "Verify status code of API List Customer Information",
            groups = "iViVu")
    public void getStatusCodeCustomerInformation(){
        System.out.println("Status code of API List Customer Information is: " + APIsIViVuFunctional.GetCustomerInformation.statusCode);
        HelperMethods.verifyStatusCode(APIsIViVuFunctional.GetCustomerInformation.statusCode);
    }

    @Test (description = "Verify Customer Mobile Number",
            groups = "iViVu")
    public void getCustomerMobileNumber(){
        System.out.println("Expected Mobile number of customers is: " + LinkCustomer.expectedMobileNumber);
        System.out.println("Actual Mobile number of customers is: " + APIsIViVuFunctional.GetCustomerInformation.actualMobileNumber);
        HelperMethods.verifyCustomerMobileNumber();
    }
}
