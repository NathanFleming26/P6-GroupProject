package application;

//This class will ensure text entered by the user is suitable to be stored in the system
public class RawDataSanitation {

	public boolean isValidName(String name) {

		return (name.matches("[A-Z][a-z]{1,20}"));

	}

	public boolean isValidRegistration(String reg) {

		return (reg.matches("(^[A-Z]{2}[0-9]{2} [A-Z]{3}$)|(^[A-Z][0-9]{1,3} [A-Z]{3}$)|(^[A-Z]{3} [0-9]{1,3}[A-Z]$)|(^[0-9]{1,4} [A-Z]{1,2}$)|(^[0-9]{1,3} [A-Z]{1,3}$)|(^[A-Z]{1,2} [0-9]{1,4}$)|(^[A-Z]{1,3} [0-9]{1,3}$)"));

	}

}
