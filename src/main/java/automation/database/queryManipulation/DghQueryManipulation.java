package automation.database.queryManipulation;

import automation.database.DataBaseConnection;
import automation.database.queries.DghQueries;
import automation.de.dg.enumation.AddressTypes;
import automation.de.dg.utils.TestingResource;
import automation.enumaration.DatabaseNames;
import automation.utilities.TestDataGenerator;
import org.firebirdsql.jdbc.FBSQLException;
import org.testng.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;

import static automation.database.queryManipulation.QueryManipulation.countQueryRows;
import static automation.database.queryManipulation.QueryManipulation.returnString;

/**
 * <b>DATABASE</b> [Queries]: DGH Query Manipulation
 */

public class DghQueryManipulation {

    /**
     * <b>[Method]</b> - Get Customer data<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality returns Customer data<br>
     * @throws RuntimeException exception
     */
    public void getCustomer(int customer) throws RuntimeException {
        try {
            // execute query
            ResultSet rs = DataBaseConnection.getQueryResponse(DatabaseNames.DGH, DghQueries.getCustomer(customer));
            // storing customer data
            TestingResource resource = new TestingResource();
            // check if query response contains only one line
            if (QueryManipulation.countQueryRows(rs) == 1) {
                // take Customer's Status ID
                resource.setCustomerStatusId(Integer.parseInt(QueryManipulation.returnString(rs, "STATUS_ID", 1)));
                // take Customer's Group ID
                resource.setCustomerGroupId(Integer.parseInt(QueryManipulation.returnString(rs, "GROUP_ID", 1)));
            } else {
                Assert.fail("Customer id " + customer + " is not unique in CUSTOMER table DGH database");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <b>[Method]</b> - Get House ID<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality returns Customer data<br>
     * @throws RuntimeException exception
     */
    public void getCustomerAddress(int custId, AddressTypes addType) throws NullPointerException, RuntimeException {
        try {
            // execute
            ResultSet rs = DataBaseConnection.getQueryResponse(DatabaseNames.DGH, DghQueries.getCustomerAddress(custId, addType.option));
            // check if empty response is returned
            if (countQueryRows(rs) < 1) {
                Assert.fail("For customer " + custId + " there is no record for request address type " + addType);
            } else {
                int status = Integer.parseInt(QueryManipulation.returnString(rs, "STATUS_ID", 0));
                int validEmail = 0;
                if (QueryManipulation.returnString(rs, "DGH_EMAIL_VALID", 1) != null) {
                    validEmail = Integer.parseInt(QueryManipulation.returnString(rs, "DGH_EMAIL_VALID", 0));
                }
                TestingResource resource = new TestingResource();
                // save status id
                resource.setCustomerAddressStatusId(status);
                resource.setCustomerAddressValidEmail(validEmail);
            }
        } catch (NullPointerException ne) {
            throw new RuntimeException(ne);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <b>[Method]</b> - Get Group ID<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality returns Group ID<br>
     * @return groupId int
     * @throws RuntimeException exception
     */
    public int getGroupId() throws RuntimeException {
        try {
            // execute
            ResultSet rs = DataBaseConnection.getQueryResponse(DatabaseNames.DGH, DghQueries.getGroups);
            // get some random row
            int row = TestDataGenerator.generateRandomNumber(0, QueryManipulation.countQueryRows(rs)-1);
            // find some random group ID
            int groupId = Integer.parseInt(returnString(rs, "GROUP_ID", row));
            return groupId;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <b>[Method]</b> - Get Subscriber<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality get Subscriber data<br>
     * @throws RuntimeException exception
     */

    public void getSubscriber(int custId) {
        try {
            // execute
            ResultSet rs = DataBaseConnection.getQueryResponse(DatabaseNames.DGH, DghQueries.getSubscriber(custId));
            // check if empty row is returned
            if (countQueryRows(rs) < 1) {
                Assert.fail("For customer " + custId + " there is no record in Subscriber table");
            } else {
                int subsId = Integer.parseInt(QueryManipulation.returnString(rs, "SUBS_ID", 1));
                int subStatusId = Integer.parseInt(QueryManipulation.returnString(rs, "STATUS_ID", 1));
                TestingResource resource = new TestingResource();
                // save Subs ID
                resource.setSubscriberId(subsId);
                // save Sub Status ID
                resource.setSubscriberStatusId(subStatusId);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <b>[Method]</b> - Get Subscriber<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality get Subscriber data<br>
     * @param custID int
     * @throws Exception exception
     */

    public void getSubscriberForUpdating(int custID) throws FBSQLException, Exception {
        try {
            // execute
            ResultSet rs = DataBaseConnection.getQueryResponse(DatabaseNames.DGH, DghQueries.getSubscriberForUpdatint(custID));
            // check if empty row is returned
            int counter = countQueryRows(rs);
            if (counter < 1) {
                Assert.fail("For customer " + custID + " there is no record in SUBSCRIBER table");
            } else {
                int product[] = new int[counter];
                for (int i = 0; i < counter; i++) {
                    // taking voice product from database
                    product[i] = Integer.parseInt(QueryManipulation.returnStringForUpdate(rs, "SUBS_ID", i));
                }
                // save Product ID
                TestingResource resource = new TestingResource();
                resource.setSubscriberList(product);
            }
        } catch (FBSQLException fe) {
            throw new FBSQLException(fe);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <b>[Method]</b> - Get CO Product<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality get CO Product data<br>
     * @throws RuntimeException exception
     */

    public void getCoProducts(int custID) {
        try {
            // execute
            ResultSet rs = DataBaseConnection.getQueryResponse(DatabaseNames.DGH, DghQueries.getCoProducts(custID));
            // check if empty row is returned
            int[] product = new int[0];
            if (countQueryRows(rs) < 1) {
                //Assert.fail("For customer " + custID + " there is no record in CO_PRODUCTS table");
            } else {
                product = new int[countQueryRows(rs)];
                for (int i = 0; i < countQueryRows(rs); i++) {
                    product[i] = Integer.parseInt(QueryManipulation.returnStringForUpdate(rs, "CO_PRODUCT_ID", i));
                }
                //int productId = Integer.parseInt(QueryManipulation.returnString(rs, "CO_PRODUCT_ID", 1));
            }
            TestingResource resource = new TestingResource();
            // save Product ID
            resource.setCoProductId(product);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <b>[Method]</b> - Get CO Products for updating<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality get CO Product data<br>
     * found product will be updated
     * @param custID int
     * @throws Exception exception
     */

    public void getCoProductsForUpdating(int custID) throws FBSQLException, Exception {
        try {
            // execute
            ResultSet rs = DataBaseConnection.getQueryResponse(DatabaseNames.DGH, DghQueries.getCoProductsUpdating(custID));
            // check if empty row is returned
            int counter = countQueryRows(rs);
            if (counter < 1) {
                //Assert.fail("For customer " + custID + " there is no record in CO_PRODUCTS table");
                System.out.println("For customer " + custID + " there is no record in CO_PRODUCTS table");
            } else {
                int product[] = new int[counter];
                for (int i = 0; i < counter; i++) {
                    // taking CO Product from database
                    product[i] = Integer.parseInt(QueryManipulation.returnStringForUpdate(rs, "CO_PRODUCT_ID", i));
                }
                // save Product ID
                TestingResource resource = new TestingResource();
                resource.setCoProductId(product);
            }
        } catch (FBSQLException fe) {
            throw new FBSQLException(fe);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <b>[Method]</b> - Get CO One-time Products for updating<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality get one-time CO Product data<br>
     * found product will be updated
     * @param custID int
     * @throws Exception exception
     */

    public void getOnetimeCoProductsForUpdating(int custID) throws FBSQLException, Exception {
        try {
            // execute
            ResultSet rs = DataBaseConnection.getQueryResponse(DatabaseNames.DGH, DghQueries.getOneTimeCoProductsUpdating(custID));
            // check if empty row is returned
            int counter = countQueryRows(rs);
            if (counter < 1) {
                System.out.println("For customer " + custID + " there is no record in CO_PRODUCTS table regarding one-time products");
            } else {
                int product[] = new int[counter];
                for (int i = 0; i < counter; i++) {
                    // taking one-time CO Product from database
                    product[i] = Integer.parseInt(QueryManipulation.returnStringForUpdate(rs, "CO_PRODUCT_ID", i));
                }
                // save Product ID
                TestingResource resource = new TestingResource();
                resource.setOneTimeCoProductId(product);
            }
        } catch (FBSQLException fe) {
            throw new FBSQLException(fe);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <b>[Method]</b> - Get COV Product<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality get CO Voice Product data<br>
     * @throws RuntimeException exception
     */

    public void getCovProducts(int custID) {
        try {
            // execute
            ResultSet rs = DataBaseConnection.getQueryResponse(DatabaseNames.DGH, DghQueries.getCoVoiceProducts(custID));
            // check if empty row is returned
            int[] product = new int[0];
            if (countQueryRows(rs) < 1) {
                //Assert.fail("For customer " + custID + " there is no record in CO_PRODUCTS table");
            } else {
                product = new int[countQueryRows(rs)];
                for (int i = 0; i < countQueryRows(rs); i++) {
                    product[i] = Integer.parseInt(QueryManipulation.returnStringForUpdate(rs, "COV_PRODUCT_ID", i));
                }
                //int productId = Integer.parseInt(QueryManipulation.returnString(rs, "CO_PRODUCT_ID", 1));
            }
            TestingResource resource = new TestingResource();
            // save Product ID
            resource.setCoVoiceProductId(product);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <b>[Method]</b> - Get CO Voice Products for updating<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality get CO Voice Product data<br>
     * found products will be updated
     * @param custID int
     * @throws Exception exception
     */

    public void getCoVoiceProducts(int custID) throws Exception {
        try {
            // execute
            ResultSet rs = DataBaseConnection.getQueryResponse(DatabaseNames.DGH, DghQueries.getCoVoiceProductsUpdating(custID));
            // check if empty row is returned
            int counter = countQueryRows(rs);
            if (counter < 1) {
                System.out.println("For customer " + custID + " there is no record in CO_VOICEDATA_PRODUCTS table");
            } else {
                int voiceProduct[] = new int[counter];
                for (int i = 0; i < counter; i++) {
                    // taking voice product from database
                    voiceProduct[i] = Integer.parseInt(QueryManipulation.returnStringForUpdate(rs, "COV_PRODUCT_ID", i));
                }
                // save Product ID
                TestingResource resource = new TestingResource();
                resource.setCoVoiceProductId(voiceProduct);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <b>[Method]</b> - Get CO One-time CO Voice Products for updating<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality get one-time CO Voice Product data<br>
     * found product will be updated
     * @param custID int
     * @throws Exception exception
     */

    public void getOnetimeCovProductsForUpdating(int custID) throws FBSQLException, Exception {
        try {
            // execute
            ResultSet rs = DataBaseConnection.getQueryResponse(DatabaseNames.DGH, DghQueries.getOneTimeCovProductsUpdating(custID));
            // check if empty row is returned
            int counter = countQueryRows(rs);
            if (counter < 1) {
                System.out.println("For customer " + custID + " there is no record in CO_VOICEDATA_PRODUCTS table regarding one-time products");
            } else {
                int product[] = new int[counter];
                for (int i = 0; i < counter; i++) {
                    // taking one-time CO Product from database
                    product[i] = Integer.parseInt(QueryManipulation.returnStringForUpdate(rs, "cov_product_id", i));
                }
                // save Product ID
                TestingResource resource = new TestingResource();
                resource.setOneTimeCovProductId(product);
            }
        } catch (FBSQLException fe) {
            throw new FBSQLException(fe);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
