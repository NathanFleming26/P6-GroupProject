package javaapplication37;


import java.util.Hashtable;
import javaapplication37.Date;
import javaapplication37.Vehicle_info;

/* Generated by Together */

/**
 * For a description of Permanent visitors, follow hyperlink to the Administration use case
 * for issuing a new Permanent visitor permit.
 */
public class Permanent_visitor_permit extends Permit 
{
    private int lnkDate;
    
    public Permanent_visitor_permit(int UID, int permitType, String permitHolderName, String regNo, int noOfEntries, int warnings, boolean suspended, boolean enteredToday, Vehicle_info v1, Hashtable permittedVehicles, int lnkDate)
    {
        super(UID, permitType, permitHolderName, regNo, noOfEntries, warnings, suspended, enteredToday, v1, permittedVehicles);
        this.lnkDate = lnkDate;
    }
}


