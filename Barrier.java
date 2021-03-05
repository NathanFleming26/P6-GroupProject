/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author bruce
 */
public class Barrier extends Application{ //implements java.util.Observer{
 
    private int barrierNo, date;
    private boolean active = false; 
    //This attribute indicates the active/inactive state of the barrier system - as notified by the system status when it changes (Barrier Observes System status)
    
    //static BarrierFXMLController myController;
    
    //private System_status lnkSystem_status
    //Each instance of Barrier has a navigable association to the system status so that it can check whether the barrier system as a whole is active or inactive, and so that it can send event messages to be recorded in the log.
    
    //private Vehicle_list lnkVehicle_list
    //Each instance of Barrier has a navigable association to the permit list so that when a vehicle's registration number has been recognized by the camera, the barrier can check whether to raise itself or not by checking the status of that vehicle's permit.
    
    //private boolean raised = true
    //If the barrier system is active, this attribute indicates whether the barrier is currently it its raised or lowered position. The position is controlled by the result of checking a registration number with the permitted vehicles list, and the "vehicle clear" button.

        @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("BarrierFXML.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("DATE No, Barrier No");
        stage.setScene(scene);
        stage.show();
        
    
    }
    
    public static void main(String args[]){
        launch(args);
        
    }   
}
