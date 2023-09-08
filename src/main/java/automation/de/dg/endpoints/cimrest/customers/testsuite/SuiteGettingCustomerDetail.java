package automation.de.dg.endpoints.cimrest.customers.testsuite;

import automation.de.dg.endpoints.cimrest.customers.controllers.GetCustomer;
import io.restassured.response.Response;

/**
 * <b>RestAPI : Campaign Suite</b> Getting Customer detail Suite<br>
 * <i>Class functionality:</i><br>
 *  Class is used to define flow for test cases<br>
 *  that cover getting Customer details.
 */

public class SuiteGettingCustomerDetail {

    public void flowGetCustomerInstanceInfo() {
        try {
            GetCustomer getCustomer = new GetCustomer();
            Response response = getCustomer.getCustomer("3934663");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
