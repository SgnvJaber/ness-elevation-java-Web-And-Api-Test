import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ApiFlows;

import java.util.List;

public class ReqresApi extends CommonOps {

    @Test(description = "ReqRes List of Emails")
    @Description("Using ReqRes Api print all emails in all pages")
    public void Test01_ReqRes_Emails() {
        List<String> values = ApiFlows.get_list_of_users_attribute_from_all_pages("data.email");
        ApiFlows.print_list(values);
        Verifications.verifyInt(values.size(), ApiFlows.get_total_users());

    }

}
