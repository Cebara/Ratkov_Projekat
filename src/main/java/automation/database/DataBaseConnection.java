package automation.database;

import automation.enumaration.DatabaseNames;
import automation.listeners.ExtentListeners;
import automation.properties.PropertyManager;
import com.aventstack.extentreports.Status;

import java.sql.*;

import static org.testng.AssertJUnit.fail;

/**
 * <b>DATABASE</b> [Database]: Establish Database Connection
 */

public class DataBaseConnection {

    private static String dbHostUrl;
    private static String dbUser;
    private static String dbPass;

    /**
     * <b>[Method]</b> - Get DB Query Response<br>
     * <br>
     * <i>Method functionality:</i><br>
     * Establishing DB connection, execute query and returns response<br>
     *
     * @param dbName Database Name
     * @param query  Database Query
     * @return returning query response
     * @throws ClassNotFoundException exception
     * @throws SQLException           exception
     */
    public static ResultSet getQueryResponse(DatabaseNames dbName, String query) throws Exception {
        ResultSet rs = null;
        // define connection value
        setDatabaseHostname(dbName);
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // create connection to database
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@" + getDbHostUrl(), getDbUsername(), getDbPassword());
            // create statement for connection
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            // execute query
            rs = st.executeQuery(query);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail("Database driver is not found");
            ExtentListeners.test.log(Status.FAIL, "Database driver is not found");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail("Could not establish connection to the database " + dbName);
            ExtentListeners.test.log(Status.FAIL, "Connection to the database " + dbName + " cannot be established");
        }
        // return statement
        return rs;
    }

    /**
     * <b>[Method]</b> - Setting Database Data<br>
     * <br>
     * <i>Method functionality:</i><br>
     * Setting values for database connection<br>
     * Host URL (host:port:sid), Username, Password<br>
     *
     * @param dbName Database Name
     */
    private static void setDatabaseHostname(DatabaseNames dbName) {
        String host = null;
        String user = null;
        String pass = null;

        switch (dbName) {
            case DB:
                host = PropertyManager.dbHostname + ":" + PropertyManager.dbPort + ":" + PropertyManager.dbSid;
                user = PropertyManager.dbUsername;
                pass = PropertyManager.dbPassword;
                break;
            default:
                host = PropertyManager.dbHostname + ":" + PropertyManager.dbPort + ":" + PropertyManager.dbSid;
                user = PropertyManager.dbUsername;
                pass = PropertyManager.dbPassword;
                break;
        }

        setDbHostUrl(host);
        setDbUsername(user);
        setDbPassword(pass);
    }

    /**
     * <b>[Method]</b> - Getting Database Host URL<br>
     *
     * @return Database Host URL
     */
    private static String getDbHostUrl() {
        return dbHostUrl;
    }

    /**
     * <b>[Method]</b> - Setting Database Host URL<br>
     *
     * @param host Database Host URL
     */

    private static void setDbHostUrl(String host) {
        dbHostUrl = host;
    }

    /**
     * <b>[Method]</b> - Getting Database Host URL<br>
     *
     * @return Database Username
     */
    private static String getDbUsername() {
        return dbUser;
    }

    /**
     * <b>[Method]</b> - Setting Database Username<br>
     *
     * @param user Database Username
     */

    private static void setDbUsername(String user) {
        dbUser = user;
    }

    /**
     * <b>[Method]</b> - Getting Database Host URL<br>
     *
     * @return Database Password
     */
    private static String getDbPassword() {
        return dbPass;
    }

    /**
     * <b>[Method]</b> - Setting Database Password<br>
     *
     * @param pass Database Password
     */

    private static void setDbPassword(String pass) {
        dbPass = pass;
    }

}
