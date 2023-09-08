package automation.de.dg.endpoints.cimrest.customers.testsuite;

import automation.de.dg.database.dgh.activation.FlowActivationCustomer;
import automation.de.dg.database.dgh.customer.SuiteUpdatingCustomerData;
import automation.de.dg.endpoints.cimrest.customers.controllers.PostCreateCustomer;
import automation.de.dg.utils.TestingResource;
import io.restassured.response.Response;
import org.json.JSONObject;

/**
 * <b>RestAPI : CIM Rest Suite</b> Creating Customer Suite<br>
 * <i>Class functionality:</i><br>
 *  Class is used to define flow for test cases<br>
 *  that cover creating Customer flow.
 */

public class SuiteCreatingCustomerDetail {

    /**
     * <b>[Test Method]</b> - Test Case creating Customer<br>
     * <br>
     * <i>Test Method functionality:</i><br>
     * This functionality performs flow of creating Customer<br>
     */
    public void flowCustomerCreation() {
        try {
            // step 1 - create customer
            PostCreateCustomer postCreation = new PostCreateCustomer();
            JSONObject body = postCreation.body();
            Response response = postCreation.createCustomer(String.valueOf(body));

            // step 2 - take customer and contract id
            takeCustomerCreationData(response);
            /*
            // insert wait element until all backend processes are finished
            System.out.println("Proceeding with 1min waiting timer until all process are performed");
            Thread.sleep(1000*60);

            // step 3 - activate customer
            FlowActivationCustomer activationCustomer = new FlowActivationCustomer();
            TestingResource resource = new TestingResource();
            //resource.setCustomerId(3935015);
            //resource.setContractId(1053425);
            System.out.println("Customer ID that should be activated: " + resource.getCustomerId());
            activationCustomer.flowCustomerActivation(resource.getCustomerId());*/
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <b>[Test Method]</b> - Take Customer Creation Data<br>
     * <br>
     * <i>Test Method functionality:</i><br>
     * This functionality performs saving customer's data<br>
     * taken from Customer creation response
     */

    private void takeCustomerCreationData(Response response) {
        try {
            // take customer id from endpoint's response body
            int customerId = response.jsonPath().getJsonObject("customerId");
            // take contract id from endpoint's response body
            int contractId = response.jsonPath().getJsonObject("contractId");
            // store customer id and contract id for further activation flow
            TestingResource resource = new TestingResource();
            resource.setCustomerId(customerId);
            resource.setContractId(contractId);


            System.out.println("Customer is successfully created");
            System.out.println("Created Customer ID: " + customerId);
            System.out.println("Created Contract ID: " + contractId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
