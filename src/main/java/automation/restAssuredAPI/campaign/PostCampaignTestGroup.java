package automation.restAssuredAPI.campaign;

import automation.enumaration.RestApiHttpStatusCodes;
import automation.restAssuredAPI.CommonTest;
import automation.restAssuredAPI.RestApiPreparationData;
import automation.restAssuredAPI.constants.CampaignUriPath;
import automation.restAssuredAPI.enumaration.RestApiMethodTypes;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

/**
 * <b>RestAPI : Campaign Suite</b> Post Method Test Suite
 *  <i>Class functionality:</i><br>
 *  Class is used to execute endpoint with Post method type<br>
 */

public class PostCampaignTestGroup extends CommonTest {

    /**
     * <b>[Method]</b> - Assign Campaign to House ID<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality assign Campaign to house<br>
     * It is done using Post endpoint
     */

    public void assignValidCampaign(String body) {
        try {
            // initialize request's body
            RestApiPreparationData.setBody(body);
            // get response value
            Response response = RestApiPreparationData.returnResponse(RestApiMethodTypes.POST, CommonTest.getRestApiUrl() + CampaignUriPath.CAMPAIGN_INSTANCES);
            // check proper HTTP response code is in return
            checkStatusCode(response.getStatusCode(), RestApiHttpStatusCodes.CREATED.option);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <b>[Method]</b> - Set Body for Post Assign Method<br>
     * <i>Method functionality:</i><br>
     * This functionality prepare Body Request<br>
     */

    public JSONObject setPostCampaign(String houseId, JSONObject campaign) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("houseId", houseId);
        requestParams.put("campaignInstance", campaign);
        return requestParams;
    }

    /**
     * <b>[Method]</b> - Set Campaign Instance<br>
     * <i>Method functionality:</i><br>
     * This functionality prepare Campaign Instance<br>
     * Campaign Instance is part of Request's Body
     */

    public JSONObject setCampaignInstance(int campId, String campName, String marketingSegment, int ranking, String channel) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("campaignId", campId);
        requestParams.put("campaignName", campName);
        requestParams.put("marketingSegment", marketingSegment);
        requestParams.put("startDateTime", "2023-03-01T00:00:00Z");
        requestParams.put("ranking", ranking);
        requestParams.put("channel", channel);
        return requestParams;
    }

}
