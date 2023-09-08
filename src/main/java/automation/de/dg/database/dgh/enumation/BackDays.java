package automation.de.dg.database.dgh.enumation;

/**
 * <b>De.Dg/Database/Enumation : Change days Enums/b> Change days Enums
 */

public enum BackDays {

    FUTURE_MORE_TWO_YEARS(800),
    FUTURE_TWO_YEARS(730),
    FUTURE_EIGHTHEEN_MONTHS(540),
    FUTURE_ONE_YEAR(365),
    FUTURE_SIX_MONTHS(180),
    PAST_SIX_MONTHS(-180),
    PAST_EIGHTHEEN_MONTHS(-540),
    PAST_TWO_YEARS(-730),
    PAST_MORE_TWO_YEARS(-800);


    public final int option;

    BackDays(int option) {
        this.option = option;
    }

}
