package automation.restAssuredAPI;

import automation.constants.RestApiUrls;
import automation.enumaration.RestApiNames;
import automation.utilities.ExtentManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import org.testng.annotations.BeforeTest;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;

/**
 * <b>RESTASSUREAPI</b> [Rest Assure API]: Common Actions for Rest Assure API
 */

public class CommonTest {

    public static RequestSpecification spec;
    public static String url;
    private static RestApiNames restApi;
    private static Object headerValue;
    private static String headerParameter;

    /**
     * <b>[Test Method]</b> - Set Up for RestApi if it is used in UI cases<br>
     * <br><i>Test Method functionality:</i><br>
     * This method helps to construct set up method to avoid spec comes as null<br>
     *
     * @return spec RequestSpecification
     */
    public static RequestSpecification getSpec() {
        if (Objects.isNull(spec)) {
            return new RequestSpecBuilder()
                    .setBaseUri(url)
                    .addFilters(Arrays.asList(new RequestLoggingFilter(), new ResponseLoggingFilter()))
                    .build();
        }
        return spec;
    }

    /**
     * <b>[Method]</b> Prepare Authorized Header<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality generates a header map which contains<br>
     * Content-Type and Authorization token
     *
     * @return headerMap map
     */

    public static Map<String, Object> getAuthorizedHeader() {
        Map<String, Object> headerMap = new HashMap<>();
        headerMap.put("Content-Type", "application/json");
        headerMap.put(headerParameter, headerValue);
        return headerMap;
    }

    /**
     * <b>[Method]</b> Post request without header<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality sends post request without header and
     * with given body and url<br>
     *
     * @param body String
     * @param url  String
     * @return post request response as Response object
     */
    public static Response postWithoutHeader(String body, String url) {
        return given()
                .contentType(ContentType.JSON)
                .when()
                .body(body)
                .post(url);
    }

    /**
     * <b>[Method]</b> Post request with header<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality sends post request with authorized header and
     * with given body and url<br>
     *
     * @param body String
     * @param url  String
     * @return post request response as Response object
     */
    public static Response post(String body, String url) {
        RequestSpecification requestSpecification = given(getSpec())
                .headers(getAuthorizedHeader())
                .when()
                .body(body);
        Response response = requestSpecification.post(url);
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;
    }

    /**
     * <b>[Method]</b> Put request<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality sends put request with authorized header and
     * with given body and url<br>
     *
     * @param body String
     * @param url  String
     * @return put request response as Response object
     */
    public static Response put(String body, String url) throws UnsupportedEncodingException {
        RequestSpecification requestSpecification = given(getSpec())
                .headers(getAuthorizedHeader())
                .when()
                .body(body);
        Response response = requestSpecification.put(url);
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;
    }

    /**
     * <b>[Method]</b> Patch request<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality sends patch request with authorized header and
     * with given body and url<br>
     *
     * @param body String
     * @param url  String
     * @return patch request response as Response object
     */
    public static Response patch(String body, String url) {
        RequestSpecification requestSpecification = given(getSpec())
                .headers(getAuthorizedHeader())
                .when()
                .body(body);
        Response response = requestSpecification.patch(url);
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;
    }

    /**
     * <b>[Method]</b> Delete request<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality sends put request with authorized header and
     * with given body and url<br>
     *
     * @param url String
     * @return delete request response as Response object
     */
    public static Response delete(String url) throws UnsupportedEncodingException {
        RequestSpecification requestSpecification = given(getSpec())
                .headers(getAuthorizedHeader());
        Response response = requestSpecification.delete(url);
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;
    }

    /**
     * <b>[Method]</b> Get request<br>
     * <br>
     * <i>Method functionality:</i><br>
     * This functionality sends put request with authorized header and
     * with given body and url<br>
     *
     * @param url String
     * @return get request response as Response object
     */
    public static Response get(String url) throws UnsupportedEncodingException {
        RequestSpecification requestSpecification = given(getSpec())
                .headers(getAuthorizedHeader());
        Response response = requestSpecification.get(url);
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;
    }

