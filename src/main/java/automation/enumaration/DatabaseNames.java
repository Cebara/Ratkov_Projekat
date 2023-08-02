package automation.enumaration;

/**
 * <b>Enumation : Database</b> Database Names
 */

public enum DatabaseNames {

    /**
     * Using Database Names as Enum list
     */

    DB("Database"),
    SPOT("Spot");

    public final String option;


    DatabaseNames(String option) {
        this.option = option;
    }

}
