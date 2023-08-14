package automation.enumaration;

/**
 * <b>Enumeration : Database</b> Database Names
 */

public enum DatabaseNames {

    /**
     * Using Database Names as Enum list<br>
     * String option represent type of Database
     */

    AC("MySQL"),
    PLM("MySQL"),
    PORTFOLIO("MySQL"),
    PRODUCT("MySQL");

    public final String option;


    DatabaseNames(String option) {
        this.option = option;
    }

}
