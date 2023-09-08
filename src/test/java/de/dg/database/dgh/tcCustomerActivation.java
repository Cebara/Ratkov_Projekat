package de.dg.database.dgh;

import automation.de.dg.database.dgh.activation.FlowActivationCustomer;
import automation.de.dg.database.dgh.customer.SuiteBackDays;
import automation.de.dg.database.dgh.customer.SuiteOneTimeProduct;
import automation.de.dg.database.dgh.customer.SuiteUpdatingCustomerData;
import automation.de.dg.database.dgh.enumation.BackDays;
import automation.de.dg.endpoints.cimrest.customers.testsuite.SuiteCreatingCustomerDetail;
import automation.de.dg.enumation.AddressStatuses;
import automation.de.dg.enumation.AddressTypes;
import automation.de.dg.enumation.CustomerStatuses;
import automation.de.dg.utils.TestingResource;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * <b>Database Feature : Database Suite</b> Customer Activation
 */

@Listeners(automation.listeners.ExtentApiListener.class)
public class tcCustomerActivation {

    SuiteBackDays backDays = new SuiteBackDays();
    SuiteOneTimeProduct oneTimeProduct = new SuiteOneTimeProduct();
    FlowActivationCustomer activationCustomer = new FlowActivationCustomer();
    SuiteUpdatingCustomerData updatingCustomer = new SuiteUpdatingCustomerData();
    TestingResource resource = new TestingResource();


    static int custId = 3935418;
    static int contId = 1053828;
    static BackDays bd = BackDays.PAST_MORE_TWO_YEARS;

    /**
     * <b>[Test Method]</b> - Test Case Customer activation<br>
     * <br>
     * <i>Test Method functionality:</i><br>
     * This functionality performs Customer activation<br>
     */

    @Test(priority = 1)
    public void tcCustomerActivation() {
        System.out.println("#####################################################################################");
        System.out.println("### Customer Activation process");
        System.out.println("#####################################################################################");
        try {
            resource.setCustomerId(custId);
            resource.setContractId(contId);

            // step check until UC-Status become Unit found
            activationCustomer.checkUcStatus(custId, AddressTypes.Installationsanschrift, AddressStatuses.UNIT_found);

            // step change group ID to assign Project
            updatingCustomer.updateGroupId(custId);


            // insert wait element until all backend processes are finished
            System.out.println("Proceeding with 30sec waiting timer until all process are performed");
            Thread.sleep(1000*30);

            // step check Customer status to become AEB verschickt (10003)
            activationCustomer.checkCustomerStatus(custId, CustomerStatuses.AEB_verschickt);

            // step update UC-Status to HOMES served
            updatingCustomer.updateUcStatus(custId, AddressTypes.Installationsanschrift, AddressStatuses.HOMES_served.option);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <b>[Test Method]</b> - Test Case Customer finishing activation<br>
     * <br>
     * <i>Test Method functionality:</i><br>
     * This functionality performs finishing Customer activation<br>
     */

    @Test(priority = 2)
    public void tcCustomerFinishingActivation() {
        System.out.println("#####################################################################################");
        System.out.println("### Finishing Customer Activation");
        System.out.println("#####################################################################################");
        try {
            resource.setCustomerId(custId);
            resource.setContractId(contId);
            int custId = resource.getCustomerId();

            // step execute procedure
            updatingCustomer.executeActivationProductProcedure(custId);

            // insert wait element until all backend processes are finished
            System.out.println("Proceeding with 30sec waiting timer until all process are performed");
            Thread.sleep(1000*30);

            // step update contract
            updatingCustomer.updateContract(custId);

            // step update customer status to become active
            updatingCustomer.updateCustomerStatus(custId);

            // step validate email address
            updatingCustomer.updateEmailValidation(custId, AddressTypes.Rechnungsanschrift);

            // step activate phone
            updatingCustomer.activatePhone(custId);

            // insert wait element until all backend processes are finished
            System.out.println("Proceeding with 3min waiting timer until all process are performed");
            Thread.sleep(1000*60*3);

            // step activating CO Product
            updatingCustomer.activateCoProduct(custId);

            // step activating CO Voice Product
            updatingCustomer.activateCoVoiceProduct(custId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <b>[Test Method]</b> - Test Case deactivateone-time Product<br>
     * <br>
     * <i>Test Method functionality:</i><br>
     * This functionality performs deactivation of one-time Products<br>
     */

    @Test(priority = 3)
    public void tcCustomerDeactivateOneTimeProduct() {
        try {
            resource.setCustomerId(custId);
            //createCustomer.flowCustomerCreation();
            oneTimeProduct.performDeactivateOnetimeProduct(resource.getCustomerId());
        } catch (NullPointerException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <b>[Test Method]</b> - Test Case Customer changing days<br>
     * <br>
     * <i>Test Method functionality:</i><br>
     * This functionality performs Customer changing days<br>
     */

    @Test(priority = 4)
    public void tcCustomerChangedays() throws NullPointerException {
        try {
            resource.setCustomerId(custId);
            backDays.setBackdays(bd);
            //createCustomer.flowCustomerCreation();
            backDays.performBackDays();
        } catch (NullPointerException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 5)
    public void tcCheckUcStatus() {
        System.out.println("#####################################################################################");
        System.out.println("### Check if UC Status is Homes served");
        System.out.println("#####################################################################################");
        try {
            resource.setCustomerId(custId);
            // step check until UC-Status become Unit found
            activationCustomer.checkUcStatus(custId, AddressTypes.Installationsanschrift, AddressStatuses.HOMES_served);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
