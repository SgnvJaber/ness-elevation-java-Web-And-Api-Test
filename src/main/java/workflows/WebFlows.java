package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

import java.util.List;

public class WebFlows extends CommonOps {

    @Step("Business Flow: Search for an input")
    public static void search_text(String text) {
        UIActions.update_text(search.get_search_input(), text);
        UIActions.click(search.get_submit_button());
    }

    @Step("Business Flow: print Search Results")
    public static void print_search_results_links() {
        UIActions.print_list_by_attribute(results.get_list_of_results(), "href");
    }

    @Step("Business Flow: Get Links of search results")
    public static List<String> get_search_results() {
        return UIActions.get_values_by_attribute(results.get_list_of_results(), "text");
    }


}
