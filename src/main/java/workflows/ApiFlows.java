package workflows;

import extensions.ApiActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

import java.util.ArrayList;
import java.util.List;

public class ApiFlows extends CommonOps {

    @Step("Business Flow: Print List content")
    public static void print_list(List<String> list) {
        for (String item : list) {
            System.out.println(item);
        }
    }

    @Step("Business Flow: Get the number of total pages containing users")
    public static String get_total_pages() {
        return ApiActions.extractValueFromJSON(ApiActions.get(pathGet), "total_pages");
    }

    @Step("Business Flow: Get the number of total users ")
    public static int get_total_users() {
        return Integer.parseInt(ApiActions.extractValueFromJSON(ApiActions.get(pathGet), "total"));
    }


    @Step("Business Flow: Get List of users attribute from given page")
    public static List<String> get_list_of_users_attribute_by_page(String attribute, int page_number) {
        response = ApiActions.get(pathGet + "?page=" + Integer.toString(page_number));
        return ApiActions.extractListOfValuesFromJSON(response, attribute);
    }

    @Step("Business Flow: Get List of users attribute from all pages")
    public static List<String> get_list_of_users_attribute_from_all_pages(String attribute) {
        List<String> all_pages = new ArrayList<>();
        int total_pages = Integer.parseInt(get_total_pages());
        for (int i = 1; i <= total_pages; i++) {
            all_pages.addAll(get_list_of_users_attribute_by_page(attribute, i));
        }
        return all_pages;
    }

}
