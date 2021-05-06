package IViVu;

import Utils.HelperMethods;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ValidateVoucher {
    @BeforeTest(description = "Run API Validate Voucher",
            groups = "iViVu")
    public void setup(){
        APIsIViVuFunctional.ValidateVoucher.validateVoucher();
    }

    @Test(description = "Verify status code API Validate Voucher",
            groups = "iViVu")
    public void getStatusCodeValidateVoucher(){
        System.out.println("Status code of API Validate Voucher is: " + APIsIViVuFunctional.ValidateVoucher.statusCode);
        HelperMethods.verifyStatusCode(APIsIViVuFunctional.ValidateVoucher.statusCode);
    }

    @Test(description = "Verify status code API Validate Voucher",
            groups = "iViVu")
    public void getVoucherName(){
        System.out.println("Voucher Name of API Validate Voucher is: " + APIsIViVuFunctional.ValidateVoucher.voucherName);
    }
}
