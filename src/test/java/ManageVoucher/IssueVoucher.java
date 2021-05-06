package ManageVoucher;

import Utils.HelperMethods;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class IssueVoucher {
    @BeforeTest (description = "Run API Issue Voucher",
            groups = "Voucher Management")
    public void setup() throws IOException {
        APIsManageVoucherFunctional.IssueVoucher.issueVoucher();
    }

    @Test (description = "Verify status code of API Issue Voucher",
            groups = "Voucher Management")
    public void getStatusCodeIssueVoucher(){
        System.out.println("Status code of API Issue Voucher is: " + APIsManageVoucherFunctional.IssueVoucher.statusCode);
        HelperMethods.verifyStatusCode(APIsManageVoucherFunctional.IssueVoucher.statusCode);
    }

    @Test (description = "Verify Voucher Code of API Issue Voucher",
            groups = "Voucher Management")
    public void getVoucherCode(){
        System.out.println("Voucher code of Customer is: " + APIsManageVoucherFunctional.IssueVoucher.voucherCode);
    }
}
