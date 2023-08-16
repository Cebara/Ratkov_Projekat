package automation.endpoints;

import java.util.Base64;

/**
 * <b>RESTASSUREAPI</b> [Rest Assure API]: Getting Token for Rest Assure API
 */

public class GetApiAuthorization {

    /**
     * <b>[Method]</b> Generating authorization token<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality generating Base64 token<br>
     * used for Basic Authorization<br>
     * and sent via request's header<br>
     *
     * @param username     String
     * @param password     String
     * @return String token
     */

    public static String getBasicAuthenticationHeader(String username, String password) {
        String valueToEncode = username + ":" + password;
        return "Basic " + Base64.getEncoder().encodeToString(valueToEncode.getBytes());
    }

}
