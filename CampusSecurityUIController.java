/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campussecurityui;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.color;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Cameron Savoury: cas00235
 */
public class CampusSecurityUIController implements Initializable 
{   
    private Boolean barrierRaised;
    
    //<editor-fold defaultstate="collapsed" desc="Declare Elements">
    @FXML
    private Label lbl_barrierStatus;
    @FXML
    private Label lbl_warningMessage;
    
    @FXML
    private TextField txt_vehicleReg;
    
    @FXML
    private TableView<String> tbl_barrierLog = new TableView<>();
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Barrier Control Methods">
    @FXML
    private boolean raiseBarrier (ActionEvent e)
    {
        System.out.println("Barrier Raised");
        lbl_barrierStatus.setTextFill(Color.GREEN);
        lbl_barrierStatus.setText("RAISED");
        barrierRaised = true;
        System.out.println("\nBarrier Raised - " + barrierRaised.toString());
        return barrierRaised;
    }//raiseBarrier
    
    @FXML
    private boolean lowerBarrier (ActionEvent e)
    {
        System.out.println("Barrier Lowered");
        lbl_barrierStatus.setTextFill(Color.RED);
        lbl_barrierStatus.setText("LOWERED");
        barrierRaised = false;
        System.out.println("\nRaised - " + barrierRaised.toString());
        return barrierLowered;
    }//lowerBarrier
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Issue Warning">
    @FXML
    private String issueWarning()
    {
        //get registration from textField
        String vehicleReg = txt_vehicleReg.getText();
        
        System.out.println("\nVehicle Reg is: " + vehicleReg);
        
        lbl_warningMessage.setTextFill(Color.GREEN);
        lbl_warningMessage.setTextAlignment(TextAlignment.CENTER);
        lbl_warningMessage.setText("WARNING ISSUED");
        
        return vehicleReg;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Log Change">
    @FXML
    private void logChange()
    {
        String curTime;
        String curDate;
        
        //Retrieve System Date and Time
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");
        LocalDateTime now = LocalDateTime.now();
        
        //Assign to Variables
        curDate = dateFormat.format(now);
        curTime = timeFormat.format(now);
        
        ObservableList<String> list = FXCollections.observableArrayList();
        tbl_barrierLog.setItems(list);
        list.add(curTime);
        list.add(curDate);
    }
//</editor-fold>
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        //Set All Labels to their default values
        lbl_barrierStatus.setTextFill(Color.BLACK);
        lbl_barrierStatus.setText(""); 
        
        lbl_warningMessage.setTextFill(Color.BLACK);
        lbl_warningMessage.setText("");
    }//Initialize 
    
}//End of Class
