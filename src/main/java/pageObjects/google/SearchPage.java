package pageObjects.google;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage {

    @FindBy(xpath = "//input[@class='gLFyf gsfi']")
    private WebElement search_input;

    @FindBy(xpath = "//input[@class='gNO89b']")
    private WebElement submit;

    @Step("Get Search  input element")
    public WebElement get_search_input() {
        return search_input;
    }

    @Step("Get Submit  Button element")
    public WebElement get_submit_button() {
        return submit;
    }


}
