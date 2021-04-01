import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;


/**
 * This class represents the access control barriers.
 * Information about the barrier functions is in the Barrier use case diagram (hyperlinked from this class).
 * Although in reality this class will be realised by (programmable) hardware with a moveable
 * barrier, and a camera with a registration number recognition system, here the interface comprises
 * one screen with the various functions present on it, all on view at once since there aren't many.
 *
 * There will be a large word PASS or STOP on display at all times:
 * PASS when the barrier is up because the system is inactive or temporarily when a permitted vehicle
 * is being allowed through,
 * and STOP when the barrier is down.
 *
 * There will be a text field to enter the registration number read by the camera, and a button to
 * indicate that the number has been read and is ready for checking (and raising the barrier or not,
 * as appropriate).
 *
 * To simulate the passage of a vehicle through the raised barrier, there is another button to be clicked
 * to simulate when a buried electronic sensor indicates that the vehicle is now clear - the barrier can
 * then be lowered (unless, of course, the system has been deactivated by security staff in the interim...).
 *
 * There could be many instances of this class: one at each entrance lane to the University.
 * The class implements Observer, and observes the system status so that it can keep its activated/deactivated
 * status up to date.
 * @stereotype boundary
 */
public class Barrier extends JFrame implements Observer, ActionListener {
	/**
	 * Each instance of Barrier has a navigable association to the permit list so that when a vehicle's
	 * registration number has been recognized by the camera, the barrier can check whether to raise itself
	 * or not by checking the status of that vehicle's permit.
	 * @clientCardinality 1..*
	 * @supplierCardinality 1
	 * @label Access permits
	 * @directed*/
	private Vehicle_list lnkVehicle_list;

	/**
	 * Each instance of Barrier has a navigable association to the system status so that it can check
	 * whether the barrier system as a whole is active or inactive, and so that it can send event messages
	 * to be recorded in the log.
	 * @clientCardinality 1..*
	 * @supplierCardinality 1
	 * @label Fetch system status info
	 * @directed*/
	private System_status lnkSystem_status;

	/**
	 * This attribute indicates the active/inactive state of the barrier system - as notified by the
	 * system status when it changes (Barrier Observes System status). If false then the barrier must be up.
	 * If true then the barrier position is determined by attribute raised.
	 */
	//Instance Variables
	private boolean active = false;    
	private int date=1;
	//Alert a; //Used for displaying messages to the user

	/**
	 * If the barrier system is active, this attribute indicates whether the barrier is currently in
	 * its raised or lowered position. The position is controlled by the result of checking a registration number
	 * with the permitted vehicles list, and the "vehicle clear" button.
	 */
	private boolean raised = false;
	private JButton submit, clear;
	private JLabel lblReg, lblStatus1, lblStatus2;
	private JTextField txtReg;

	//Create the UI for Barrier
	public Barrier(System_status s, Vehicle_list v) {
		lnkSystem_status = s;
		lnkVehicle_list = v;

		setTitle("Barrier  " + date);
		setLocation(40,200);
		setSize(350,150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());   

		lblReg = new JLabel("Enter Registration Number:");
		window.add(lblReg);
		txtReg = new JTextField("", 15);
		window.add(txtReg);
		submit = new JButton("Submit");
		submit.addActionListener(this);
		window.add(submit);
		clear = new JButton("Vehicle Clear");
		clear.addActionListener(this);
		window.add(clear);
		lblStatus1 = new JLabel("The barrier is lowered");
		window.add(lblStatus1);
		lblStatus2 = new JLabel("STOP");
		lblStatus2.setForeground(Color.red);
		window.add(lblStatus2);

		lnkSystem_status.addObserver(this);

		setVisible(true);
		//Set all fields blank
		clearFields();
	}
	//This method will revert an text fields back to being blank
	public void clearFields()
	{
		txtReg.setText("");
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==submit) {//Check permit

			if (active==true) {
				String reg = txtReg.getText();//Get reg from input text box
				if(reg.equals("")) //If the field is empty
				{
					// Popup Message
					showMessageDialog(null, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					if (lnkVehicle_list.vehicleExists(reg)) {
						Vehicle_info v = lnkVehicle_list.getVehicle(reg);
						if (v.hasPermit()&&v.getSuspended()==false) {//If the vehicle has a permit and is not suspended

							raised = true;
							// Popup Message
							v.addAccess();
							showMessageDialog(null, "The barrier has been raised", "Barrier Status", JOptionPane.INFORMATION_MESSAGE);
							lblStatus2.setText("GO");
							lblStatus2.setForeground(Color.green);
						}else {//Do not raise the barrier
							raised = false;
							// Popup Message
							showMessageDialog(null, "The barrier cannot be raised, vehicle doesnt have permit or is suspended", "Barrier Status", JOptionPane.INFORMATION_MESSAGE);
						}
					}else {
						showMessageDialog(null, "Vehicle does not exist in system", "Barrier Status", JOptionPane.ERROR_MESSAGE);
					}
				}

			}else {
				showMessageDialog(null, "System is currently inactive", "Error", JOptionPane.ERROR_MESSAGE);
			}

			lnkSystem_status.addToLog(raised);

			//Clear all fields
			clearFields();	

		}else if (e.getSource()==clear) 
		{
			if (raised==true) {
				raised = false;
				showMessageDialog(null, "Vehicle has cleared barrier, barrier lowered", "Barrier Status", JOptionPane.INFORMATION_MESSAGE);
				lblStatus2.setText("STOP");
				lblStatus2.setForeground(Color.red);
				//Clear all fields
				clearFields();
			}else {
				showMessageDialog(null, "No vehicles, barrier is already lowered", "Barrier Status", JOptionPane.INFORMATION_MESSAGE);
			}

		}
	} // actionPerformed


	@Override
	public void update(Observable o, Object arg) {
		active = lnkSystem_status.getSystemStatus();
		date = lnkSystem_status.getDate();
		setTitle("Barrier  " + date);
	}
}
