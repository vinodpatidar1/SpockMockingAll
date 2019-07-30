package jmockit;

/**
 * @author mumtazbanur
 */
public class NameValidator {

	static final int MAX_LENGTH;
	final String DEFAULT_NAME;
	
	static {
		MAX_LENGTH = setMaxLength();
	}
	
	private NameValidator() {
		this.DEFAULT_NAME="default";
	}

	public String getDefaultName() {
		return DEFAULT_NAME;
	}
	
	public static Boolean isNameValid(String name) {
		return name.matches("^[a-zA-Z]+$");
	}

	private static int setMaxLength() {
		return 10;
	}
	
	public int getMaxLength() {
		return MAX_LENGTH;
	}
	
	public final Boolean isValidint(String number) {
		return number.matches("^[0-9]+$");
	}
	
	public String checkForValidNumber(String number) {
		if(isValidint(number)) {
			return "0";
		}
		return number;
	}
}