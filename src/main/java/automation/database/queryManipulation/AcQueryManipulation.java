package automation.database.queryManipulation;

import automation.database.DataBaseConnection;
import automation.database.queries.AcQueries;
import automation.enumaration.DatabaseNames;
import automation.utilities.TestDataGenerator;

import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;

/**
 * <b>DATABASE</b> [Queries]: AR/AC Query Manipulation
 */

public class AcQueryManipulation {

    /**
     * <b>[Method]</b> - Get House ID<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality returns House ID<br>
     *
     * @throws UnsupportedEncodingException exception
     */

    public String getHouseId() {
        String houseId = null;
        try {
            // get distinct zip codes
            String zipCode = AcQueries.distinctZipCodes;
            // execute
            ResultSet rs = DataBaseConnection.getQueryResponse(DatabaseNames.AC, zipCode);
            // get some random row
            int row = TestDataGenerator.generateRandomNumber(0, QueryManipulation.countQueryRows(rs));
            zipCode = QueryManipulation.returnString(rs, "ZIP_CODE_NUMBERS", row);

            // get distinct zip codes
            String zipChar = AcQueries.distinctZipChars(zipCode);
            // execute
            rs = DataBaseConnection.getQueryResponse(DatabaseNames.AC, zipChar);
            // get some random row
            row = TestDataGenerator.generateRandomNumber(0, QueryManipulation.countQueryRows(rs));
            zipChar = QueryManipulation.returnString(rs, "ZIP_CODE_CHARACTERS", row);

            // get house number
            String house = AcQueries.returnHouseId(zipCode, zipChar);
            // execute
            rs = DataBaseConnection.getQueryResponse(DatabaseNames.AC, zipCode);
            // get some random row
            row = TestDataGenerator.generateRandomNumber(0, QueryManipulation.countQueryRows(rs));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return houseId;
    }
}
