package automation.restAssuredAPI.campaign;

import automation.database.queryManipulation.AcQueryManipulation;
import automation.database.queryManipulation.PlmQueryManipulation;
import automation.database.queryManipulation.PortfolioQueryManipulation;
import automation.enumaration.RestApiHttpStatusCodes;
import automation.enumaration.dgfEnums.DgfChannels;
import automation.enumaration.dgfEnums.DgfMarketingSegment;
import automation.restAssuredAPI.CommonTest;
import automation.utilities.TestDataGenerator;
import org.json.JSONObject;
import org.testng.Assert;

import java.io.UnsupportedEncodingException;

/**
 * <b>RestAPI : Campaign Suite</b> House Instance Suite<br>
 * <i>Class functionality:</i><br>
 *  Class is used to define flow for test cases<br>
 *  that call House Instance URI path from Campaign API
 */

public class SuiteHouseInstance extends CommonTest {

    /**
     * <b>[Method]</b> - Flow of assigning Campaign Instance to House ID<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality assign Campaign Instance to House ID<br>
     ** <i>Steps of this scenario:</i><br>
     * 1. Execute Get Campaign Instance endpoint<br>
     * 2. Verify that endpoint response contains proper status code<br>
     * @throws UnsupportedEncodingException exception
     */

    public void flowAssignCampaignInstance() {
        try {
            // step 1 - find Campaign
            PlmQueryManipulation plmQueries = new PlmQueryManipulation();
            String[] value = plmQueries.getAvailableCampaigns(DgfMarketingSegment.DGH);
            System.out.println("Chosen Campaign:" + value[1]);

            // step 2 - find House ID
            //AcQueryManipulation acQueries = new AcQueryManipulation();
            //acQueries.getHouseId();
            String houseId = TestDataGenerator.houseIds[TestDataGenerator.generateRandomNumber(0, TestDataGenerator.houseIds.length-1)];
            System.out.println("Selected House ID:" + houseId);

            // step 3 - delete existing Campaigns linked to House ID
            PortfolioQueryManipulation portfolioQueries = new PortfolioQueryManipulation();
            DeleteCampaignTestGroup deleteCampaign = new DeleteCampaignTestGroup();
            // check if House ID exists in Address table
            boolean hasRecord = portfolioQueries.getHouseId(houseId);
            // delete all records from Address table
            if (hasRecord) {
                deleteCampaign.deleteAllCampaigns(houseId, RestApiHttpStatusCodes.NO_CONTENT.option);
            } else {
                deleteCampaign.deleteAllCampaigns(houseId, RestApiHttpStatusCodes.NOT_FOUND.option);
            }

            // step 4 - add Campaign to House ID
            PostCampaignTestGroup postCampaing = new PostCampaignTestGroup();
            // generate body
            JSONObject campaign = postCampaing.setCampaignInstance(Integer.parseInt(value[0]), value[1], DgfMarketingSegment.DGH.option.toUpperCase(), 1, DgfChannels.ALL.option.toUpperCase());
            JSONObject body = postCampaing.setPostCampaign(houseId, campaign);
            // execute Post endpoint
            postCampaing.assignValidCampaign(String.valueOf(body));

            // step 5 - check if Campaign becomes valid
            GetCampaignTestGroup getCampaign = new GetCampaignTestGroup();
            String returnedCampaign = getCampaign.getValidCampaign(houseId);

            // step 6 - check if desired Campaign is returned
            System.out.println("Expected assigned Campaign:" + value[1]);
            System.out.println("Returned assigned Campaign:" + returnedCampaign);
            Assert.assertEquals(value[1], returnedCampaign, "Returned Campaign is not same as expected");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
