package utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import pageObjects.google.ResultsPage;
import pageObjects.google.SearchPage;

public class ManagePages extends CommonOps {

    @Step("Initiate web pages")
    public static void initWebPages() {
        search = PageFactory.initElements(driver, SearchPage.class);
        results = PageFactory.initElements(driver, ResultsPage.class);
    }


}
