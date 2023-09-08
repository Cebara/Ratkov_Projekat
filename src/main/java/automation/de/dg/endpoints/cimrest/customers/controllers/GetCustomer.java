package automation.de.dg.endpoints.cimrest.customers.controllers;

import automation.de.dg.endpoints.constants.CampaignUriPath;
import automation.de.dg.endpoints.constants.CimUriPath;
import automation.endpoints.CommonTest;
import automation.endpoints.RestApiPreparationData;
import automation.endpoints.enumaration.RestApiMethodTypes;
import automation.enumaration.RestApiHttpStatusCodes;
import io.restassured.response.Response;

/**
 * <b>RestAPI : Cim Rest Suite/Customer</b> Get Method Test Suite<br>
 *  <i>Class functionality:</i><br>
 *  Class is used to execute endpoint with Get method type<br>
 *  under Customers controller umbrella
 */

public class GetCustomer extends CommonTest {

    /**
     * <b>[Method]</b> - Get Customer<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality get customer's data
     */

    public Response getCustomer(String instance) {
        try {
            String body = null;
            // initialize request's body
            RestApiPreparationData.setBody(body);
            // get response value
            Response response = RestApiPreparationData.returnResponse(RestApiMethodTypes.GET, CommonTest.getRestApiUrl() + CimUriPath.REST_URL + CimUriPath.CUSTOMER_INSTANCE + "/" + instance);
            // check proper HTTP response code is in return
            checkStatusCode(response.getStatusCode(), RestApiHttpStatusCodes.OK.option);
            //
            return response;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
