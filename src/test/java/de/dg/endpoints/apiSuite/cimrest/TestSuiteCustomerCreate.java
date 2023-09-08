package de.dg.endpoints.apiSuite.cimrest;

import automation.de.dg.database.dgh.customer.SuiteBackDays;
import automation.de.dg.database.dgh.enumation.BackDays;
import automation.de.dg.endpoints.cimrest.customers.testsuite.SuiteCreatingCustomerDetail;
import automation.de.dg.enumation.Portfolio;
import automation.de.dg.enumation.WaipuTypes;
import automation.de.dg.utils.TestingResource;
import automation.endpoints.CommonTest;
import automation.enumaration.RestApiAuth;
import automation.enumaration.RestApiNames;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * <b>RestAPI Feature : API Suite</b> Create Customer
 */

@Listeners(automation.listeners.ExtentApiListener.class)
public class TestSuiteCustomerCreate {

    CommonTest common = new CommonTest();
    SuiteCreatingCustomerDetail createCustomer = new SuiteCreatingCustomerDetail();

    Portfolio portfolio = Portfolio.Eighteen;
    int tariff = 300;
    WaipuTypes waipu = WaipuTypes.Null;


    /**
     * <b>[Test Method]</b> - Test Case creating Customer<br>
     * <br>
     * <i>Test Method functionality:</i><br>
     * This functionality performs creating Customer<br>
     */

    @Test
    public void tcCreateCustomer() {
        // perform customer's activation process
        createCustomer.flowCustomerCreation();
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
