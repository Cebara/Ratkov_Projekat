package automation.database.queryManipulation;

import automation.database.DataBaseConnection;
import automation.database.queries.PortfolioQueries;
import automation.enumaration.DatabaseNames;

import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;

/**
 * <b>DATABASE</b> [Queries]: Portfolio Query Manipulation
 */

public class PortfolioQueryManipulation {

    /**
     * <b>[Method]</b> - Get House ID<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality returns boolean value<br>
     * if House ID exists in Address table, returns true<br>
     * otherwise returns false when response is empty
     */

    public boolean getHouseId(String houseId) {
        String query = PortfolioQueries.getHouses(houseId);
        try {
            // execute
            ResultSet rs = DataBaseConnection.getQueryResponse(DatabaseNames.PORTFOLIO, query);
            int num = QueryManipulation.countQueryRows(rs);
            boolean hasValue = false;
            if (num > 0) {
                hasValue = true;
            }
            return hasValue;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
