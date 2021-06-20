package assignment3;

public class InvalidAccessException extends Exception {
	public InvalidAccessException() {
		super("Enter positive number!");
	}

	public InvalidAccessException(int n1, int n2) {
		super("Enter number " + n1 + "~" + n2 + "!");
	}
}
