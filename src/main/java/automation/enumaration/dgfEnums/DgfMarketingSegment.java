package automation.enumaration.dgfEnums;

/**
 * <b>Enumeration : [DGF Enums]</b> DGF Marketing Segment
 */

public enum DgfMarketingSegment {

    /**
     * Using DeutscheGlasfaser Marketing Segment as Enum list<br>
     */

    DGB("DGB"),
    DGH("DGH"),
    DG_PROFESSIONAL("DG_Professional");

    public final String option;

    DgfMarketingSegment(String option) {
        this.option = option;
    }

}
