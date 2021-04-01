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
	//Instance Variables
	private Hashtable<String, Vehicle_info> lnkVehicle;
	private Permit_list P;

	//Empty Constructor
	public Vehicle_list() {
		//Initialise hashtable
		lnkVehicle = new Hashtable<String, Vehicle_info>();

	}
	public boolean addVehicle(String reg, String make, String model, String colour, String name) {//Adds a vehicle to the hashtable
		if (lnkVehicle.containsKey(reg)) { //if vehicle with reg already exists, return false
			return false;
		} else {
			Vehicle_info v = new Vehicle_info(reg, make, model, colour, name);//Initialise a new Vehicle and add to hastable
			lnkVehicle.put(v.getReg(), v);
			return true;
		}

	}
	public Vehicle_info getVehicle(String reg) {//retunrs the vehicle from the hashtable usinf the reg as the key
		Vehicle_info v;
		if (lnkVehicle.containsKey(reg)) { 
			v = (Vehicle_info) lnkVehicle.get(reg);
			return v;
		}else {
			return v=null;
		}
	}

	public boolean setWarning(String reg) {//Adds a warning to the vehicle with the entered reg
		Vehicle_info v;
		boolean warning = false;
		if (lnkVehicle.containsKey(reg)) { 
			v = lnkVehicle.get(reg);
			if (v.getWarning()<3){
				v.setWarning();
				warning = true;
			}
			if(v.getWarning()==3) {
				v.setSuspended(true);
			}
		}
		return warning;
	}
	public int getWarning(String reg) {//Returns the number of warnings a vehicle has
		Vehicle_info v;
		if (lnkVehicle.containsKey(reg)) { 
			v = lnkVehicle.get(reg);
			return v.getWarning();
			//v.setWarning();
		}
		return 0;

	}
	public boolean getSuspended(String reg) {
		Vehicle_info v;
		if (lnkVehicle.containsKey(reg)) { 
			v = lnkVehicle.get(reg);
			if (v.getSuspended()==true) {
				return true;
			}
		}
		return false;
	}
	public boolean deleteWarning(String reg) {//Reduces the value of warnings for the vehicle by 1
		Vehicle_info v;
		boolean warning=false;
		if (lnkVehicle.containsKey(reg)) { 
			v = (Vehicle_info) lnkVehicle.get(reg);
			if (v.getWarning()==0) {
			}else if (v.getWarning()<3){
				v.deleteWarning();
				warning= true;
			}else
			{
				v.deleteWarning();
				warning= true;
			}
			if (v.getWarning()<3){
				v.setSuspended(false);
			}
		}
		return warning;
	}

	public boolean vehicleExists(String reg)//Returns true if the vehicle is already in the hashtable
	{
		if (lnkVehicle.containsKey(reg))
		{
			return true;
		}else
		{
			return false;
		}
	}
}
