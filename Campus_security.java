import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * The Campus security staff actually activate and deactivate the barriers, enter warnings for
 * vehicles breaching the parking regulations and monitor the state of the barrier system.
 * This class represents the interactive interface to these functions.  Information about these
 * functions is in the Campus security use case diagram (hyperlinked from this class).
 * The interface comprises one screen with the various functions present on it, all on view at
 * once since there aren't many.
 * There could be several instances of this class: one in the central security office, and one
 * at each entrance to the University (in a staffed booth).
 * The class implements Observer, and observes the system status so that it can keep the displayed
 * information up to date (current date, barriers active or not, log of entries through the barriers).
 * @stereotype boundary
 */
public class Campus_security extends JFrame implements Observer, ActionListener {
	/**
	 * Each instance of Campus_security has a navigable association to the vehicle list so that
	 * warnings can be recorded on the permit for vehicles that breach parking regulations.
	 * Note that this process goes via the vehicle list as the only information available about such a
	 * vehicle is its registration number.
	 * @clientCardinality 1..*
	 * @supplierCardinality 1
	 * @label Record warning
	 * @directed
	 */
	//Instance Variables
	private Vehicle_list lnkVehicle_list;
	private boolean active = false;
	private int date=1;

	/**
	 * Each instance of Campus_security has a navigable association to the system status so that it
	 * can both find out status information about the system, and send controlling messages to the
	 * system status (to activate/deactivate the system).
	 * @clientCardinality 1..*
	 * @supplierCardinality 1
	 * @label Control/monitor
	 * @directed*/
	private System_status lnkSystem_status;

	private JButton activate, deactivate, warning, log;
	private JLabel lblReg;
	private JTextField txtReg;
	private JTextArea txtInfo;

	//Create the UI for Campus_security
	public Campus_security(System_status s, Vehicle_list v) {
		lnkSystem_status = s;
		lnkVehicle_list = v;


		setTitle("Campus Security	" + date );
		setLocation(40,200);
		setSize(600,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());   

		activate = new JButton("Activate Barrier Systems");
		activate.addActionListener(this);
		window.add(activate);
		deactivate = new JButton("Deactivate Barrier Systems");
		deactivate.addActionListener(this);
		window.add(deactivate);
		lblReg = new JLabel("Enter Registration Number:");
		window.add(lblReg);
		txtReg = new JTextField("", 15);
		window.add(txtReg);
		warning = new JButton("Issue Warning");
		warning.addActionListener(this);
		window.add(warning);
		log = new JButton("Check Log");
		log.addActionListener(this);
		window.add(log);
		txtInfo = new JTextArea("Todays Date: " + date, 20, 50);
		window.add(txtInfo, BorderLayout.CENTER);

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

	@Override
	public void update(Observable o, Object arg) {
		active = lnkSystem_status.getSystemStatus();
		date = lnkSystem_status.getDate();
		setTitle("Barrier  " + date);
		txtInfo.setText("");
		txtInfo.setText("Todays Date: " + date);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==activate) { //Activate system
			lnkSystem_status.setSystemStaus(true);
			// Popup Message
			showMessageDialog(null, "The system has been activated", "System Status", JOptionPane.INFORMATION_MESSAGE);

		}else if (e.getSource()==deactivate) { //Deactivate system
			lnkSystem_status.setSystemStaus(false);
			// Popup Message
			showMessageDialog(null, "The system has been deactivated", "System Status", JOptionPane.INFORMATION_MESSAGE);

		}else if (e.getSource()==warning) { //Add warning
			String reg = txtReg.getText();
			if (reg.equals("")) { //if text field is empty
				showMessageDialog(null, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
			}else {
				if (lnkVehicle_list.vehicleExists(reg)) {//If vehicle exists
					if (lnkVehicle_list.setWarning(reg)) {//If adding a warning is possible (may be suspended)
						showMessageDialog(null, "Vehicle has been issued a warning", "Warning", JOptionPane.INFORMATION_MESSAGE);

					}else {	//vehicle is suspended
						showMessageDialog(null, "Vehicle is already suspended", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}else {
					showMessageDialog(null, "Vehicle does not exist in system", "Barrier Status", JOptionPane.ERROR_MESSAGE);
				}
			}
			clearFields();

		}else if (e.getSource()==log) {			//Show log
			txtInfo.setText(lnkSystem_status.getLog());

		}

	}
}
