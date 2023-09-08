package de.dg.endpoints.apiSuite.cimrest;

import automation.de.dg.endpoints.cimrest.customers.testsuite.SuiteGettingCustomerDetail;
import automation.endpoints.CommonTest;
import automation.enumaration.RestApiAuth;
import automation.enumaration.RestApiNames;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * <b>RestAPI : CIM Rest Suite</b> Getting Customer data<br>
 * <i>Class functionality:</i><br>
 *  Class is used to define flow for test cases<br>
 *  that cover getting Customer flow.
 */

@Listeners(automation.listeners.ExtentApiListener.class)
public class TestSuiteApiCustomerGet {

    CommonTest common = new CommonTest();
    SuiteGettingCustomerDetail getCustomer = new SuiteGettingCustomerDetail();

    /**
     * <b>[Test Method]</b> - Test Case getting Customer Detail<br>
     * <br>
     * <i>Test Method functionality:</i><br>
     * This functionality performs getting Customer details<br>
     */

    @Test
    public void tcGetCampaignInstance() {
        getCustomer.flowGetCustomerInstanceInfo();
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
        CommonTest.setRestApiName(RestApiNames.CIMREST);
        // initialize API Auth type
        CommonTest.setRestApiAuthType(RestApiAuth.BASIC);
        // initialize RestApi URL
        common.setup();
    }

}
