package restApiSuite.healthCare;

import automation.enumaration.RestApiAuth;
import automation.enumaration.RestApiNames;
import automation.restAssuredAPI.CommonTest;
import automation.restAssuredAPI.campaign.HealthCheck;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;

/**
 * <b>RestAPI Feature : Health Care Suite</b> Campaign API
 */

@Listeners(automation.listeners.ExtentApiListener.class)
public class TestCaseHCCampaignApi extends CommonTest {

    HealthCheck healthCheck = new HealthCheck();
    CommonTest common = new CommonTest();

    /**
     * <b>[Test Method]</b> - Verify that Get Campaign Instance Endpoint is up<br>
     * <br>
     * <i>Test Method functionality:</i><br>
     * This functionality verifies that Get Campaign Instance Endpoint is up<br>
     */

    @Test
    public void testGetCampaignInstance() {
        try {
            healthCheck.checkGetCampaignInstanceUp();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <b>[Test Method]</b> - Verify that Get Campaign All Endpoint is up<br>
     * <br>
     * <i>Test Method functionality:</i><br>
     * This functionality verifies that Get Campaign All Endpoint is up<br>
     */

    @Test
    public void testGetCampaignAll() {
        try {
            healthCheck.checkGetCampaignAllUp();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <b>[Test Method]</b> - Verify that Get Valid Campaign Endpoint is up<br>
     * <br>
     * <i>Test Method functionality:</i><br>
     * This functionality verifies that Get valid Campaign Endpoint is up<br>
     */

    @Test
    public void testGetValidCampaign() {
        try {
            healthCheck.checkGetValidCampaignUp();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <b>[Test Method]</b> - Verify that Post Campaign Instance Endpoint is up<br>
     * <br>
     * <i>Test Method functionality:</i><br>
     * This functionality verifies that Post Campaign Instance Endpoint is up<br>
     */

    @Test
    public void testPostCampaignInstance() {
        try {
            healthCheck.checkPostCampaignInstanceUp();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <b>[Test Method]</b> - Verify that Put Campaign Instance Endpoint is up<br>
     * <br>
     * <i>Test Method functionality:</i><br>
     * This functionality verifies that Put Campaign Instance Endpoint is up<br>
     */

    @Test
    public void testPutCampaignInstance() {
        try {
            healthCheck.checkPutCampaignInstanceUp();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <b>[Test Method]</b> - Verify that Delete Campaign Instance Endpoint is up<br>
     * <br>
     * <i>Test Method functionality:</i><br>
     * This functionality verifies that Delete Campaign Instance Endpoint is up<br>
     */

    @Test
    public void testDeleteCampaignInstance() {
        try {
            healthCheck.checkDeleteCampaignInstanceUp();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <b>[Test Method]</b> - Verify that Delete All Campaigns Endpoint is up<br>
     * <br>
     * <i>Test Method functionality:</i><br>
     * This functionality verifies that Delete Campaign Instance Endpoint is up<br>
     */

    @Test
    public void testDeleteAllCampaigns() {
        try {
            healthCheck.checkDeleteAllCampaigns();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }



    /**
     * <b>[Test Method]</b> - Set Up for RestApi<br>
     * <br><i>Test Method functionality:</i><br>
     * Purpose of the method is to initialize API name used for testing
     * Next step will be setup action in CommonTest class under RestAPI package
     * which allows us to prepare base url and<br>
     * BeforeSuite - annotation
     */

    @BeforeSuite
    public void setupApiName() {
        // initialize API name
        CommonTest.setRestApiName(RestApiNames.CAMPAIGN);
        // initialize API Auth type
        CommonTest.setRestApiAuthType(RestApiAuth.BASIC);
        // initialize RestApi URL
        common.setup();
    }

}
