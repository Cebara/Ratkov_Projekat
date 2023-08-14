package restApiSuite.apiSuite.campaign;

import automation.enumaration.RestApiAuth;
import automation.enumaration.RestApiNames;
import automation.restAssuredAPI.CommonTest;
import automation.restAssuredAPI.campaign.SuiteHouseInstance;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * <b>RestAPI Feature : API Suite</b> Assign Campaign
 */

@Listeners(automation.listeners.ExtentApiListener.class)
public class TestCaseApiCampaignAssign {

    CommonTest common = new CommonTest();
    SuiteHouseInstance houseInstance = new SuiteHouseInstance();

    /**
     * <b>[Test Method]</b> - Test Case assigning Campaign to House<br>
     * <br>
     * <i>Test Method functionality:</i><br>
     * This functionality performs assignment Campaign to House<br>
     */

    @Test
    public void tcAssignCampaign() {
        houseInstance.flowAssignCampaignInstance();
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
