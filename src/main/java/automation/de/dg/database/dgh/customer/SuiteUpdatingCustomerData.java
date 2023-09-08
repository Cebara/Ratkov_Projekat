package automation.de.dg.database.dgh.customer;

import automation.database.queryManipulation.DghQueryManipulation;
import automation.database.queryManipulation.DghUpdateQueryManipulation;
import automation.de.dg.enumation.AddressTypes;
import automation.de.dg.utils.TestingResource;
import org.testng.Assert;

/**
 * <b>DE.DG : Database/DGH</b> Updating Customer Data<br>
 * <i>Class functionality:</i><br>
 *  Class is used for updating customers on DGH db
 */

public class SuiteUpdatingCustomerData {


    /**
     * <b>[Test Method]</b> - Update Group ID<br>
     * <br>
     * <i>Test Method functionality:</i><br>
     * This functionality performs updating Group ID
     * @param custId int
     */

    public void updateGroupId(int custId) {
        System.out.println("Step updating customer's Project");
        try {
            // initialize classes from interest
            DghQueryManipulation dghQueries = new DghQueryManipulation();
            DghUpdateQueryManipulation dghUpdateQueries = new DghUpdateQueryManipulation();
            TestingResource resource = new TestingResource();
            // step - find random group id
            int groupId = 0;
            int counter = 0;
            // perform loop action to find group id different from current customer's group id
            do {
                // get current customer's data
                dghQueries.getCustomer(custId);
                // find some random group id
                //groupId = dghQueries.getGroupId();
                groupId = 11221;
                // counter to prevent infinitive loop
                counter++;
            } while (groupId == resource.getCustomerGroupId() && counter < 10);

            int updatedRows = 0;
            // check if customer id or group id are invalid
            if (custId < 1 || groupId < 1) {
                Assert.fail("Customer ID or Group ID cannot be invalid");
            } else {
                System.out.println("Found random Group ID: " + groupId);
                updatedRows = dghUpdateQueries.updateGroupId(custId, groupId);
            }

            // check if at least one row is updated
            if (updatedRows > 0) {
                // get current customer's data
                dghQueries.getCustomer(custId);
                // check if group is updated
                if (groupId != resource.getCustomerGroupId()) {
                    Assert.fail("For Customer ID " + custId + ", Group ID " + groupId + " is not updated");
                } else {
                    System.out.println("Successfully updated Group ID to " + groupId + " for Customer ID " + custId);
                }
            } else {
                Assert.fail("For Customer ID " + custId + ", Group ID is not updated");
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * <b>[Test Method]</b> - Update UC Status<br>
     * <br>
     * <i>Test Method functionality:</i><br>
     * This functionality performs updating Unit Check status
     * @param custId int
     */

    public void updateUcStatus(int custId, AddressTypes addType, int addStatus) {
        System.out.println("Update UC-Status");
        try {
            // initialize classes from interest
            DghQueryManipulation dghQueries = new DghQueryManipulation();
            DghUpdateQueryManipulation dghUpdateQueries = new DghUpdateQueryManipulation();
            TestingResource resource = new TestingResource();

            int updatedRows = 0;
            // check if customer id or uc-status id are invalid
            if (custId < 1 || addStatus < 1) {
                Assert.fail("Customer ID or UC-Status ID cannot be invalid");
            } else {
                updatedRows = dghUpdateQueries.updateUcStatus(custId, addStatus, addType.option);
            }

            if (updatedRows > 0) {
                dghQueries.getCustomerAddress(custId, addType);
                if (addStatus != resource.getCustomerAddressStatusId()) {
                    Assert.fail("For Customer ID " + custId + ", UC Status is " + addStatus + " and not updated");
                } else {
                    System.out.println("Successfully updated UC-Status to " + addStatus + " for Customer ID " + custId);
                }
            } else {
                Assert.fail("For Customer ID " + custId + ", UC Status is not updated");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <b>[Test Method]</b> - Execute Activation Product Procedure<br>
     * <br>
     * <i>Test Method functionality:</i><br>
     * This functionality performs executing<br>
     * activating product procedure
     * @param custId int
     */

    public void executeActivationProductProcedure(int custId) {
        System.out.println("Execute Procedure to activate Products");
        // initialize classes from interest
        TestingResource resource = new TestingResource();
        try {
            // initialize classes from interest
            DghUpdateQueryManipulation dghUpdateQueries = new DghUpdateQueryManipulation();
            dghUpdateQueries.executeProductActivation(resource.getContractId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <b>[Test Method]</b> - Update Customer Status<br>
     * <br>
     * <i>Test Method functionality:</i><br>
     * This functionality performs updating Customer Status
     * @param custId int
     */

    public void updateContract(int custId) {
        // initialize classes from interest
        DghUpdateQueryManipulation dghUpdateQueries = new DghUpdateQueryManipulation();
        System.out.println("Step updating customer's contract");
        try {
            // check if customer id is invalid
            if (custId > 1) {
                // get current customer's status
                dghUpdateQueries.updateContract(custId);
            } else {
                Assert.fail("Customer ID cannot be invalid");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <b>[Test Method]</b> - Update Customer Status<br>
     * <br>
     * <i>Test Method functionality:</i><br>
     * This functionality performs updating Customer Status
     * @param custId int
     */

    public void updateCustomerStatus(int custId) {
        // initialize classes from interest
        DghQueryManipulation dghQueries = new DghQueryManipulation();
        DghUpdateQueryManipulation dghUpdateQueries = new DghUpdateQueryManipulation();
        TestingResource resource = new TestingResource();
        System.out.println("Step updating customer's status");
        try {
            // check if customer id is invalid
            if (custId > 1) {
                // get current customer's status
                dghQueries.getCustomer(custId);
                // check if customer status is 10003 AEB_verschickt
                if (resource.getCustomerStatusId() == 10003) {
                    dghUpdateQueries.updateCustomerStatus(custId);
                } else {
                    // fail execution since customer status is not in expected status
                    Assert.fail("Customer ID is not in valid status 10003 AEB_verschickt, but in status " + resource.getCustomerStatusId());
                }
            } else {
                Assert.fail("Customer ID cannot be invalid");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <b>[Test Method]</b> - Update Email Status<br>
     * <br>
     * <i>Test Method functionality:</i><br>
     * This functionality performs updating Customer Status
     * @param custId int
     * @param addType AddressTypes
     */

    public void updateEmailValidation(int custId, AddressTypes addType) {
        // initialize classes from interest
        DghQueryManipulation dghQueries = new DghQueryManipulation();
        DghUpdateQueryManipulation dghUpdateQueries = new DghUpdateQueryManipulation();
        TestingResource resource = new TestingResource();
        System.out.println("Step validate customer's mail address");
        try {
            // check if customer id is invalid
            if (custId > 1) {
                int count = dghUpdateQueries.updateCustAddressEmailValidation(custId, addType.option);
                // check if row is updated
                if (count > 0) {
                    dghQueries.getCustomerAddress(custId, addType);
                    if (resource.getCustomerAddressValidEmail() == 2) {
                        System.out.println("For Customer ID " + custId + ", email is validated");
                    } else {
                        Assert.fail("Customer ID " + custId + " does not have valid email address, but value " + resource.getCustomerAddressValidEmail());
                    }
                }
            } else {
                Assert.fail("Customer ID cannot be invalid");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <b>[Test Method]</b> - Activate Phone number<br>
     * <br>
     * <i>Test Method functionality:</i><br>
     * This functionality performs activation of phone number
     * @param custID int
     */

    public void activatePhone(int custID) {
        // initialize classes from interest
        DghQueryManipulation dghQueries = new DghQueryManipulation();
        DghUpdateQueryManipulation dghUpdateQueries = new DghUpdateQueryManipulation();
        TestingResource resource = new TestingResource();
        System.out.println("Step activating customer's phone");
        try {
            dghQueries.getSubscriber(custID);
            int subsId = resource.getSubscriberId();
            if (subsId < 1) {
                Assert.fail("For Customer ID " + custID + ", invalid Subscriber ID is found: " + subsId);
            } else {
                System.out.println("Subs ID for desired phone number is " + subsId);
                int count = dghUpdateQueries.updatePhoneActivation(subsId);
                // check if row is updated
                if (count > 0) {
                    //dghQueries.getSubscriber(custID);
                    // cehck if status is 200 (active)
                   /* if (resource.getSubscriberStatusId() == 200) {
                        System.out.println("For Subs ID " + subsId + ", status is updated to 200");
                    } else {
                        Assert.fail("For Customer ID " + custID + ", Subscriber ID " + subsId + " is not activated");
                    }*/
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * <b>[Test Method]</b> - Activate CO Product<br>
     * <br>
     * <i>Test Method functionality:</i><br>
     * This functionality performs activating CO Product
     * @param custID int
     */

    public void activateCoProduct(int custID) {
        // initialize classes from interest
        DghQueryManipulation dghQueries = new DghQueryManipulation();
        DghUpdateQueryManipulation dghUpdateQueries = new DghUpdateQueryManipulation();
        TestingResource resource = new TestingResource();
        System.out.println("Step activating customer's CO Product");
        try {
            // find CO Products
            dghQueries.getCoProducts(custID);
            int[] productId = resource.getCoProductId();
            // check if customer has CO Products
            if (productId.length > 0) {
                for (int i = 0; i < productId.length; i++) {
                    // update CO Product
                    updateCoProduct(productId[i]);
                    // activate CO Product
                    dghUpdateQueries.activateCoProduct(productId[i]);
                }
                //int count = dghUpdateQueries.deliverRouter(productId);
                /*if (count > 0) {
                    System.out.println("For Customer ID " + custID + ", status of Router is changed to delivered");
                }*/
            } else {
                System.out.println("For Customer ID " + custID + ", there are no Product ID in CO Product table");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <b>[Test Method]</b> - Activate CO Voice Product<br>
     * <br>
     * <i>Test Method functionality:</i><br>
     * This functionality performs activating CO Voice Product
     * @param custID int
     */

    public void activateCoVoiceProduct(int custID) {
        // initialize classes from interest
        DghQueryManipulation dghQueries = new DghQueryManipulation();
        DghUpdateQueryManipulation dghUpdateQueries = new DghUpdateQueryManipulation();
        TestingResource resource = new TestingResource();
        System.out.println("Step activating customer's CO Voice Product");
        try {
            // find CO Products
            dghQueries.getCovProducts(custID);
            int[] productId = resource.getCoVoiceProductId();
            // check if customer has CO Voice Products
            if (productId.length > 0) {
                for (int i = 0; i < productId.length; i++) {
                    // update CO Product
                    updateCoProduct(productId[i]);
                    // activate CO Voice Product
                    dghUpdateQueries.activateCoVoiceProduct(productId[i]);
                }
                //int count = dghUpdateQueries.deliverRouter(productId);
                /*if (count > 0) {
                    System.out.println("For Customer ID " + custID + ", status of Router is changed to delivered");
                }*/
            } else {
                System.out.println("For Customer ID " + custID + ", there are no Product ID in CO Voice Product table");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <b>[Test Method]</b> - Activate Router<br>
     * <br>
     * <i>Test Method functionality:</i><br>
     * This functionality performs router activation
     * @param custID int
     */

    public void activateRouter(int custID) {
        // initialize classes from interest
        DghQueryManipulation dghQueries = new DghQueryManipulation();
        DghUpdateQueryManipulation dghUpdateQueries = new DghUpdateQueryManipulation();
        TestingResource resource = new TestingResource();
        System.out.println("Step activating customer's router");
        try {
            dghQueries.getCoProducts(custID);
            int productId = resource.getCustomerProductId();
            if (productId > 1) {
                System.out.println("Product ID is " + productId);
                int count = dghUpdateQueries.activateCoProduct(productId);
                if (count > 0) {
                    System.out.println("For Customer ID " + custID + ", status of Router is changed to active");
                }
            } else {
                Assert.fail("For Customer ID " + custID + ", invalid Product ID is found: " + productId);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void updateCoProduct(int prodId) {
        System.out.println("Product ID for updating is " + prodId);
        // initialize classes from interest
        DghUpdateQueryManipulation dghUpdateQueries = new DghUpdateQueryManipulation();
        try {
            dghUpdateQueries.deliverRouter(prodId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
