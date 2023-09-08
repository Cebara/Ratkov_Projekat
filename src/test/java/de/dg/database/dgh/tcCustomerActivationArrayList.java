package de.dg.database.dgh;

import automation.de.dg.database.dgh.activation.FlowActivationCustomer;
import automation.de.dg.database.dgh.customer.SuiteBackDays;
import automation.de.dg.database.dgh.customer.SuiteOneTimeProduct;
import automation.de.dg.database.dgh.customer.SuiteUpdatingCustomerData;
import automation.de.dg.database.dgh.enumation.BackDays;
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
public class tcCustomerActivationArrayList {

    SuiteBackDays backDays = new SuiteBackDays();
    SuiteOneTimeProduct oneTimeProduct = new SuiteOneTimeProduct();
    FlowActivationCustomer activationCustomer = new FlowActivationCustomer();
    SuiteUpdatingCustomerData updatingCustomer = new SuiteUpdatingCustomerData();
    TestingResource resource = new TestingResource();

    int[] cupool = {3935357, 3935358, 3935360, 3935361, 3935362, 3935363};
    int[] copool = {1053767, 1053768, 1053770, 1053771, 1053772, 1053773};

    /**
     * <b>[Test Method]</b> - Test Case Customer activation<br>
     * <br>
     * <i>Test Method functionality:</i><br>
     * This functionality performs Customer activation<br>
     */

