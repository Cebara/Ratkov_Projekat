package automation.de.dg.endpoints.cimrest.customers.controllers;

import automation.de.dg.endpoints.constants.Attachment;
import automation.de.dg.endpoints.constants.CimUriPath;
import automation.endpoints.CommonTest;
import automation.endpoints.RestApiPreparationData;
import automation.endpoints.enumaration.RestApiMethodTypes;
import automation.enumaration.RestApiHttpStatusCodes;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * <b>RestAPI : Cim Rest Suite/Customer</b> Post Method Test Suite<br>
 *  <i>Class functionality:</i><br>
 *  Class is used to execute endpoint with Post method type<br>
 *  under Customers controller umbrella
 */

public class PostCreateCustomer extends CommonTest {

    /**
     * <b>[Method]</b> - Create Customer<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality create customer
     */

    public Response createCustomer(String body) {
        try {
            // initialize request's body
            RestApiPreparationData.setBody(body);
            // get response value
            Response response = RestApiPreparationData.returnResponse(RestApiMethodTypes.POST, CommonTest.getRestApiUrl() + CimUriPath.REST_URL + CimUriPath.CUSTOMER_INSTANCE + "/create_contract");
            // check proper HTTP response code is in return
            checkStatusCode(response.getStatusCode(), RestApiHttpStatusCodes.OK.option);
            // return response
            return response;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public JSONObject body() {
        JSONObject body = new JSONObject();
        body.put("attachments", attachmentPart());
        body.put("bankAccount", bankHolderPart());
        body.put("billingAddress", billingAddressPart());
        body.put("contract", contractPart());
        body.put("customer", customerPart());
        body.put("optin", optinPart());
        body.put("orderType", "SALE");
        body.put("remark", "");
        body.put("shippingAddress", shippingAddressPart());

        return body;
    }

    /**
     * <b>[Method]</b> - Set Attachment Body Part<br>
     * <i>Method functionality:</i><br>
     * This functionality prepare attachment part of Body Request<br>
     */

    public JSONArray attachmentPart() {
        JSONArray attachment = new JSONArray();
        JSONObject requestParams = new JSONObject();
        requestParams.put("content", Attachment.ATTACHMENT);
        requestParams.put("mimeType", "image/jpeg");
        requestParams.put("name", "page_1");
        requestParams.put("type", "VZF_ONLINE");

        attachment.put(requestParams);
        return attachment;
    }

    /**
     * <b>[Method]</b> - Set Bank Holder Body Part<br>
     * <i>Method functionality:</i><br>
     * This functionality prepare Bank Holder part of Body Request<br>
     */

    public JSONObject bankHolderPart() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("accountHolder", "ratko zekic");
        requestParams.put("iban", "DE75512108001245126199");
        return requestParams;
    }

    /**
     * <b>[Method]</b> - Set Billing Address Body Part<br>
     * <i>Method functionality:</i><br>
     * This functionality prepare Billing Address part of Body Request<br>
     */

    public JSONObject billingAddressPart() {
        JSONObject requestParams = new JSONObject();
        // call address method to get data
        JSONObject address = address();
        // store address data in billing address part
        address.keySet().forEach(keyStr ->
        {
            Object keyvalue = address.get(keyStr);
            requestParams.put(keyStr, keyvalue);
        });
        requestParams.put("individual", individualPart());
        return requestParams;
    }

    /**
     * <b>[Method]</b> - Set Billing Individual Body Part<br>
     * <i>Method functionality:</i><br>
     * This functionality prepare Individual part<br>
     * for Billing Address and Customer which is part of Body Request<br>
     */
    public JSONObject individualPart() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("birthday", "1976-05-30");
        requestParams.put("companyName", "");
        requestParams.put("firstname", "ratko");
        requestParams.put("lastname", "zekic");
        requestParams.put("salutation", "MR");
        requestParams.put("salutationId", "100001");
        return requestParams;
    }

    /**
     * <b>[Method]</b> - Set Customer Body Part<br>
     * <i>Method functionality:</i><br>
     * This functionality prepare Customer part of Body Request<br>
     */

    public JSONObject customerPart() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("customerType", "PK");
        requestParams.put("email", "ratko.zekic11@seavus.com");
        JSONArray individuale = new JSONArray();
        individuale.put(individualPart());

        requestParams.put("individuals", individuale);
        requestParams.put("mobile", "");
        requestParams.put("paymentType", "SEPA");
        requestParams.put("phone", "+49 8541 854557878");
        return requestParams;
    }

    /**
     * <b>[Method]</b> - Set Contract Body Part<br>
     * <i>Method functionality:</i><br>
     * This functionality prepare Contract part of Body Request<br>
     */

    public JSONObject contractPart() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("bookingId", "10009784861692291171");
        requestParams.put("connection", address());
        requestParams.put("creationDate", "2023-08-18");
        requestParams.put("evnType", "ANONYMOUS");
        requestParams.put("mainProduct", MainProduct.mainProduct());
        requestParams.put("marketingChannel", "ONLINE");
        requestParams.put("partnerId", 10004);
        requestParams.put("saleChannel", "Consumer Website");
        requestParams.put("signatureDate", "2023-08-18");
        requestParams.put("signatureType", "ONLINE");
        requestParams.put("telephoneNumbers", telephone());
        return requestParams;
    }

    /**
     * <b>[Method]</b> - Set Optin Body Part<br>
     * <i>Method functionality:</i><br>
     * This functionality prepare Optin part of Body Request<br>
     */

    public JSONObject optinPart() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("email", false);
        requestParams.put("optinProvidedByCustomer", true);
        requestParams.put("phone", false);
        requestParams.put("post", false);
        requestParams.put("trafficDataUsage", false);
        return requestParams;
    }

    /**
     * <b>[Method]</b> - Set Shipping Address Body Part<br>
     * <i>Method functionality:</i><br>
     * This functionality prepare Shipping Address part of Body Request<br>
     */

    public JSONObject shippingAddressPart() {
        JSONObject requestParams = new JSONObject();
        // call address method to get data
        JSONObject address = address();
        // store address data in billing address part
        address.keySet().forEach(keyStr ->
        {
            Object keyvalue = address.get(keyStr);
            requestParams.put(keyStr, keyvalue);
        });
        requestParams.put("individual", individualPart());
        return requestParams;
    }

    private JSONArray telephone() {
        JSONArray telephone = new JSONArray();
        JSONObject phone = new JSONObject();

        JSONObject porting = new JSONObject();
        /*JSONObject address = new JSONObject();
        address.put("city", "Nahe");
        address.put("country", "DE");
        address.put("housenumber", 2);
        address.put("street", "Lüttd\u00f6rp");
        address.put("zipCode", "23866");*/

        // call address method to get data
        JSONObject address = address();

        porting.put("contractAddress", address);
        porting.put("ekpId", 10190);
        porting.put("individual", individualPart());

        phone.put("number", "+49 211 845648987");
        phone.put("porting", porting);
        //phone.put("type", "PORTING");
        phone.put("type", "NEW");
        telephone.put(phone);

        /*JSONObject other = new JSONObject();
        other.put("type", "NEW");

        telephone.put(other);
        telephone.put(other);
        telephone.put(other);
        telephone.put(other);*/
        return telephone;
    }

    private JSONObject address() {
        JSONObject address = new JSONObject();
        address.put("city", "Nahe");
        address.put("country", "DE");
        address.put("housenumber", 36);
        address.put("street", "Dorfstra\u00dfe");
        address.put("zipCode", "23866");
        return address;
    }

}
