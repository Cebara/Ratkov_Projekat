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
    public static String dbHostnameAc;
    public static String dbPortAc;
    public static String dbNameAc;
    public static String dbUsernameAc;
    public static String dbPasswordAc;
    public static String dbHostnameDgh;
    public static String dbPortDgh;
    public static String dbNameDgh;
    public static String dbUsernameDgh;
    public static String dbPasswordDgh;
    public static String dbHostnamePlm;
    public static String dbPortPlm;
    public static String dbNamePlm;
    public static String dbUsernamePlm;
    public static String dbPasswordPlm;
    public static String dbHostnamePortfolio;
    public static String dbPortPortfolio;
    public static String dbNamePortfolio;
    public static String dbUsernamePortfolio;
    public static String dbPasswordPortfolio;
    public static String dbHostnameProduct;
    public static String dbPortProduct;
    public static String dbNameProduct;
    public static String dbUsernameProduct;
    public static String dbPasswordProduct;
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
                // AC
                dbHostnameAc = properties.getProperty("dbHostnameAc");
                dbPortAc = properties.getProperty("dbPortAc");
                dbNameAc = properties.getProperty("dbNameAc");
                dbUsernameAc = properties.getProperty("dbUsernameAc");
                dbPasswordAc = properties.getProperty("dbPasswordAc");
                // DGH
                dbHostnameDgh = properties.getProperty("dbHostnameDgh");
                dbPortDgh = properties.getProperty("dbPortDgh");
                dbNameDgh = properties.getProperty("dbNameDgh");
                dbUsernameDgh = properties.getProperty("dbUsernameDgh");
                dbPasswordDgh = properties.getProperty("dbPasswordDgh");
                // PLM
                dbHostnamePlm = properties.getProperty("dbHostnamePlm");
                dbPortPlm = properties.getProperty("dbPortPlm");
                dbNamePlm = properties.getProperty("dbNamePlm");
                dbUsernamePlm = properties.getProperty("dbUsernamePlm");
                dbPasswordPlm = properties.getProperty("dbPasswordPlm");
                // Portfolio
                dbHostnamePortfolio = properties.getProperty("dbHostnamePortfolio");
                dbPortPortfolio = properties.getProperty("dbPortPortfolio");
                dbNamePortfolio = properties.getProperty("dbNamePortfolio");
                dbUsernamePortfolio = properties.getProperty("dbUsernamePortfolio");
                dbPasswordPortfolio = properties.getProperty("dbPasswordPortfolio");
                // Product
                dbHostnameProduct = properties.getProperty("dbHostnameProduct");
                dbPortProduct = properties.getProperty("dbPortProduct");
                dbNameProduct = properties.getProperty("Product");
                dbUsernameProduct = properties.getProperty("dbUsernameProduct");
                dbPasswordProduct = properties.getProperty("dbPasswordProduct");

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