    @Test(priority = 1)
    public void tcCustomerActivation() {
        try {
            int custId;
            int coId;

            System.out.println("#####################################################################################");
            System.out.println("## Step check UC Status");
            System.out.println("#####################################################################################");
            for (int i = 0; i < cupool.length; i++) {
                custId = cupool[i];
                coId = copool[i];
                System.out.println("Customer ID: " + custId);
                resource.setCustomerId(custId);
                resource.setContractId(coId);
                // step check until UC-Status become Unit found
                activationCustomer.checkUcStatus(custId, AddressTypes.Installationsanschrift, AddressStatuses.UNIT_found);
            }

            System.out.println("#####################################################################################");
            System.out.println("## Step update Project");
            System.out.println("#####################################################################################");
            for (int i = 0; i < cupool.length; i++) {
                custId = cupool[i];
                coId = copool[i];
                System.out.println("Customer ID: " + custId);
                resource.setCustomerId(custId);
                resource.setContractId(coId);
                // step change group ID to assign Project
                updatingCustomer.updateGroupId(custId);
            }

            // insert wait element until all backend processes are finished
            System.out.println("Proceeding with 30sec waiting timer until all process are performed");
            Thread.sleep(1000*30);

            System.out.println("#####################################################################################");
            System.out.println("## Step check Customer Status");
            System.out.println("#####################################################################################");
            for (int i = 0; i < cupool.length; i++) {
                custId = cupool[i];
                coId = copool[i];
                System.out.println("Customer ID: " + custId);
                resource.setCustomerId(custId);
                resource.setContractId(coId);
                // step check Customer status to become AEB verschickt (10003)
                activationCustomer.checkCustomerStatus(custId, CustomerStatuses.AEB_verschickt);
            }

            System.out.println("#####################################################################################");
            System.out.println("## Step update UC Status");
            System.out.println("#####################################################################################");
            for (int i = 0; i < cupool.length; i++) {
                custId = cupool[i];
                coId = copool[i];
                System.out.println("Customer ID: " + custId);
                resource.setCustomerId(custId);
                resource.setContractId(coId);
                // step update UC-Status to HOMES served
                updatingCustomer.updateUcStatus(custId, AddressTypes.Installationsanschrift, AddressStatuses.HOMES_served.option);
            }
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
        try {
            int custId;
            int coId;

            System.out.println("#####################################################################################");
            System.out.println("## Step Executing procedure");
            System.out.println("#####################################################################################");
            for (int i = 0; i < cupool.length; i++) {
                custId = cupool[i];
                coId = copool[i];
                System.out.println("Customer ID: " + custId);
                resource.setCustomerId(custId);
                resource.setContractId(coId);
                // step execute procedure
                updatingCustomer.executeActivationProductProcedure(custId);
            }

            // insert wait element until all backend processes are finished
            System.out.println("Proceeding with 30sec waiting timer until all process are performed");
            Thread.sleep(1000*30);

            System.out.println("#####################################################################################");
            System.out.println("## Step updating Contract");
            System.out.println("#####################################################################################");
            for (int i = 0; i < cupool.length; i++) {
                custId = cupool[i];
                coId = copool[i];
                System.out.println("Customer ID: " + custId);
                resource.setCustomerId(custId);
                resource.setContractId(coId);
                // step update contract
                updatingCustomer.updateContract(custId);
            }

            System.out.println("#####################################################################################");
            System.out.println("## Step updating customer status");
            System.out.println("#####################################################################################");
            for (int i = 0; i < cupool.length; i++) {
                custId = cupool[i];
                coId = copool[i];
                System.out.println("Customer ID: " + custId);
                resource.setCustomerId(custId);
                resource.setContractId(coId);
                // step update customer status to become active
                updatingCustomer.updateCustomerStatus(custId);
            }

            System.out.println("#####################################################################################");
            System.out.println("## Step verifying mail");
            System.out.println("#####################################################################################");
            for (int i = 0; i < cupool.length; i++) {
                custId = cupool[i];
                coId = copool[i];
                System.out.println("Customer ID: " + custId);
                resource.setCustomerId(custId);
                resource.setContractId(coId);
                // step validate email address
                updatingCustomer.updateEmailValidation(custId, AddressTypes.Rechnungsanschrift);
            }

            System.out.println("#####################################################################################");
            System.out.println("## Step activating phone");
            System.out.println("#####################################################################################");
            for (int i = 0; i < cupool.length; i++) {
                custId = cupool[i];
                coId = copool[i];
                System.out.println("Customer ID: " + custId);
                resource.setCustomerId(custId);
                resource.setContractId(coId);
                // step activate phone
                updatingCustomer.activatePhone(custId);
            }

            // insert wait element until all backend processes are finished
            System.out.println("Proceeding with 3min waiting timer until all process are performed");
            Thread.sleep(1000*60*3);

            System.out.println("#####################################################################################");
            System.out.println("## Step activating co product");
            System.out.println("#####################################################################################");
            for (int i = 0; i < cupool.length; i++) {
                custId = cupool[i];
                coId = copool[i];
                System.out.println("Customer ID: " + custId);
                resource.setCustomerId(custId);
                resource.setContractId(coId);
                // step activating CO Product
                updatingCustomer.activateCoProduct(custId);
            }

            System.out.println("#####################################################################################");
            System.out.println("## Step activating cov product");
            System.out.println("#####################################################################################");
            for (int i = 0; i < cupool.length; i++) {
                custId = cupool[i];
                coId = copool[i];
                System.out.println("Customer ID: " + custId);
                resource.setCustomerId(custId);
                resource.setContractId(coId);
                // step activating CO Voice Product
                updatingCustomer.activateCoVoiceProduct(custId);
            }
        } catch (InterruptedException ie) {
            throw new RuntimeException(ie);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <b>[Test Method]</b> - Test Case deactivate One time Product<br>
     * <br>
     * <i>Test Method functionality:</i><br>
     * This functionality performs deactivation of one-time Customer's Product<br>
     */

    @Test(priority = 3)
    public void tcCustomerDeactivateOneTimeProduct() {
        try {
            int custId;

            System.out.println("#####################################################################################");
            System.out.println("## Step deactivating One time Product");
            System.out.println("#####################################################################################");
            for (int i = 0; i < cupool.length; i++) {
                custId = cupool[i];
                System.out.println("Customer ID: " + custId);
                resource.setCustomerId(custId);
                // step execute procedure
                oneTimeProduct.performDeactivateOnetimeProduct(custId);
            }
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
            int custId;
            int coId;

            System.out.println("#####################################################################################");
            System.out.println("## Step Changing Date");
            System.out.println("#####################################################################################");
            for (int i = 0; i < cupool.length; i++) {
                custId = cupool[i];
                coId = copool[i];
                System.out.println("Customer ID: " + custId);
                resource.setCustomerId(custId);
                resource.setContractId(coId);
                // step execute procedure
                backDays.setBackdays(BackDays.PAST_SIX_MONTHS);
                //createCustomer.flowCustomerCreation();
                backDays.performBackDays();
            }
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
            int custId;
            int coId;
            for (int i = 0; i < cupool.length; i++) {
                custId = cupool[i];
                coId = copool[i];
                System.out.println("Customer ID: " + custId);
                resource.setCustomerId(custId);
                resource.setContractId(coId);
                // step check until UC-Status become Unit found
                activationCustomer.checkUcStatus(custId, AddressTypes.Installationsanschrift, AddressStatuses.HOMES_served);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
