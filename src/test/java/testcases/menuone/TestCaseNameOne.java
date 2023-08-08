package testcases.menuone;

import automation.database.DataBaseConnection;
import automation.enumaration.DatabaseNames;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.sql.ResultSet;

@Listeners(automation.listeners.ExtentApiListener.class)
public class TestCaseNameOne {

    @Test
    public void testDbCon() throws Exception {
        try {
            ResultSet rs = DataBaseConnection.getQueryResponse(DatabaseNames.PORTFOLIO, "select * from campaign_instance ci where ci.fk_address_id = '1'");
            rs.beforeFirst();
            if (rs.next()) {
                String esn = rs.getString("campaign_name");
                System.out.println(esn);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
