package testcases.basetest;

import automation.testbase.Page;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * <b>TEST CASE</b> [Handlers]: Base Test class
 */
public class BaseTest extends Page {

    /**
     * <b>[Test Method]</b> - Set Up Login Page<br>
     * <br>
     * <i>Test Method functionality:</i><br>
     * This functionality tries to log in into application<br>
     * BeforeClass - annotation
     */

    @BeforeClass
    public void setUp() {

    }

    /**
     * <b>[Test Method]</b> - Quit the Page<br>
     * <br>
     * <i>Test Method functionality:</i><br>
     * This functionality quits current page<br>
     * AfterClass - annotation
     */
    @AfterClass
    public void tearDown() {
        Page.quit();
    }
}