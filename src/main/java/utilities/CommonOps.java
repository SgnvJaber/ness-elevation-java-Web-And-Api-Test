package utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.w3c.dom.Document;

public class CommonOps extends Base {
    @BeforeClass
    @Parameters({"Platform", "Browser"})
    public void startSession(@Optional("Optional Parameter") String platform, @Optional("Optional Parameter") String browser) throws Exception {
        switch (platform.toLowerCase()) {
            case "web":
                casesSwitch(browser);
                web_init();
                break;
            case "api":
                api_init();
                break;
            default:
                throw new Exception("Invalid platform");
        }
    }

    @BeforeMethod
    @Parameters({"Platform"})
    public void beforeMethod(String platform, Method method) {
        if (!(platform.equals("api")))
            try {
                MonteScreenRecorder.startRecord(method.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    @AfterClass
    @Parameters({"Platform"})
    public void closeSession(String platform) {
        switch (platform) {
            case "web":
                driver.quit();
            case "api":
                break;
            default:
                driver.quit();
                break;
        }
    }

    @Step("Switch Cases according to platform")
    private void casesSwitch(String browser) throws Exception {
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "opera":
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
                break;
            default:
                throw new Exception("Invalid browser");
        }
    }

    @Step("A function to initialize the web session ")
    private void web_init() {
        initWebURL();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
        ManagePages.initWebPages();
    }

    @Step("A function to initialize the Api session ")
    private void api_init() {
        initApiURL();
        pathGet = getData("pathGet");
        RestAssured.baseURI = url;
        request = RestAssured.given();
        request.header("Content-Type", "application/json");
    }


    @Step("Getting data from the configuration file")
    protected static String getData(String nodeName) {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("Config/ConfigFile.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        } catch (Exception e) {
            System.out.println("Exception in reading XML file: " + e);
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }

    @Step("Initiating Web url variable")
    public static void initWebURL() {
        url = getData("webUrl");
    }

    @Step("Initiating url variable")
    public static void initApiURL() {
        url = getData("apiUrl");
    }
}
