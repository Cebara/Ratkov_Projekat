package automation.restAssuredAPI.campaign;

import automation.enumaration.RestApiHttpStatusCodes;
import automation.restAssuredAPI.CommonTest;
import automation.restAssuredAPI.constants.CampaignUriPath;
import io.restassured.response.Response;
import org.testng.Assert;
import java.io.UnsupportedEncodingException;

/**
 * <b>RestAPI : Campaign Suite</b> Health Check suite test case
 */

public class HealthCheck extends CommonTest {

    /**
     * <b>[Method]</b> - Health Check Get All Campaign<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality check is Get Campaign Instance endpoint is up<br>
     ** <i>Steps of this scenario:</i><br>
     * 1. Execute Get Campaign Instance endpoint<br>
     * 2. Verify that endpoint response contains proper status code<br>
     * @throws UnsupportedEncodingException exception
     */

    public void checkGetCampaignInstance() throws UnsupportedEncodingException {
        try {
            // get response value
            Response response = CommonTest.get(CommonTest.getRestApiUrl() + CampaignUriPath.CAMPAIGN_INSTANCES + "/1");
            // check proper HTTP response code is in return
            System.out.println(response.getStatusCode());
            Assert.assertEquals(response.getStatusCode(), RestApiHttpStatusCodes.BAD_REQUEST.option, "Response HTTP status code is not in expected status");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <b>[Method]</b> - Health Check Get All Campaign<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality check is Get All Campaign endpoint is up<br>
     ** <i>Steps of this scenario:</i><br>
     * 1. Execute Get Campaign All endpoint<br>
     * 2. Verify that endpoint response contains proper status code<br>
     * @throws UnsupportedEncodingException exception
     */

    public void checkGetCampaignAllUp() throws UnsupportedEncodingException {
        try {
            // get response value
            Response response = CommonTest.get(CommonTest.getRestApiUrl() + CampaignUriPath.HOUSE_INSTANCE + "/14211TSC-5-1");
            // check proper HTTP response code is in return
            System.out.println(response.getStatusCode());
            Assert.assertEquals(response.getStatusCode(), RestApiHttpStatusCodes.NOT_FOUND.option, "Response HTTP status code is not in expected status");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

}
