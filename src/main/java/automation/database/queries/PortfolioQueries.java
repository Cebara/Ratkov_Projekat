package automation.database.queries;

/**
 * <b>DATABASE</b> [Queries]: Portfolio Database Queries
 *  <i>Class functionality:</i><br>
 *  Class is used to define strings<br>
 *  that will be executed as Portfolio DB queries.<br>
 *  Execution is done in PortfolioQueryManipulation class
 */

public class PortfolioQueries {

    // Query to get assigned houses to campaign instance
    public static String getHouses(String houseId) {
        String query = "select * from address a where a.house_id = '" + houseId + "'";
        return query;
    }


}
