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

/**
 * FXML Controller class
 *
 * @author bruce
 */
public class BarrierFXMLController implements Initializable {

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleSubmit(ActionEvent event) {  //will only be successful if vehicle has permit, otherwise red and error message
        String reg = txtInputReg.getText();
        /*
        String reg2 = Vehicle_list.getReg();
        
        if(reg.equals(reg2)){
            lblControl.setText("GO");
            shpControl.setFill(javafx.scene.paint.Color.GREEN);
        }else{
            lblControl.setText("STOP");
            shpControl.setFill(javafx.scene.paint.Color.RED);
        }
        */
        
        lblControl.setText("GO");
        shpControl.setFill(javafx.scene.paint.Color.GREEN);
    }

    @FXML
    private void handleClear(ActionEvent event) {
        txtInputReg.setText("");
        lblControl.setText("STOP");
        shpControl.setFill(javafx.scene.paint.Color.RED);
    }
    
}
