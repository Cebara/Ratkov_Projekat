package automation.enumaration;

/**
 * <b>Enumation : RestAPI</b> RestAPI Names
 */

public enum RestApiNames {

    /**
     * Using Database Names as Enum list
     */

    PROVSPOTAPI("prov-spot-api"),
    SVSPOTAPI("sv-spot-api");

    public final String option;


    RestApiNames(String option) {
        this.option = option;
    }
}
