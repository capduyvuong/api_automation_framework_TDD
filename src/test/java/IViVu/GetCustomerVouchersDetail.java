package IViVu;

import Utils.HelperMethods;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetCustomerVouchersDetail {
    @BeforeTest (description = "Run API to Get Customer Voucher Detail",
            groups = "iViVu")
    public void setup(){
        APIsIViVuFunctional.GetCustomerVouchersDetail.getCustomerVouchers();
    }

    @Test (description = "Verify status code of API Get Customer Voucher Detail",
            groups = "iViVu")
    public void getStatusCodeCustomerVoucherDetail(){
        System.out.println("Status code of API Get Customer Voucher Detail is: " + APIsIViVuFunctional.GetCustomerVouchersDetail.statusCode);
        HelperMethods.verifyStatusCode(APIsIViVuFunctional.GetCustomerVouchersDetail.statusCode);
    }

    @Test (description = "Verify Customer Voucher Name",
            groups = "iViVu")
    public void getCustomerVoucherName(){
        System.out.println("Customer Voucher Name is: " + APIsIViVuFunctional.GetCustomerVouchersDetail.voucherName);
    }
}
