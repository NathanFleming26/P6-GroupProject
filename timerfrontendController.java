/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package timer;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *  @FXML
    private Label label;
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
 */

public class timerfrontendController implements Initializable {
    
    int dayNumber;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   

    @FXML
    private Label label2;
    @FXML    
    private void BE (ActionEvent e)
    {
        
   if(dayNumber<365)
   {
       dayNumber++;
       label2.setText("dayNumber");
   }
   else
   {
       dayNumber=1;
       label2.setText("dayNumber");
   }
    
    }

}
