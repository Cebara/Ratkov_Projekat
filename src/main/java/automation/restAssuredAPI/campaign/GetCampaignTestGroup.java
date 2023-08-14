package automation.restAssuredAPI.campaign;

import automation.enumaration.RestApiHttpStatusCodes;
import automation.restAssuredAPI.CommonTest;
import automation.restAssuredAPI.RestApiPreparationData;
import automation.restAssuredAPI.constants.CampaignUriPath;
import automation.restAssuredAPI.enumaration.RestApiMethodTypes;
import io.restassured.response.Response;

import java.util.ArrayList;

/**
 * <b>RestAPI : Campaign Suite</b> Get Method Test Suite
 *  <i>Class functionality:</i><br>
 *  Class is used to execute endpoint with Get method type<br>
 */

public class GetCampaignTestGroup extends CommonTest  {

    /**
     * <b>[Method]</b> - Get Valid Campaign(s)<br>
     * <i>Method functionality:</i><br>
     * This functionality returns valid Campaign(s)<br>
     * assigned to House ID
     */

    public String getValidCampaign(String houseId) {
// get response value
        Response response = RestApiPreparationData.returnResponse(RestApiMethodTypes.GET, CommonTest.getRestApiUrl() + CampaignUriPath.HOUSE_INSTANCE + "/" + houseId);
        // check proper HTTP response code is in return
        checkStatusCode(response.getStatusCode(), RestApiHttpStatusCodes.OK.option);
        //
        ArrayList array = response.jsonPath().getJsonObject("campaignName");
        String campaign = (String) array.get(0);
        return campaign;
    }

}
