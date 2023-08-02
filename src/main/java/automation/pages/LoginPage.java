package automation.pages;

import automation.listeners.ExtentListeners;
import automation.testbase.Page;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;

/**
 * <b>PAGES : SETTINGS</b> [Login]: Login Page
 */
public class LoginPage extends Page {
    By username = By.id("username");
    By password = By.id("password");
    By loginButton = By.xpath("//button[@id='submit']");

    /**
     * <b>[Method]</b> - Test Log in<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality tries to Log in based on user and password specified in Config.properties<br>
     */
    public void login() {
        try {
            type(username, config.getProperty("user"));
            type(password, config.getProperty("password"));
            click(loginButton);
        } catch (StaleElementReferenceException | ElementClickInterceptedException | TimeoutException exception) {
            ExtentListeners.test.log(Status.FAIL, exception);
        }
    }
}