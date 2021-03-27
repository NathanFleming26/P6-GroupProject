/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author bruce
 */
public class BarrierFXMLController implements Initializable {   //extends Observable{

    @FXML
    private Label lblEnterReg;
    @FXML
    private TextField txtInputReg;
    @FXML
    private Button btnSubmit;
    @FXML
    private Button btnClear;
    @FXML
    private Label lblBarrier;
    @FXML
    private Circle shpControl;
    @FXML
    private Label lblControl;

    private Barrier barrier;
    //private System_status Status;

    //This attribute indicates the active/inactive state of the barrier system - as notified by the system status when it changes (barrier observers system status)
    private boolean active = true;  //should be false       
    //Each instance of barrier has a navigable association to the system status so it can check whether the barreir system as a whole is active or inactive, and so that it can send event messages to be recorded in the log
    System_status lnkSystem_status;
    //Each instance of Barrier has a navigable association to the permit list so that when a vehicles registration number has been recognized by the camera, the barrier can check whether to raise itself or not by checking the status of that vehicles permit
    Vehicle_list lnkVehicle_list;
    //If the barrier system is active, this attributer indicates whether the barrier is currently in its raised or lowered position. The position is controlled by the results of checking a registration number with the permitted vehicle list, and the vehicle clear button
    boolean raised = true;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lnkVehicle_list = new Vehicle_list();
        lnkSystem_status = new System_status();
        active = lnkSystem_status.getSystemStatus();
    }

    @FXML
    /**
     * Method to handle submit button on barrier UI
     *
     * @param event Button event
     * @return void
     */
    private void handleSubmit(ActionEvent event) {
        boolean valid = false;
        active = lnkSystem_status.getSystemStatus();            //Gets activity status of the system
        String reg = txtInputReg.getText();                     //Get reg from input text box
        valid = lnkVehicle_list.checkVehicle(reg);              //Gets if the vehicle has a permit

        //lnkVehicle_list.setWarning("BB58 UCE");   //To test if warning was set  
        //lnkVehicle_list.details();                //just to view all vehicles in the hash table
        if (valid == true && active == true) {      //System active, vehicle has permit
            //Raise barrier and display message
            lblControl.setText("GO");
            shpControl.setFill(javafx.scene.paint.Color.GREEN);
            JOptionPane.showMessageDialog(null, "Permit found, barrier is raised");
            raised = true;

            //record enterence on system status
            lnkSystem_status.addToLog(raised);          //This is incorrect? Supposed to be done through the Vehicle_list class?
        } else if (active == false) {                   //System not active
            //No movement to barrier, display message
            txtInputReg.setText("");
            lblControl.setText("STOP");
            shpControl.setFill(javafx.scene.paint.Color.RED);
            JOptionPane.showMessageDialog(null, "System is currently down, please try again later");
            raised = false;
        } else {                                        //If car doesnt have a permit
            //No movement to barrier, display message
            txtInputReg.setText("");
            lblControl.setText("STOP");
            shpControl.setFill(javafx.scene.paint.Color.RED);
            JOptionPane.showMessageDialog(null, "No permit found, please try again");
            raised = false;
        }

    }

    @FXML
    /**
     * Method to handle clear button on barrier UI Set to clear once the vehicle
     * has cleared the barrier
     *
     * @param event Button event
     * @return void
     */
    private void handleClear(ActionEvent event) {
        //Lowers the barrier and display message
        raised = false;
        txtInputReg.setText("");
        lblControl.setText("STOP");
        lblBarrier.setText("Barrier is down");
        shpControl.setFill(javafx.scene.paint.Color.RED);
    }

}
