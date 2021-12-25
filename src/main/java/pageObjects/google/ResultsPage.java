package pageObjects.google;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ResultsPage {

    @FindBy(xpath = "//div[@class='yuRUbf']/a")
    private List<WebElement> search_results;

    @Step("Get a list of results elements")
    public List<WebElement> get_list_of_results() {
        return search_results;
    }


}
