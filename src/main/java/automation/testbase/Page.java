package automation.testbase;

import automation.listeners.ExtentListeners;
import automation.pages.LoginPage;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.testng.Assert.assertEquals;

/**
 * <b>PAGES : TEST BASE</b> [Page]: Page
 */
public class Page {
    public static WebDriver driver;
    public static Properties config = new Properties();
    public static FileInputStream fis;
    public static WebDriverWait wait;
    public static String browser;
    public static TopMenu topMenu;
    public static LoginPage loginPage;

    /**
     * <b>[Constructor]</b> - Page<br>
     * <br>
     * <i>Constructor functionality:</i><br>
     * This constructor initializes class attribute<br>
     * <i>All initialization is done in this class <b>[WebDriver, Properties, FileInput, ExcelReader, WebDriverWait, Browser, Menu, WebElement]</b></i><br>
     */
    public Page() {
        if (driver == null) {
            try {
                //Load Config.properties file
                fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
                config.load(fis);

            } catch (IOException e) {
                e.printStackTrace();
            }

            //Jenkins Browser filter configuration
            if (System.getenv("browser") != null && !System.getenv("browser").isEmpty()) {
                browser = System.getenv("browser");
            } else {
                browser = config.getProperty("browser");
            }

            config.setProperty("browser", browser);

            //Run the relevant web driver for relevant specified browser as specified in Config.properties file
            if (config.getProperty("browser").equals("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else if (config.getProperty("browser").equals("chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(options);
            }
            driver.get(config.getProperty("sutUrl"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicit.wait"))));
            wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            topMenu = new TopMenu(driver);
        }
    }


    /**
     * <b>[Method]</b> - Quit Browser<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality Quits opened Browser<br>
     */
    public static void quit() {
        driver.quit();
        driver = null;
    }

    /*-----COMMON KEYWORDS: click, type, getText, getElementsTexts, getElements, waitForPageToLoad-----*/

    /**
     * <b>[Method]</b> - Click on Element<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality clicks on element located on page.
     * Has logic to find the element based on the locator that this method receives as input parameter<br>
     *
     * @param elementBy By
     * @throws StaleElementReferenceException   exception
     * @throws ElementClickInterceptedException exception
     * @throws TimeoutException                 exception
     */

    public static void click(By elementBy) throws StaleElementReferenceException, ElementClickInterceptedException, TimeoutException {
        String element = elementBy.toString();
        String[] locator = element.split("\\.");
        String[] locatorType = locator[1].split("[:]");
        int attempts = 0;
        boolean success = false;

        while (!success && attempts < 3) {
            switch (locatorType[0]) {
                case "cssSelector":
                    wait.until(ExpectedConditions.elementToBeClickable(elementBy));
                    driver.findElement(elementBy).click();
                    ExtentListeners.test.log(Status.PASS, "Clicking on element: " + elementBy);
                    success = true;
                    break;

                case "xpath":
                    wait.until(ExpectedConditions.elementToBeClickable(elementBy));
                    driver.findElement(elementBy).click();
                    ExtentListeners.test.log(Status.PASS, "Clicking on element: " + elementBy);
                    success = true;
                    break;

                case "id":
                    wait.until(ExpectedConditions.elementToBeClickable(elementBy));
                    driver.findElement(elementBy).click();
                    ExtentListeners.test.log(Status.PASS, "Clicking on element: " + elementBy);
                    success = true;
                    break;

                default:
                    attempts++;
            }
        }
    }

    /**
     * <b>[Method]</b> - Send Value to Element<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality sends value to element on page.
     * Has logic to find the element based on the locator that this method receives as input parameter
     * and to pass the value received through second input parameter to the element<br>
     *
     * @param elementBy By
     * @param value     String
     * @throws StaleElementReferenceException   exception
     * @throws ElementClickInterceptedException exception
     * @throws TimeoutException                 exception
     */
    public static void type(By elementBy, String value) throws StaleElementReferenceException, ElementClickInterceptedException, TimeoutException {
        String element = elementBy.toString();
        String[] locator = element.split("\\.");
        String[] locatorType = locator[1].split("[:]");
        int attempts = 0;
        boolean success = false;

        while (!success && attempts < 3) {
            switch (locatorType[0]) {
                case "cssSelector":
                    wait.until(ExpectedConditions.elementToBeClickable(elementBy));
                    driver.findElement(elementBy).sendKeys(value);
                    ExtentListeners.test.log(Status.PASS, "Populating field: " + elementBy + " with value: " + value);
                    success = true;
                    break;

                case "xpath":
                    wait.until(ExpectedConditions.elementToBeClickable(elementBy));
                    driver.findElement(elementBy).sendKeys(value);
                    ExtentListeners.test.log(Status.PASS, "Populating field: " + elementBy + " with value: " + value);
                    success = true;
                    break;

                case "id":
                    wait.until(ExpectedConditions.elementToBeClickable(elementBy));
                    driver.findElement(elementBy).sendKeys(value);
                    ExtentListeners.test.log(Status.PASS, "Populating field: " + elementBy + " with value: " + value);
                    success = true;
                    break;

                default:
                    attempts++;
            }
        }
    }

    /**
     * <b>[Method]</b> - Get Text from Element<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality get text from element on page.
     * Has logic to find the element based on the locator that this method receives as input parameter,
     * and retrieves value which this element has as text<br>
     *
     * @param elementBy By
     * @throws StaleElementReferenceException   exception
     * @throws ElementClickInterceptedException exception
     * @throws TimeoutException                 exception
     */
    public static String getText(By elementBy) {

        return getElement(elementBy).getText();
    }

    /**
     * <b>[Method]</b> - Get Element<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality provides locating an element on page.<br>
     * Has logic to find the element based on the locator that this method receives as input parameter,<br>
     * and retrieve an element<br>
     *
     * @param elementBy By
     * @throws StaleElementReferenceException   exception
     * @throws ElementClickInterceptedException exception
     * @throws TimeoutException                 exception
     */
    public static WebElement getElement(By elementBy) throws StaleElementReferenceException, ElementClickInterceptedException, TimeoutException {
        String elementString = elementBy.toString();
        String[] locator = elementString.split("\\.");
        String[] locatorType = locator[1].split("[:]");
        int attempts = 0;
        boolean success = false;
        WebElement element = null;

        while (!success && attempts < 3) {
            switch (locatorType[0]) {
                case "cssSelector":
                    wait.until(ExpectedConditions.elementToBeClickable(elementBy));
                    element = driver.findElement(elementBy);
                    ExtentListeners.test.log(Status.PASS, "Taking the element: " + elementBy);
                    success = true;
                    break;

                case "xpath":
                    wait.until(ExpectedConditions.elementToBeClickable(elementBy));
                    element = driver.findElement(elementBy);
                    ExtentListeners.test.log(Status.PASS, "Taking the element: " + elementBy);
                    success = true;
                    break;

                case "id":
                    wait.until(ExpectedConditions.elementToBeClickable(elementBy));
                    element = driver.findElement(elementBy);
                    ExtentListeners.test.log(Status.PASS, "Taking the element: " + elementBy);
                    success = true;
                    break;

                default:
                    attempts++;
            }
        }
        return element;
    }

    /**
     * <b>[Method]</b> - Get Elements<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality provides locating multiple elements which have same locater on page.
     * Has logic to find the elements based on the locator that this method receives as input parameter,
     * and retrieves an element list<br>
     *
     * @param elementBy By
     * @throws StaleElementReferenceException   exception
     * @throws ElementClickInterceptedException exception
     * @throws TimeoutException                 exception
     */
    public static List<WebElement> getElements(By elementBy) throws StaleElementReferenceException, ElementClickInterceptedException, TimeoutException {
        String elementString = elementBy.toString();
        String[] locator = elementString.split("\\.");
        String[] locatorType = locator[1].split("[:]");
        int attempts = 0;
        boolean success = false;
        List<WebElement> elements = new ArrayList<>();

        while (!success && attempts < 3) {
            switch (locatorType[0]) {
                case "cssSelector":
                    wait.until(ExpectedConditions.elementToBeClickable(elementBy));
                    elements = driver.findElements(elementBy);
                    ExtentListeners.test.log(Status.PASS, "Taking the elements: " + elementBy);
                    success = true;
                    break;

                case "xpath":
                    wait.until(ExpectedConditions.elementToBeClickable(elementBy));
                    elements = driver.findElements(elementBy);
                    ExtentListeners.test.log(Status.PASS, "Taking the elements: " + elementBy);
                    success = true;
                    break;

                case "id":
                    wait.until(ExpectedConditions.elementToBeClickable(elementBy));
                    elements = driver.findElements(elementBy);
                    ExtentListeners.test.log(Status.PASS, "Taking the elements: " + elementBy);
                    success = true;
                    break;

                default:
                    attempts++;
            }
        }
        return elements;
    }

    /**
     * <b>[Method]</b> - Get Texts from Elements<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality gets texts from elements on page.
     * Has logic to find the elements based on the locator that this method receives as input parameter,
     * and provides the elements texts as a String List<br>
     *
     * @param elementBy By
     */
    public static List<String> getElementsText(By elementBy) {

        List<String> textList = new ArrayList<>();

        getElements(elementBy).stream().forEachOrdered(element -> {
            if (element.getText().trim().equals("")) {
                textList.add(element.getAttribute("innerText").trim());
            } else {
                textList.add(element.getText().trim());
            }
        });
        ExtentListeners.test.log(Status.PASS, "Elements texts collected");
        return textList;
    }

    /**
     * <b>[Method]</b> - Wait For Page To Load<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality waiting until page loaded.
     * Has logic to expect document ready state till timOut duration<br>
     *
     * @param timeOut long
     */
    public static void waitForPageToLoad(long timeOut) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
            wait.until(expectation);
            ExtentListeners.test.log(Status.PASS, "Page is loaded successfully");
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }

    /*--------------------------------------->Validation<-----------------------------------------------*/

    /**
     * <b>[Method]</b> - Validate Page Title<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality validates page title<br>
     * Has logic to validate actual page title with expected page title<br>
     * It takes expected page title as parameter<br>
     * //    * @param pageTitle String
     *
     * @throws TimeoutException
     * @throws AssertionError
     */
    public static void validatePageTitle() {
        try {
            //wait.until(ExpectedConditions.titleContains(" -- "));
            assertEquals(driver.getTitle(), Page.config.getProperty("page.title"));
            ExtentListeners.test.log(Status.PASS, "User successfully accessed to \"" + driver.getTitle() + "\" page");
        } catch (TimeoutException | AssertionError e) {
            ExtentListeners.test.log(Status.FAIL, e.getMessage());
            throw e;
        }
    }
}