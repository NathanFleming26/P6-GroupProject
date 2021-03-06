package application;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainPageController implements Initializable{

	
	RawDataSanitation RDS = new RawDataSanitation();
	
	Alert a;
	
	
	// First Pane Vars
	
	@FXML
	private RadioButton rd1;
	@FXML
	private TextField paneOneMemberName;
	@FXML
	private TextField paneOneVisitorName;
	@FXML
	private TextField paneOneCarRegistration;
	@FXML
	private DatePicker paneOneStartDate;
	@FXML
	private DatePicker paneOneEndDate = new DatePicker();
	@FXML
	private Button paneOneSubmitbtn;	
	
	// Second Pane Vars
	@FXML
	private TextField paneTwoVisitorName;
	@FXML
	private TextField paneTwoCarRegistration;
	@FXML
	private DatePicker paneTwoIssueDate;
	@FXML
	private Button paneTwoSubmitbtn;
	
	// Third Pane Vars
	@FXML
	private TextField paneThreeMemberName;
	@FXML
	private TextField paneThreeCarRegistration;
	@FXML
	private DatePicker paneThreeIssueDate;
	@FXML
	private Button paneThreeAddBtn;
	@FXML
	private Button paneThreeSubmitbtn;
	@FXML
	private TextArea paneThreeTextArea;
	
	private ArrayList<String> memberCars = new ArrayList<String>();;
	
	// Fourth Pane Vars
	@FXML
	private TextField paneFourWarningReg;
	@FXML
	private Button paneFourWarningSubmitbtn;
	
	@FXML
	private TextField paneFourRemoveWarningReg;
	@FXML
	private ComboBox paneFourNumberOfWarnings;
	@FXML
	private Button paneFourRemoveWarningSubmitbtn;
	
	@FXML
	private TextField paneFourCencelName;
	@FXML
	private Button paneFourCancelSubmitbtn;
	
	@FXML
	private TextField paneFourAddVehicleName;
	@FXML
	private TextField paneFourAddVehicleReg;
	@FXML
	private Button paneFourAddVehicleSubmitbtn;
	
	@FXML
	private TextField paneFourRemoveVehicleName;
	@FXML
	private TextField paneFourRemoveVehicleReg;
	@FXML
	private Button paneFourRemoveVehicleSubmitbtn;
	
	@FXML
	private Button paneFourStatisEnquiry;
	
	
	
	/*
	 * 
	 * 	Pane One Methods
	 * 
	 */
	
	public void armRadioButton(Event e) {
			
		enableDateField();
	}
	
	
	private void enableDateField() {
		
		if (rd1.isSelected()) {
			paneOneEndDate.setDisable(false);
		}
		else {
			paneOneEndDate.setDisable(true);
		}
		
	}
	
	
	public void addVisitor(Event e) {
		
		String memberName = paneOneMemberName.getText();
		
		if (!RDS.isValidName(memberName)) {
			
			// Pop error
			a.setAlertType(AlertType.ERROR);
			a.setHeaderText("Invalid Name");
			a.setTitle("Error with Member Name field");
			a.setContentText("Please enter a vaild name!");
			a.show();
			return;
		}
		
		String visitorName = paneOneVisitorName.getText();
		
		if (!RDS.isValidName(visitorName)) {
			
			// Pop error
			a.setAlertType(AlertType.ERROR);
			a.setHeaderText("Invalid Name");
			a.setTitle("Error with Visitor Name field");
			a.setContentText("Please enter a vaild name!");
			a.show();
			return;
			
		}
		
		String carReg = paneOneCarRegistration.getText();
		
		if (!RDS.isValidRegistration(carReg)) {
			
			// Pop error
			a.setAlertType(AlertType.ERROR);
			a.setHeaderText("Invalid UK Car Registration");
			a.setTitle("Error with car registration field");
			a.setContentText("Please enter a vaild UK car registration!");
			a.show();
			return;
		}
		
		LocalDate startDate = paneOneStartDate.getValue();
		
		if (rd1.isSelected()) {
			LocalDate endDate = paneOneEndDate.getValue();
		}
		
		// Method call to Administration_Office()
		
		
	/*
	 * 
	 *  Pane Two Methods
	 * 
	 */
		
	}
	
	public void addPermenatVisitor() {
		
		String visitorName = paneTwoVisitorName.getText();
		
		if (!RDS.isValidName(visitorName)) {
			
			// Pop error
			a.setAlertType(AlertType.ERROR);
			a.setHeaderText("Invalid Name");
			a.setTitle("Error with Visitor Name field");
			a.setContentText("Please enter a vaild name!");
			a.show();
			return;
			
		}
		
		String carReg = paneTwoCarRegistration.getText();
		
		if (!RDS.isValidRegistration(carReg)) {
			
			// Pop error
			a.setAlertType(AlertType.ERROR);
			a.setHeaderText("Invalid UK Car Registration");
			a.setTitle("Error with car registration field");
			a.setContentText("Please enter a vaild UK car registration!");
			a.show();
			return;
		}
		
		LocalDate issueDate = paneTwoIssueDate.getValue();
		
		// Method call to Administration_Office()
		
	}
	
	/*
	 * 
	 *  Pane Three Methods
	 * 
	 */
	
	public void addMember() {
		
		String memberName = paneThreeMemberName.getText();
		
		if (!RDS.isValidName(memberName)) {
			
			// Pop error
			a.setAlertType(AlertType.ERROR);
			a.setHeaderText("Invalid Name");
			a.setTitle("Error with Member Name field");
			a.setContentText("Please enter a vaild name!");
			a.show();
			return;
			
		}
		
		LocalDate issueDate = paneThreeIssueDate.getValue();
		
		// Method call to Administraion_Office() Remember to pass memberCars
		
		
	}
	
	public void addCars() {
		
		String carReg = paneThreeCarRegistration.getText();
		
		if (!RDS.isValidRegistration(carReg)) {
			
			// Pop error
			a.setAlertType(AlertType.ERROR);
			a.setHeaderText("Invalid UK Car Registration");
			a.setTitle("Error with car registration field");
			a.setContentText("Please enter a vaild UK car registration!");
			a.show();
			return;
			
		}
		
		memberCars.add(carReg);

		paneThreeTextArea.clear();
		
		for (String c: memberCars) {
		
			paneThreeTextArea.appendText(c + "\n");
	
		}
	
		//System.out.println(memberCars);
		
	}
	
	
	/*
	 * 
	 *  Pane Four Methods
	 * 
	 */
	
	
	public void addWarning() {
		
		String warningReg = paneFourWarningReg.getText();
		
		if (!RDS.isValidRegistration(warningReg)) {
			
			// Pop error
			a.setAlertType(AlertType.ERROR);
			a.setHeaderText("Invalid UK Car Registration");
			a.setTitle("Error with car registrtion field");
			a.setContentText("Please enter a vaild UK car registration!");
			a.show();
			return;
		}
		
		// Method call to Administration_Office()
		
	}
	
	
	public void removeWarning() {
		
		String removeWarningReg = paneFourRemoveWarningReg.getText();
		
		if (!RDS.isValidRegistration(removeWarningReg)) {
			
			// Pop error
			a.setAlertType(AlertType.ERROR);
			a.setHeaderText("Invalid UK Car Registration");
			a.setTitle("Error with car registration field");
			a.setContentText("Please enter a vaild UK car registration!");
			a.show();
			return;
			
		}
		
		int numberOfWarnings = (int) paneFourNumberOfWarnings.getValue();
		
		// Method call to Administration_Office()
		
	}
	
	public void cancelPermit() {
		
		String permitHolderName = paneFourCencelName.getText();
		
		if (!RDS.isValidName(permitHolderName)) {
			
			// Pop error
			a.setAlertType(AlertType.ERROR);
			a.setHeaderText("Invalid Name");
			a.setTitle("Error with Member Name field");
			a.setContentText("Please enter a vaild name!");
			a.show();
			return;
		}
		
		// Method call to Administration_Office()
		
	}

	public void addVehicleToPermit() {
		
		String permitHolderName = paneFourAddVehicleName.getText();
		
		if (!RDS.isValidName(permitHolderName)) {
			
			// Pop error
			a.setAlertType(AlertType.ERROR);
			a.setHeaderText("Invalid Name");
			a.setTitle("Error with Member Name field");
			a.setContentText("Please enter a vaild name!");
			a.show();
			return;
			
		}
		
		String carReg = paneFourAddVehicleReg.getText();
		
		if (!RDS.isValidRegistration(carReg)) {
			
			// Pop error
			a.setAlertType(AlertType.ERROR);
			a.setHeaderText("Invalid UK Car Registration");
			a.setTitle("Error with car registration field");
			a.setContentText("Please enter a vaild car registration!");
			a.show();
			return;
		}
		
		// Method call to Administration_Office()
		
	}
	
	public void removeVehicleFromPermit() {
		
		String permitHolderName = paneFourRemoveVehicleName.getText();
		
		if (!RDS.isValidName(permitHolderName)) {
			
			// Pop error
			a.setAlertType(AlertType.ERROR);
			a.setHeaderText("Invalid Name");
			a.setTitle("Error with Member Name field");
			a.setContentText("Please enter a vaild name!");
			a.show();
			return;
			
		}
		
		String carReg = paneFourRemoveVehicleReg.getText();
		
		if (!RDS.isValidRegistration(carReg)) {
			
			// Pop error
			a.setAlertType(AlertType.ERROR);
			a.setHeaderText("Invalid UK Car Registration");
			a.setTitle("Error with car registration field");
			a.setContentText("Please enter a vaild car registration!");
			a.show();
			return;
		}
		
		// Method call to Administration_Office()
		
	}
	
	public void statisEnquiry() {
		
		// Method call to Administration_Office()
		
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		a = new Alert(AlertType.NONE);
		
		
	}
	
	
	
	
	
	
			
}
