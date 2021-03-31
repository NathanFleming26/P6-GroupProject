import java.util.Hashtable;

/* Generated by Together */

/**
 * Vehicle list manages the collection of vehicles currently associated with permits.
 * It handles checks of whether vehicles are allowed through the barriers, records warnings,
 * and various other functions. Note that each Vehicle_info object must have a unique registration
 * number, to allow sensible checking and recording of entries onto the campus (so a HashTable
 * is probably a good implementation of the collection, with registration number as key).
 *
 * There will only be one instance of this class.
 */
public class Vehicle_list {
    /** The Vehicle list maintains a collection of the known Vehicle_infos associated with all permits.
     * This association must be implemented by an attribute holding a collection data structure
     * (for example: array, hash table - the latter is recommended).
     *
     * Note that no two Vehicle_infos may have the same registration number (this information is
     * not represented diagrammatically) - this is to guarantee consistency with the constraint
     * that no vehicle is associated with more than one permit.
     *
     * Note that, given a registration number, the Vehicle_list can look up the appropriate Vehicle_info
     * instance, and via that it can obtain the vehicle's permit information.
     * @associates Vehicle_info
     * @label Contains
     * @clientCardinality 1
     * @supplierCardinality 0..*
     * @directed*/
    private Hashtable<String, Vehicle_info> lnkVehicle;
    private Permit_list P;
    
    public Vehicle_list() {
//        //Initialise and populate hashtable
    	lnkVehicle = new Hashtable<String, Vehicle_info>();
//
        Vehicle_info v1 = new Vehicle_info("BB58 UCE", "make1", "model1", "colour1", "Bruce");     //need to add other attributes too
        lnkVehicle.put("BB58 UCE", v1);
//
//        Vehicle_info v2 = new Vehicle_info("SW65 NTJ", "make2", "model2", "colour2", 2);
//        lnkVehicle.put(v2.getReg(), v2);
//
//        Vehicle_info v3 = new Vehicle_info("AB23 SKG", "make3", "model3", "colour3", 3);
//        lnkVehicle.put(v3.getReg(), v3);
//        
//        Vehicle_info v4 = new Vehicle_info("DI24 SKG", "make4", "model4", "colour4", 4);
//        lnkVehicle.put(v4.getReg(), v4);

    }
    public boolean addVehicle(String reg, String make, String model, String colour, String name) {
      if (lnkVehicle.containsKey(reg)) { 
    	  return false;
      } else {
      	Vehicle_info v = new Vehicle_info(reg, make, model, colour, name);
      	lnkVehicle.put(v.getReg(), v);
      	return true;
      }

    }
    public Vehicle_info getVehicle(String reg) {
    	Vehicle_info v;
        if (lnkVehicle.containsKey(reg)) { 
        	v = (Vehicle_info) lnkVehicle.get(reg);
        	return v;
        }else {
        	return v=null;
        }
    }
    public boolean setWarning(String reg) {
    	Vehicle_info v;
        if (lnkVehicle.containsKey(reg)) { 
        	v = lnkVehicle.get(reg);
        	v.setWarning();
        	return true;
        }else {
        	return false;
        }
        }
        public int getWarning(String reg) {
        	Vehicle_info v;
            if (lnkVehicle.containsKey(reg)) { 
            	v = lnkVehicle.get(reg);
            	return v.getWarning();
            	//v.setWarning();
            }
            return 0;
            	
    }
    public boolean deleteWarning(String reg) {
    	Vehicle_info v;
        if (lnkVehicle.containsKey(reg)) { 
        	v = (Vehicle_info) lnkVehicle.get(reg);
        	v.deleteWarning();
        	return true;
        }else {
        	return false;
        }
    }
    
    
//    public void addVehicle(String regNo) {          //Add vehicle to has table, need some way to return if vehicle was successfully added
//        if (lnkVehicles.containsKey(regNo)) {       //This hashtable already contains a vehicle with this reg, should add return error message
//        } else {
//            Vehicle_info v = new Vehicle_info("regNo");
//            lnkVehicles.put(regNo, v);              //Add vehicle to has table
//        }
//    }
}
