/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;


/**
 *
 * @author bruce
 */
public class Vehicle_info {
    private String regNo;
    private Permit lnkPermit;
    private boolean warning;

    public Vehicle_info(String regNo){
        lnkPermit = new Permit();
        this.regNo = regNo;
        this.warning = false;
    }
    
     /**
     * @return True or False if vehicle has a permit
     */
    public boolean getPermit(){   //Will need to add calls to permit class to access permit methods
        /*
        if inkPermit.hasPermit(regNo){
            return true;
        }else{
            return false;
        }
*/
        return true;
    }
     /**
     * @return vehicle registration
     */
    public String getReg(){     //returns reg
        return regNo;
    }
    
     /**
     * Set warning to this vehicle
     */
    public void setWarning(){
        this.warning =  true;
    }
     /**
     * @return vehicle warning status
     */
        public boolean getWarning(){
            return warning;
    }

    
}
