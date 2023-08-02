package testcases.basetest;

import automation.pages.LoginPage;
import automation.testbase.Page;
import org.testng.annotations.Test;

/**
 * <b>TEST CASE</b> [Handlers]: Login Test
 */
public class LoginTest extends BaseTest {

    /**
     * <b>[Test Method]</b> - Test to Log in to application<br>
     * <br>
     * <i>Test Method functionality:</i><br>
     * This functionality tries to log in into application<br>
     */
    @Test
    public void loginTest() {

        loginPage = new LoginPage();

        //Step 1: Login to application
        loginPage.login();

        //Step 2: Verify page title
        Page.validatePageTitle();
    }
}