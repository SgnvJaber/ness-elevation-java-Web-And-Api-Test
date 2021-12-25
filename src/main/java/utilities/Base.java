package utilities;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.google.ResultsPage;
import pageObjects.google.SearchPage;

public class Base {

    //WEB
    protected static WebDriver driver;
    protected static String url;
    protected static SearchPage search;
    protected static ResultsPage results;

    //API
    protected static RequestSpecification request;
    protected static Response response;
    protected static JsonPath jp;
    protected static JSONObject params;
    protected static WebDriverWait wait;
    protected static String pathGet;
    protected static String pathPost;

}
