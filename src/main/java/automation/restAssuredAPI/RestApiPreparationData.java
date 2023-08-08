package automation.restAssuredAPI;

import automation.restAssuredAPI.enumaration.RestApiMethodTypes;
import io.restassured.response.Response;
import java.io.UnsupportedEncodingException;

public class RestApiPreparationData extends CommonTest {

    static String body;
    static RestApiMethodTypes method;


    /**
     * <b>[Method]</b> Return API Response<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality returns API Response<br>
     * Execute API endpoint based on selected method type<br>
     *
     * @param method     RestApiMethodTypes
     * @param url     String
     * @return Response response
     */

    public Response returnResponse(RestApiMethodTypes method, String url) {
        Response response = null;
        try {
            switch (method) {
                case GET -> {
                    response = get(url);
                    break;
                }
                case POST -> {
                    response = post(getBody(), url);
                    break;
                }
                case PUT -> {
                    response = put(getBody(), url);
                    break;
                }
                case PATCH -> {
                    response = patch(getBody(), url);
                    break;
                }
                case DELETE -> {
                    response = delete(url);
                }
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    /**
     * <b>[Test Method]</b> - Setting Request Body<br>
     * <br><i>Test Method functionality:</i><br>
     * Setting Rest API Request Body<br>
     * Body is used in POST/PUT/PATCH methods
     *
     * @param requestBody String
     */

    public void setBody(String requestBody) {
        body = requestBody;
    }

    /**
     * <b>[Test Method]</b> - Getting API Request Body<br>
     * <br><i>Test Method functionality:</i><br>
     * Getting Rest API Request Body
     */

    public String getBody() {
        return body;
    }

    /**
     * <b>[Test Method]</b> - Setting Request Method type<br>
     * <br><i>Test Method functionality:</i><br>
     * Setting Rest API Request Method type<br>
     *
     * @param requestType RestApiMethodTypes
     */

    public void setMethod(RestApiMethodTypes requestType) {
        method = requestType;
    }

    /**
     * <b>[Test Method]</b> - Getting API Method type<br>
     * <br><i>Test Method functionality:</i><br>
     * Getting Rest API Method type
     */

    public RestApiMethodTypes getMethod() {
        return method;
    }

}
