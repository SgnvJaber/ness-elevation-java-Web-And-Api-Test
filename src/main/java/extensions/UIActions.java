package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.CommonOps;

import java.util.ArrayList;
import java.util.List;

public class UIActions extends CommonOps {

    @Step("Update element text")
    public static void update_text(WebElement elem, String text) {
        elem.sendKeys(text);
    }

    @Step("Send Keyboard Keys to input field")
    public static void keyboard_key(WebElement elem, Keys key) {
        elem.sendKeys(key);
    }

    @Step("Click on element")
    public static void click(WebElement elem) {
        elem.click();
    }

    @Step("Print Text from list of elements")
    public static void print_list(List<WebElement> elements) {
        for (WebElement elem : elements) {
            System.out.println(elem.getText());
        }
    }

    @Step("Print a list by a given attribute")
    public static void print_list_by_attribute(List<WebElement> elements, String attribute) {
        for (WebElement elem : elements) {
            System.out.println(elem.getAttribute(attribute));
        }
    }

    @Step("Return list of attribute values from elements list")
    public static List<String> get_values_by_attribute(List<WebElement> elements, String attribute) {
        List<String> values = new ArrayList<>();
        for (WebElement elem : elements) {
            values.add(elem.getAttribute(attribute));
        }
        return values;
    }


}
