package extensions;

import io.qameta.allure.Step;
import org.testng.Assert;
import utilities.CommonOps;

import java.util.List;

public class Verifications extends CommonOps {

    @Step("Verify given integers are equal")
    public static void verifyInt(int actual, int exp) {
        Assert.assertEquals(actual, exp);
    }

    @Step("Verify given strings are equal")
    public static void verifyString(String actual, String exp) {
        Assert.assertEquals(actual, exp);
    }

    @Step("Verify a given string contains a given keyword ")
    public static void verifyStringContains(String actual, String keyword) {
        Assert.assertTrue(actual.contains(keyword));
    }

    @Step("Verify List contains a given value")
    public static void verifyListContains(List<String> list, String exp) {
        Assert.assertTrue(list.contains(exp));
    }


}
