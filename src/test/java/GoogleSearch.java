import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

public class GoogleSearch extends CommonOps {

    @Test(description = "Google Search")
    @Description("Search for a given input using Google Search bar and verify it is contained in the first result")
    public void Test01_GoogleSearch() {
        WebFlows.search_text("Java");
        WebFlows.print_search_results_links();
        Verifications.verifyStringContains(WebFlows.get_search_results().get(0), "Java");
    }


}
