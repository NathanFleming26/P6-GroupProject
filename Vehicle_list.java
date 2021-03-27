/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.*;
import java.util.Iterator;

/**
 *
 * @author bruce
 */
public class Vehicle_list {

    Hashtable lnkVehicles;      //Hashtable containing a collection of vehicles

    /**
     * Vehicle list constructor
     */
    public Vehicle_list() {
        //Initialise and populate hashtable
        lnkVehicles = new Hashtable();

        Vehicle_info v1 = new Vehicle_info("BB58 UCE");     //need to add other attributes too
        lnkVehicles.put(v1.getReg(), v1);

        Vehicle_info v2 = new Vehicle_info("SW65 NTJ");
        lnkVehicles.put(v2.getReg(), v2);

        Vehicle_info v3 = new Vehicle_info("AB23 SKG");
        lnkVehicles.put(v3.getReg(), v3);

    }

    /**
     * Method to add another vehicle to hash table with given details
     *
     * @param regNo (more details) - Details of vehicle to be added
     */
    public void addVehicle(String regNo) {          //Add vehicle to has table, need some way to return if vehicle was successfully added
        if (lnkVehicles.containsKey(regNo)) {       //This hashtable already contains a vehicle with this reg, should add return error message
        } else {
            Vehicle_info v = new Vehicle_info("regNo");
            lnkVehicles.put(regNo, v);              //Add vehicle to has table
        }
    }

    /**
     * Method to add another vehicle to hash table with given details
     *
     * @param regNo, (more details) - Details of vehicle to be added
     * @return Boolean - If vehicle has permit
     */
    public boolean checkVehicle(String regNo) {
        if (lnkVehicles.containsKey(regNo)) {
            System.out.println("Were here");
            Vehicle_info v = (Vehicle_info) lnkVehicles.get(regNo);
            return v.getPermit();
        } else {
            return false;
        }

    }

    /**
     * Method to set warning to vehicle with a given reg
     *
     * @param regNo - reg of vehicle to be warned
     */
    public void setWarning(String regNo) {
        if (lnkVehicles.containsKey(regNo)) {
            Vehicle_info v = (Vehicle_info) lnkVehicles.get(regNo);
            v.setWarning();
        }
    }

    /**
     * Test method to view all vehicles in the hashtable 
     * Iterates through hashtable and prints details
     */
    public void details() {
        Set<String> cars = lnkVehicles.keySet();
        Iterator<String> iterator = cars.iterator();

        while (iterator.hasNext()) {
            String key = iterator.next();
            Vehicle_info v = (Vehicle_info) lnkVehicles.get(key);
            System.out.println("Reg : " + v.getReg() + " Warning : " + v.getWarning());
        }
    }
}