    /**
     * <b>[Method]</b> Print Request log in report<br>
     * <br>
     * <i>Method functionality:</i><br>
     * Prints request Base Uri, Base Path, Method, Headers and request body of request to report
     *
     * @param requestSpecification requestSpecification
     */

    private static void printRequestLogInReport(RequestSpecification requestSpecification) {
        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
        ExtentManager.logInfoDetails("Endpoint is: " + queryableRequestSpecification.getBaseUri());
        ExtentManager.logInfoDetails("Base Path is: " + queryableRequestSpecification.getDerivedPath());
        ExtentManager.logInfoDetails("Method is: " + queryableRequestSpecification.getMethod());
        ExtentManager.logInfoDetails("Headers are: ");
        ExtentManager.logHeaders(queryableRequestSpecification.getHeaders().asList());
        if (queryableRequestSpecification.getMethod().equals("POST") || queryableRequestSpecification.getMethod().equals("PUT") || queryableRequestSpecification.getMethod().equals("PATCH")) {
            ExtentManager.logInfoDetails("Request Body is: ");
            ExtentManager.logJSON(queryableRequestSpecification.getBody());
        }
    }

    /**
     * <b>[Method]</b> Print Response log in report<br>
     * <br>
     * <i>Method functionality:</i><br>
     * Prints response status code, headers and body to report
     *
     * @param response Response
     */
    private static void printResponseLogInReport(Response response) {
        ExtentManager.logPassDetails("Response status is " + response.getStatusCode());
        ExtentManager.logInfoDetails("Response headers are: ");
        ExtentManager.logHeaders(response.getHeaders().asList());
        if (!(response.getContentType()).isBlank()) {
            String jsonBody = response.getBody().asPrettyString();
            jsonBody = jsonBody.replaceAll("\n", "<br>");
            String formattedBody = "<details>\n" +
                    " <summary style=\"color:rgb(33,150,243);\"><b> Click here to see Json Body Response </b></summary>\n" +
                    " " + jsonBody + "\n" +
                    "</details>\n";
            ExtentManager.logInfoDetailsWithoutLabelColor(formattedBody);
        }

    }

    public static RestApiNames getRestApiName() {
        return restApi;
    }

    /**
     * <b>[Test Method]</b> - Setting Rest API Name<br>
     * <br><i>Test Method functionality:</i><br>
     * Setting Rest API Name initialized BeforeSuite inside executing testing Class
     */

    public static void setRestApiName(RestApiNames rest) {
        restApi = rest;
    }

    /**
     * <b>[Test Method]</b> - Setting Header Value<br>
     * <br><i>Test Method functionality:</i><br>
     * Setting Rest API Header Value
     * initialized either during BeforeSuite
     * or as pre-required test case step
     * inside executing testing Class
     */

    public static void setHeaderValue(Object ob) {
        headerValue = ob;
    }

    /**
     * <b>[Test Method]</b> - Setting Header Value<br>
     * <br><i>Test Method functionality:</i><br>
     * Setting Rest API Header Parameter
     * initialized either during BeforeSuite
     * or as pre-required test case step
     * inside executing testing Class
     */

    public static void setHeaderParameter(String par) {
        headerParameter = par;
    }

    /**
     * <b>[Test Method]</b> - Set Up for RestApi<br>
     * <br><i>Test Method functionality:</i><br>
     * The RequestSpecBuilder is a special class of RestAssured
     * which allows us to prepare base url and
     * add logging for request e and response of api calls and more, so we can use the same
     * logic for all requests in order to not repeat them again and again<br>
     * BeforeTest - annotation
     */
    @BeforeTest
    public void setup() {
        switch (getRestApiName()) {
            case PROVSPOTAPI -> {
                url = RestApiUrls.restUrl;
            }
            case SVSPOTAPI -> {
                url = RestApiUrls.svSpotRestUrl;
            }
            default -> {
                url = "";
            }
        }
        spec = new RequestSpecBuilder()
                .setBaseUri(url)
                .addFilters(Arrays.asList(new RequestLoggingFilter(), new ResponseLoggingFilter()))
                .build();
    }

}
