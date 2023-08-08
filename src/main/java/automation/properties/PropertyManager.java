package automation.properties;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * <b>PROPERTIES</b> [Properties]: Property Manager
 */

public class PropertyManager {

    private final static String propertyFilePath = "src/test/resources/properties/Config.properties";
    public static String dbHostnamePortfolio;
    public static String dbPortPortfolio;
    public static String dbUsernamePortfolio;
    public static String dbPasswordPortfolio;
    public static String dbHostname;
    public static String dbPort;
    public static String dbUsername;
    public static String dbPassword;
    private static Properties properties;

    /**
     * <b>[Method]</b> - Config File Reader<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality read config.properties file and store values for further use<br>
     * Property Manager Method is called on Start<br>
     */

    public static void ConfigFileReader() throws FileNotFoundException {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();

            try {
                // load config file
                properties.load(reader);
                //import DB connection info
                dbHostnamePortfolio = properties.getProperty("dbHostnamePortfolio");
                dbPortPortfolio = properties.getProperty("dbPortPortfolio");
                dbUsernamePortfolio = properties.getProperty("dbUsernamePortfolio");
                dbPasswordPortfolio = properties.getProperty("dbPasswordPortfolio");

                // close File
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("config.properties not found at " + propertyFilePath);
        }
    }

}
