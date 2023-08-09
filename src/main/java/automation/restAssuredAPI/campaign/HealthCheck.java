package automation.restAssuredAPI.campaign;

import automation.enumaration.RestApiHttpStatusCodes;
import automation.restAssuredAPI.CommonTest;
import automation.restAssuredAPI.RestApiPreparationData;
import automation.restAssuredAPI.constants.CampaignUriPath;
import automation.restAssuredAPI.enumaration.RestApiMethodTypes;
import io.restassured.response.Response;
import org.testng.Assert;
import java.io.UnsupportedEncodingException;

/**
 * <b>RestAPI : Campaign Suite</b> Health Check suite test case
 */

public class HealthCheck extends CommonTest {

    /**
     * <b>[Method]</b> - Health Check Get Campaign Instance Endpoint<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality checks if Get Campaign Instance endpoint is up<br>
     ** <i>Steps of this scenario:</i><br>
     * 1. Execute Get Campaign Instance endpoint<br>
     * 2. Verify that endpoint response contains proper status code<br>
     * @throws UnsupportedEncodingException exception
     */

    public void checkGetCampaignInstanceUp() throws UnsupportedEncodingException {
        try {

            // get response value
            Response response = RestApiPreparationData.returnResponse(RestApiMethodTypes.GET, CommonTest.getRestApiUrl() + CampaignUriPath.CAMPAIGN_INSTANCES + "/1");
            // check proper HTTP response code is in return
            checkStatusCode(response.getStatusCode(), RestApiHttpStatusCodes.BAD_REQUEST.option);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <b>[Method]</b> - Health Check Get All Campaign Endpoint<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality checks if Get All Campaign endpoint is up<br>
     ** <i>Steps of this scenario:</i><br>
     * 1. Execute Get Campaign All endpoint<br>
     * 2. Verify that endpoint response contains proper status code<br>
     * @throws UnsupportedEncodingException exception
     */

    public void checkGetCampaignAllUp() throws UnsupportedEncodingException {
        try {
            // get response value
            Response response = RestApiPreparationData.returnResponse(RestApiMethodTypes.GET, CommonTest.getRestApiUrl() + CampaignUriPath.HOUSE_INSTANCE + "/14211TSC-5-1");
            // check proper HTTP response code is in return
            checkStatusCode(response.getStatusCode(), RestApiHttpStatusCodes.NOT_FOUND.option);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <b>[Method]</b> - Health Check Get Valid Campaign Endpoint<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality checks if Get Campaign endpoint is up<br>
     ** <i>Steps of this scenario:</i><br>
     * 1. Execute Get Valid Campaign endpoint<br>
     * 2. Verify that endpoint response contains proper status code<br>
     * @throws UnsupportedEncodingException exception
     */

    public void checkGetValidCampaignUp() throws UnsupportedEncodingException {
        try {
            // get response value
            Response response = RestApiPreparationData.returnResponse(RestApiMethodTypes.GET, CommonTest.getRestApiUrl() + CampaignUriPath.HOUSE_INSTANCE + "/14211TSC-5-1111111");
            // check proper HTTP response code is in return
            checkStatusCode(response.getStatusCode(), RestApiHttpStatusCodes.NOT_FOUND.option);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <b>[Method]</b> - Health Check Post Campaign Instance Endpoint<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality checks if Post Campaign Instance endpoint is up<br>
     ** <i>Steps of this scenario:</i><br>
     * 1. Execute Post Campaign Instance endpoint<br>
     * 2. Verify that endpoint response contains proper status code<br>
     * @throws UnsupportedEncodingException exception
     */

    public void checkPostCampaignInstanceUp() throws UnsupportedEncodingException {
        try {
            // initialize request's body
            RestApiPreparationData.setBody("{}");
            // get response value
            Response response = RestApiPreparationData.returnResponse(RestApiMethodTypes.POST, CommonTest.getRestApiUrl() + CampaignUriPath.CAMPAIGN_INSTANCES);
            // check proper HTTP response code is in return
            checkStatusCode(response.getStatusCode(), RestApiHttpStatusCodes.BAD_REQUEST.option);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <b>[Method]</b> - Health Check Put Campaign Instance Endpoint<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality checks if Put Campaign Instance endpoint is up<br>
     ** <i>Steps of this scenario:</i><br>
     * 1. Execute Put Campaign Instance endpoint<br>
     * 2. Verify that endpoint response contains proper status code<br>
     * @throws UnsupportedEncodingException exception
     */

    public void checkPutCampaignInstanceUp() throws UnsupportedEncodingException {
        try {
            // initialize request's body
            RestApiPreparationData.setBody("{}");
            // get response value
            Response response = RestApiPreparationData.returnResponse(RestApiMethodTypes.PUT, CommonTest.getRestApiUrl() + CampaignUriPath.CAMPAIGN_INSTANCES + "/1");
            // check proper HTTP response code is in return
            checkStatusCode(response.getStatusCode(), RestApiHttpStatusCodes.BAD_REQUEST.option);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <b>[Method]</b> - Health Check Delete Campaign Instance Endpoint<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality checks if Delete Campaign endpoint is up<br>
     ** <i>Steps of this scenario:</i><br>
     * 1. Execute Delete Campaign endpoint<br>
     * 2. Verify that endpoint response contains proper status code<br>
     * @throws UnsupportedEncodingException exception
     */

    public void checkDeleteCampaignInstanceUp() throws UnsupportedEncodingException {
        try {
            // get response value
            Response response = RestApiPreparationData.returnResponse(RestApiMethodTypes.DELETE, CommonTest.getRestApiUrl() + CampaignUriPath.CAMPAIGN_INSTANCES + "/1");
            // check proper HTTP response code is in return
            checkStatusCode(response.getStatusCode(), RestApiHttpStatusCodes.BAD_REQUEST.option);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <b>[Method]</b> - Health Check Delete All Campaigns Endpoint<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality checks if Delete All Campaigns endpoint is up<br>
     ** <i>Steps of this scenario:</i><br>
     * 1. Execute Delete All Campaigns endpoint<br>
     * 2. Verify that endpoint response contains proper status code<br>
     * @throws UnsupportedEncodingException exception
     */

    public void checkDeleteAllCampaigns() throws UnsupportedEncodingException {
        try {
            // get response value
            Response response = RestApiPreparationData.returnResponse(RestApiMethodTypes.DELETE, CommonTest.getRestApiUrl() + CampaignUriPath.HOUSE_INSTANCE + "/14211TSC-5-1111");
            // check proper HTTP response code is in return
            checkStatusCode(response.getStatusCode(), RestApiHttpStatusCodes.NOT_FOUND.option);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <b>[Method]</b> - Check Status Code<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality checks API status code<br>
     * compare expected HTTP status code with actual response's status code
     *
     * @param expected Expected HTTP status code
     * @param actual HTTP status code in response
     */

    private void checkStatusCode(int expected, int actual) {
        Assert.assertEquals(expected, actual, "Response HTTP status code is not in expected status");
    }

}
