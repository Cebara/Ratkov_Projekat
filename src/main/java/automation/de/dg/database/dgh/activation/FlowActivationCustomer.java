package automation.de.dg.database.dgh.activation;

import automation.database.DataBaseConnection;
import automation.database.queries.DghUpdateQueries;
import automation.database.queryManipulation.DghQueryManipulation;
import automation.de.dg.database.dgh.customer.SuiteUpdatingCustomerData;
import automation.de.dg.enumation.AddressStatuses;
import automation.de.dg.enumation.AddressTypes;
import automation.de.dg.enumation.CustomerStatuses;
import automation.de.dg.utils.TestingResource;
import automation.enumaration.DatabaseNames;
import org.testng.Assert;

import java.sql.Time;

/**
 * <b>DE.DG : Database/DGH</b> Activation Customer Data<br>
 * <i>Class functionality:</i><br>
 *  Class is used for activating customers<br>
 *  whole process is performed on DGH db
 */

public class FlowActivationCustomer {

    /**
     * <b>[Test Method]</b> - Updating Customer data<br>
     * <br>
     * <i>Test Method functionality:</i><br>
     * This functionality performs flow of updating Customer data<br>
     * Updating is performed via database update actions
     */
    public void flowCustomerActivation(int custId) throws InterruptedException {
        // initialize classes from interest
        SuiteUpdatingCustomerData updatingCustomer = new SuiteUpdatingCustomerData();
        try {
            System.out.println("#####################################################################################");
            System.out.println("### Device Activation Process");
            System.out.println("#####################################################################################");

            // step check until UC-Status become Unit found
            checkUcStatus(custId, AddressTypes.Installationsanschrift, AddressStatuses.UNIT_found);

            // step change group ID to assign Project
            updatingCustomer.updateGroupId(custId);

            // insert wait element until all backend processes are finished
            System.out.println("Proceeding with 30sec waiting timer until all process are performed");
            Thread.sleep(1000*30);

            // step check Customer status to become AEB verschickt (10003)
            checkCustomerStatus(custId, CustomerStatuses.AEB_verschickt);

            // step update UC-Status to HOMES served
            updatingCustomer.updateUcStatus(custId, AddressTypes.Installationsanschrift, AddressStatuses.HOMES_served.option);

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
            System.out.println("Proceeding with 2min waiting timer until all process are performed");
            Thread.sleep(1000*60*3);

            // step activating CO Product
            updatingCustomer.activateCoProduct(custId);

            // step activating CO Voice Product
            updatingCustomer.activateCoVoiceProduct(custId);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <b>[Test Method]</b> - Check UC Status ID<br>
     * <br>
     * <i>Test Method functionality:</i><br>
     * This functionality performs check of UC Status ID<br>
     * If status id is different from expected, process is aborted<br>
     * Timer is also implemented due to OMI processing time of changing status<br>
     * UC-Status ID is taken from Customer_address table
     * @param custId int
     * @param addType AddressTypes
     * @param status AddressStatuses
     */

    public void checkUcStatus(int custId, AddressTypes addType, AddressStatuses status) {
        System.out.println("Step checking UC-Status");
        try {
            // initialize classes from interest
            DghQueryManipulation dghQueries = new DghQueryManipulation();
            TestingResource resource = new TestingResource();
            // take address status
            dghQueries.getCustomerAddress(custId, addType);
            // counter to prevent infinitive loop
            int counter = 0;
            // wait until UC-Status become desired value
            while (resource.getCustomerAddressStatusId() != status.option && counter < 15) {
                // take address status
                dghQueries.getCustomerAddress(custId, addType);
                int ucStatus = resource.getCustomerAddressStatusId();
                System.out.println("Current UC-Status is " + ucStatus);
                if (ucStatus == AddressStatuses.TZIP_search.option) {
                    Thread.sleep(1000*60);
                } else if (ucStatus == AddressStatuses.CAMEL_denied.option) {
                    SuiteUpdatingCustomerData updatingCustomer = new SuiteUpdatingCustomerData();
                    updatingCustomer.updateUcStatus(custId, AddressTypes.Installationsanschrift, AddressStatuses.HOMES_served.option);
                    break;
                } else if (ucStatus == AddressStatuses.HOMES_served.option) {
                    break;
                } else if (ucStatus != AddressStatuses.UNIT_no_free_unit.option) {
                    //Thread.sleep(15000);
                    SuiteUpdatingCustomerData updatingCustomer = new SuiteUpdatingCustomerData();
                    updatingCustomer.updateUcStatus(custId, AddressTypes.Installationsanschrift, AddressStatuses.UNIT_found.option);
                } else {
                    SuiteUpdatingCustomerData updatingCustomer = new SuiteUpdatingCustomerData();
                    updatingCustomer.updateUcStatus(custId, AddressTypes.Installationsanschrift, AddressStatuses.UNIT_found.option);
                    //Assert.fail("UC-Status is UNIT no free unit (" + resource.getCustomerAddressStatusId() + ") and activation flow is aborted");
                }
                // increment counter to prevent infinitive loop
                counter++;
            }
            // stop activation process since UC status is not expected
            if ((resource.getCustomerAddressStatusId() != status.option) && (resource.getCustomerAddressStatusId() != AddressStatuses.HOMES_served.option)) {
                Assert.fail("UC-Status is " + resource.getCustomerAddressStatusId() + " and activation flow is aborted");
            } else {
                System.out.println("Current UC-Status is " + resource.getCustomerAddressStatusId());
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <b>[Test Method]</b> - Check Customer Status ID<br>
     * <br>
     * <i>Test Method functionality:</i><br>
     * This functionality performs check of Customer Status ID<br>
     * If status id is different from expected, process is aborted<br>
     * Timer is also implemented due to OMI processing time of changing status<br>
     * Customer Status ID is taken from Customer table
     * @param custId int
     * @param status CustomerStatuses
     */

    public void checkCustomerStatus(int custId, CustomerStatuses status) {
        System.out.println("Step checking customer's status");
        try {
            // initialize classes from interest
            DghQueryManipulation dghQueries = new DghQueryManipulation();
            TestingResource resource = new TestingResource();
            // take customer's data
            dghQueries.getCustomer(custId);

            // counter to prevent infinitive loop
            int counter = 0;
            // wait until Customer Status become desired value
            while (resource.getCustomerStatusId() != status.option && counter < 10) {
                System.out.println("Current Customer Status is " + resource.getCustomerStatusId());
                counter++;
                Thread.sleep(15000);
                // take customer's data
                dghQueries.getCustomer(custId);
            }

            // update status to 10003 if status is 10001
            if (resource.getCustomerStatusId() == CustomerStatuses.Nachbearbeitung.option) {
                int count = DataBaseConnection.updateQuery(DatabaseNames.DGH, DghUpdateQueries.updateCustomerStatus(custId, CustomerStatuses.AEB_zu_verschicken.option));
                Thread.sleep(500);
                System.out.println("Number of updated columns: " + count + " for updating to status " + CustomerStatuses.AEB_zu_verschicken);
                count = DataBaseConnection.updateQuery(DatabaseNames.DGH, DghUpdateQueries.updateCustomerStatus(custId, CustomerStatuses.AEB_verschickt.option));
                Thread.sleep(500);
                System.out.println("Number of updated columns: " + count + " for updating to status " + CustomerStatuses.AEB_verschickt);
            } else if (resource.getCustomerStatusId() != status.option) {
                // stop activation flow if customer status is not expected
                Assert.fail("Customer Status is " + resource.getCustomerStatusId() + " and activation flow is aborted");
            } else {
                System.out.println("Current Customer Status is " + resource.getCustomerStatusId());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
