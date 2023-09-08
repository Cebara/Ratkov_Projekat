package automation.de.dg.utils;

/**
 * <b>De.Dg : Utils</b> Testing Resource<br>
 * <i>Class functionality:</i><br>
 *  Class is used for storing testing resources.
 */

public class TestingResource {


    static int customerId;
    static int contractId;
    static int custStatusId;
    static int custGroupId;
    static int custAddressStatusId;
    static int custAddressEmailValid;
    static int subsId;
    static int subStatusId;
    static int custProductId;
    static int voiceProduct[];
    static int oneTimeVoiceProduct[];
    static int product[];
    static int oneTimeProduct[];
    static int subsIdList[];

    //----------------------------------------------------------------------------------------------------------------//
    //                                              Setting Methods
    //----------------------------------------------------------------------------------------------------------------//

    /**
     * <b>[Test Method]</b> - Setting Customer ID<br>
     * <br><i>Test Method functionality:</i><br>
     * Storing Customer ID
     */

    public void setCustomerId(int cus) {
        customerId = cus;
    }

    /**
     * <b>[Test Method]</b> - Setting Contract ID<br>
     * <br><i>Test Method functionality:</i><br>
     * Storing Contract ID
     */

    public void setContractId(int con) {
        contractId = con;
    }

    /**
     * <b>[Test Method]</b> - Setting Customer's Status ID<br>
     * <br><i>Test Method functionality:</i><br>
     * Storing Customer ID
     */

    public void setCustomerStatusId(int status) {
        custStatusId = status;
    }

    /**
     * <b>[Test Method]</b> - Setting Customer's Group ID<br>
     * <br><i>Test Method functionality:</i><br>
     * Storing Customer ID
     */

    public void setCustomerGroupId(int group) {
        custGroupId = group;
    }

    /**
     * <b>[Test Method]</b> - Setting Customer's address Status ID<br>
     * <br><i>Test Method functionality:</i><br>
     * Storing Status ID for customer's address
     */

    public void setCustomerAddressStatusId(int status) {
        custAddressStatusId = status;
    }

    /**
     * <b>[Test Method]</b> - Setting Customer's address Email Valid Status<br>
     * <br><i>Test Method functionality:</i><br>
     * Storing Status email in customer's address
     */

    public void setCustomerAddressValidEmail(int status) {
        custAddressEmailValid = status;
    }

    /**
     * <b>[Test Method]</b> - Setting Subscriber ID<br>
     * <br><i>Test Method functionality:</i><br>
     * Storing Subscriber ID
     */

    public void setSubscriberId(int id) {
        subsId = id;
    }

    /**
     * <b>[Test Method]</b> - Setting Subscriber Status ID<br>
     * <br><i>Test Method functionality:</i><br>
     * Storing Subscriber Status ID
     */

    public void setSubscriberStatusId(int id) {
        subStatusId = id;
    }

    /**
     * <b>[Test Method]</b> - Setting Customer's Product ID<br>
     * <br><i>Test Method functionality:</i><br>
     * Storing Customer's Product ID
     */

    public void setCustomerProductId(int id) {
        custProductId = id;
    }

    /**
     * <b>[Test Method]</b> - Setting Customer's CO Voice Products<br>
     * <br><i>Test Method functionality:</i><br>
     * Storing CO Voice Products ID
     */

    public void setCoVoiceProductId(int[] count) {
        voiceProduct = new int[count.length];
        for (int i = 0; i < count.length; i++) {
            voiceProduct[i] = count[i];
        }
    }

    /**
     * <b>[Test Method]</b> - Setting One-time COV Products<br>
     * <br><i>Test Method functionality:</i><br>
     * Storing one-time CO Voice Products ID
     */

    public void setOneTimeCovProductId(int[] count) {
        oneTimeVoiceProduct = new int[count.length];
        for (int i = 0; i < count.length; i++) {
            oneTimeVoiceProduct[i] = count[i];
        }
    }

    /**
     * <b>[Test Method]</b> - Setting Customer's CO Products<br>
     * <br><i>Test Method functionality:</i><br>
     * Storing CO Products ID
     */

    public void setCoProductId(int[] count) {
        product = new int[count.length];
        for (int i = 0; i < count.length; i++) {
            product[i] = count[i];
        }
    }

    /**
     * <b>[Test Method]</b> - Setting One-time CO Products<br>
     * <br><i>Test Method functionality:</i><br>
     * Storing one-time CO Products ID
     */

    public void setOneTimeCoProductId(int[] count) {
        oneTimeProduct = new int[count.length];
        for (int i = 0; i < count.length; i++) {
            oneTimeProduct[i] = count[i];
        }
    }

