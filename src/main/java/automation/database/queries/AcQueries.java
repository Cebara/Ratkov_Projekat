package automation.database.queries;

/**
 * <b>DATABASE</b> [Queries]: AR/AC Database Queries
 *  <i>Class functionality:</i><br>
 *  Class is used to define strings<br>
 *  that will be executed as AR/AC DB queries.<br>
 *  Execution is done in AcQueryManipulation class
 */

public class AcQueries {

    public static String distinctZipCodes = "SELECT DISTINCT ac.ZIP_CODE_NUMBERS from AC_CONNECTION ac";

    public static String distinctZipChars(String zipCode) {
        String zipChar;
        return zipChar = "SELECT DISTINCT ac.ZIP_CODE_CHARACTERS \n" +
                "from AC_CONNECTION ac where ac.ZIP_CODE_NUMBERS = " + zipCode + "";
    }

    public static String returnHouseId(String zipCode, String zipChar) {
        String houseId;
        return houseId = "SELECT ac.HOUSE_NUMBER_VALUE, ac.HOUSE_NUMBER_EXTENSION, ac.ROOM \n" +
                "from AC_CONNECTION ac where ac.ZIP_CODE_NUMBERS = " + zipCode + "\n" +
                "and ac.ZIP_CODE_CHARACTERS = '" + zipChar + "'";
    }

}
