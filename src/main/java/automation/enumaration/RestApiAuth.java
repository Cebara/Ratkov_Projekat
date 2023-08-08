package automation.enumaration;

/**
 * <b>Enumeration : RestAPI</b> RestAPI Authorization
 */

public enum RestApiAuth {

    /**
     * Using RestAPI Authorization as Enum list<br>
     * Authorization is used in request's header
     */

    HEADER("Header-Parameter"),
    BASIC("Basic-Auth");

    public final String option;


    RestApiAuth(String option) {
        this.option = option;
    }

}
