package javaapplication37;


import java.util.Hashtable;
import javaapplication37.Date;
import javaapplication37.Vehicle_info;

/* Generated by Together */

/**
 * For a description of Day visitors, follow hyperlink to the Administration use case for
 * issuing a new Day visitor permit.
 */
public class Day_visitor_permit extends Permit 
{
    /**
     * The name of the University member hosting the visit.
     */
    private String hostName;

    /**
     * The date that the visitor is visiting on - entry will be allowed on that date only.
     * @clientCardinality 1
     * @supplierCardinality 1
     * @label Visiting on
     * @link aggregation
     * @directed
     */
    private int lnkDate;
    
    public Day_visitor_permit(int UID, int permitType, String permitHolderName, String regNo, int noOfEntries, int warnings, boolean suspended, boolean enteredToday, Vehicle_info v1, Hashtable permittedVehicles, int lnkDate, String hostName)
    {
        super(UID, permitType, permitHolderName, regNo, noOfEntries, warnings, suspended, enteredToday, v1, permittedVehicles);
        this.lnkDate = lnkDate;
        this.hostName = hostName;
    }
}
