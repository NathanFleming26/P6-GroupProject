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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

/*
 * @author Cameron Savoury: cas00235
 */
public class CampusSecurityUIController implements Initializable 
{   
    //<editor-fold defaultstate="collapsed" desc="Class Instance Variables">

    //Class Instance Variables
    private Boolean barrierRaised;
    
    RawDataSanitation RDS = new RawDataSanitation();
    
    Alert a;
    
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Declare Elements">
    
    //<editor-fold defaultstate="collapsed" desc="Pane 1 Elements">
    //Pane 1 Elements
        @FXML
        private Button P1btn_raiseBarrier;

        @FXML
        private Button P1btn_lowerBarrier;

        @FXML
        private Label P1lbl_barrierStatus;
        
        @FXML
        private Label P1lbl_dynamicBarrierStatus;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Pane 2 Elements">
        //Pane 2 Elements
        @FXML
        private Button P2btn_issueWarning;
        
        @FXML
        private Label P2lbl_enterReg;
        
        @FXML
        private TextField P2txt_vehicleReg;
        //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Pane 3 Elements">
        //Pane 3 Elements
        @FXML
        private Label P3lbl_barrierLog;
        
        @FXML
        private TableView<String> P3tbl_barrierLog = new TableView<>();
        //</editor-fold>
    
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Barrier Control Methods">
    @FXML
    private boolean raiseBarrier (ActionEvent e)
    {
        System.out.println("Barrier Raised");
        P1lbl_dynamicBarrierStatus.setTextFill(Color.GREEN);
        P1lbl_dynamicBarrierStatus.setText("RAISED");
        barrierRaised = true;
        System.out.println("\nRaised - " + barrierRaised.toString());
        return barrierRaised;
    }//raiseBarrier
    
    @FXML
    private boolean lowerBarrier (ActionEvent e)
    {
        System.out.println("Barrier Lowered");
        P1lbl_dynamicBarrierStatus.setTextFill(Color.RED);
        P1lbl_dynamicBarrierStatus.setText("LOWERED");
        barrierRaised = false;
        System.out.println("\nRaised - " + barrierRaised.toString());
        return barrierRaised;
    }//lowerBarrier
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Issue Warning">
    @FXML
    private String issueWarning()
    {
        //get registration from textField
        String vehicleReg = P2txt_vehicleReg.getText();

        if (!RDS.isValidRegistration(vehicleReg)) 
        {
            // Pop error
            a.setAlertType(AlertType.ERROR);
            a.setHeaderText("Invalid UK Car Registration");
            a.setTitle("Error with car registration field");
            a.setContentText("Please enter a vaild UK car registration!");
            a.show();
            
            P2txt_vehicleReg.clear();
            return null;
        }
        else
        {
            a.setAlertType(AlertType.INFORMATION);
            a.setHeaderText("Warning Confirmed");
            a.setTitle("Warning Confirmation");
            a.setContentText("Warning Issued for: " + vehicleReg);
            a.show(); 
            P2txt_vehicleReg.clear();
        return vehicleReg;
        }
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Log Change">
    @FXML
    private void logChange()
    {
        //TODO - Add code from system status class
    }
//</editor-fold>
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        a = new Alert(AlertType.NONE);
        
        //Set All Labels to their default values
        P1lbl_dynamicBarrierStatus.setTextFill(Color.BLACK);
        P1lbl_dynamicBarrierStatus.setText("");
    }//Initialize 
    
}//End of Class
