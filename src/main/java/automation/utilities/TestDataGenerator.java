package automation.utilities;

import java.sql.SQLException;
import java.util.Random;

/**
 * <b>PAGES : UTILITIES</b> [Generator]: Data Generator
 */

public class TestDataGenerator {

    public static String[] houseIds = {"12345ABC-6226-", "23816DEU-2-", "24211BEI-9-", "30900AVX-87-A", "41069JTG-16-1-", "48727FKI-21-C", "49808ANZ-6-A",
            "52152EHJ-3-", "59320DEG-1-B", "63329XXT-4-", "63329ADH-26-", "76767AAA-10-",  "85665BIK-4-"};


    /**
     * <b>[Method]</b> - Return Random number<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality returns random number<br>
     * from desired column and row<br>
     *
     * @param low int
     * @param high int
     */

    public static int generateRandomNumber(int low, int high) {
        Random random = new Random();
        int number;
        number = random.nextInt((high - low) + 1) + low;
        return number;
    }

}
