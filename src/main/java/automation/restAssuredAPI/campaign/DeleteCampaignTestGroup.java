package automation.restAssuredAPI.campaign;

import automation.enumaration.RestApiHttpStatusCodes;
import automation.restAssuredAPI.CommonTest;
import automation.restAssuredAPI.RestApiPreparationData;
import automation.restAssuredAPI.constants.CampaignUriPath;
import automation.restAssuredAPI.enumaration.RestApiMethodTypes;
import io.restassured.response.Response;

import java.io.UnsupportedEncodingException;

/**
 * <b>RestAPI : Campaign Suite</b> Delete Method Test Suite
 *  <i>Class functionality:</i><br>
 *  Class is used to execute endpoint with Delete method type<br>
 */

public class DeleteCampaignTestGroup extends CommonTest  {

    /**
     * <b>[Method]</b> - Delete All Campaigns<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality deletes all Campaigns<br>
     ** <i>Steps of this scenario:</i><br>
     */

    public void deleteAllCampaigns(String houseID, int expectedCode) {
        try {
            // get response value
            Response response = RestApiPreparationData.returnResponse(RestApiMethodTypes.DELETE, CommonTest.getRestApiUrl() + CampaignUriPath.HOUSE_INSTANCE + "/" + houseID);
            // check proper HTTP response code is in return
            checkStatusCode(response.getStatusCode(), expectedCode);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
