package testcases.menuone;

import automation.enumaration.RestApiNames;
import automation.endpoints.CommonTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

@Listeners(automation.listeners.ExtentApiListener.class)
public class TestCaseNameApi {

    /**
     * <b>[Test Method]</b> - Set Up for RestApi<br>
     * <br><i>Test Method functionality:</i><br>
     * Purpose of the method is to initialize API name used for testing
     * Next step will be setup action in CommonTest class under RestAPI package
     * which allows us to prepare base url and<br>
     * BeforeSuite - annotation
     */

    @BeforeSuite
    public void setupApiName() {
        RestApiNames restApi = RestApiNames.CAMPAIGN;
        CommonTest.setRestApiName(restApi);
    }

    /**
     * <b>[Test Method]</b> - Set Up parameters for RestApi Header<br>
     * <br><i>Test Method functionality:</i><br>
     * Purpose of the method is to initialize API header parameter name and value
     * which will be used during testing every time when HTTP method is called
     * under getAuthorizedHeader method from CommonTest class<br>
     * BeforeTest - annotation
     */

    @BeforeTest
    public void setHeaderParameter() {
        //CommonTest.setHeaderParameter("billing-user");
        //CommonTest.setHeaderValue("rzekic");

        CommonTest.setHeaderParameter("Authorization");
        CommonTest.setHeaderValue("Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJDSFJJU0NPTExJTlNVU0EiLCJlbWFpbFZlcmlmaWVkIjp0cnVlLCJpc0NvbW1lcmNpYWxDdXN0b21lciI6ZmFsc2UsInJvbGUiOiJBRE1JTiIsImhpZGVCaWxsaW5nSW5mbyI6ZmFsc2UsImN1c3RvbWVySWQiOiJBQzAwOTM0MjA4IiwiaGFzRGV2aWNlIjp0cnVlLCJleHAiOjE2OTA0NjI3MjAsImFjY291bnROdW1iZXIiOiJBQzAwOTM0MjA4IiwianRpIjoiY2NmYzU4YjUtNzFkMy00YjRmLWJhNDYtNGQ3OGE4MjFhN2JkIiwidXNlcm5hbWUiOiJDSFJJU0NPTExJTlNVU0EiLCJ0b2tlbiI6IkJlYXJlciBudWxsIn0.L3imiF3kqgzxSGo16CuBPa7SU4FzlMNT0q_xS_I-izTI7j0VI2EqDV6dXObhUVzw6bZwtjY4ZFCajd2XSgabqg");
    }
}