    /**
     * <b>[Test Method]</b> - Setting Subscriber list<br>
     * <br><i>Test Method functionality:</i><br>
     * Storing Customer's Subscriber list
     */

    public void setSubscriberList(int[] count) {
        subsIdList = new int[count.length];
        for (int i = 0; i < count.length; i++) {
            subsIdList[i] = count[i];
        }
    }


    //----------------------------------------------------------------------------------------------------------------//
    //                                              Getting Methods
    //----------------------------------------------------------------------------------------------------------------//

    /**
     * <b>[Test Method]</b> - Getting Customer ID<br>
     * <br><i>Test Method functionality:</i><br>
     * Returning Customer ID
     * @return customerId int
     */

    public int getCustomerId() {
        return customerId;
    }

    /**
     * <b>[Test Method]</b> - Getting Contract ID<br>
     * <br><i>Test Method functionality:</i><br>
     * Returning Customer ID
     * @return contractId int
     */

    public int getContractId() {
        return contractId;
    }

    /**
     * <b>[Test Method]</b> - Getting Customer's Status ID<br>
     * <br><i>Test Method functionality:</i><br>
     * Returning Customer's Status ID
     * @return custStatusId int
     */

    public int getCustomerStatusId() {
        return custStatusId;
    }

    /**
     * <b>[Test Method]</b> - Getting Customer's Group ID<br>
     * <br><i>Test Method functionality:</i><br>
     * Returning Customer's Group ID
     * @return custGroupId int
     */

    public int getCustomerGroupId() {
        return custGroupId;
    }

    /**
     * <b>[Test Method]</b> - Getting Customer's Address Status ID<br>
     * <br><i>Test Method functionality:</i><br>
     * Returning Status ID of Customer's address
     * @return custAddressStatusId int
     */

    public int getCustomerAddressStatusId() {
        return custAddressStatusId;
    }

    /**
     * <b>[Test Method]</b> - Getting Customer's Address Email Validation<br>
     * <br><i>Test Method functionality:</i><br>
     * Returning Email Validation Status in Customer's address
     * @return custAddressEmailValid int
     */

    public int getCustomerAddressValidEmail() {
        return custAddressEmailValid;
    }


    /**
     * <b>[Test Method]</b> - Getting Subscriber ID<br>
     * <br><i>Test Method functionality:</i><br>
     * Returning Subscriber ID
     * @return subsId int
     */

    public int getSubscriberId() {
        return subsId;
    }

    /**
     * <b>[Test Method]</b> - Getting Subscriber Status ID<br>
     * <br><i>Test Method functionality:</i><br>
     * Returning Subscriber Status ID
     * @return subsId int
     */

    public int getSubscriberStatusId() {
        return subStatusId;
    }

    /**
     * <b>[Test Method]</b> - Getting Customer's Product ID<br>
     * <br><i>Test Method functionality:</i><br>
     * Returning Customer's Product ID
     * @return subsId int
     */

    public int getCustomerProductId() {
        return custProductId;
    }

    /**
     * <b>[Test Method]</b> - Getting Customer's CO Voice Product IDs<br>
     * <br><i>Test Method functionality:</i><br>
     * Returning Customer's CO Voice Product IDs
     *
     * @return subsId int
     */

    public int[] getCoVoiceProductId() {
        return voiceProduct;
    }

    /**
     * <b>[Test Method]</b> - Getting Customer's one-time COV Product IDs<br>
     * <br><i>Test Method functionality:</i><br>
     * Returning Customer's one-time CO Voice Product IDs
     *
     * @return subsId int
     */

    public int[] getOneTimeCovProductId() {
        return oneTimeVoiceProduct;
    }

    /**
     * <b>[Test Method]</b> - Getting Customer's CO Product IDs<br>
     * <br><i>Test Method functionality:</i><br>
     * Returning Customer's CO Product IDs
     *
     * @return subsId int
     */

    public int[] getCoProductId() {
        return product;
    }

    /**
     * <b>[Test Method]</b> - Getting Customer's one-time CO Product IDs<br>
     * <br><i>Test Method functionality:</i><br>
     * Returning Customer's one-time CO Product IDs
     *
     * @return subsId int
     */

    public int[] getOneTimeCoProductId() {
        return oneTimeProduct;
    }

    /**
     * <b>[Test Method]</b> - Getting Customer's Subscribers IDs<br>
     * <br><i>Test Method functionality:</i><br>
     * Returning Customer's list of Subscriber IDs
     *
     * @return subsIdList int[]
     */

    public int[] getSubscriberList() {
        return subsIdList;
    }

}
