package assignment2;

public class InvalidAccessException extends Exception {
	public InvalidAccessException() {
		super("Invalid access!");
	}

	public InvalidAccessException(String message) {
		super("InvalidAccess" + message);
	}
}
