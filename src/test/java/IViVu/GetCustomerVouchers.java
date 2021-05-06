package IViVu;

import Utils.HelperMethods;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetCustomerVouchers {
    @BeforeTest (description = "Run API to Get Customer Vouchers",
            groups = "iViVu")
    public void setup(){
        APIsIViVuFunctional.GetCustomerVouchers.getCustomerVouchers();
    }

    @Test (description = "Verify status code of API Get Customer Vouchers",
            groups = "iViVu")
    public void getStatusCodeCustomerVouchers(){
        System.out.println("Status code of API Get Customer Vouchers is: " + APIsIViVuFunctional.GetCustomerVouchers.statusCode);
        HelperMethods.verifyStatusCode(APIsIViVuFunctional.GetCustomerVouchers.statusCode);
    }

    @Test (description = "Verify Issued Vouchers Code",
            groups = "iViVu")
    public void getIssuedVouchersCode(){
//        System.out.println("Issued Vouchers Code is: " + SendRequestGetCustomerVouchers.issuedVoucherCode);
//        if (HelperMethods.verifyCustomerVouchers())
//            System.out.println("Voucher Code is issued as expectation");
//        else
//            System.out.println("Voucher Code is NOT issued as expectation");
                System.out.println("Response Body is: " + APIsIViVuFunctional.GetCustomerVouchers.body.toString());

    }
}
