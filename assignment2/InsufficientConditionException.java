package assignment2;

public class InsufficientConditionException extends Exception {
	public InsufficientConditionException() {
		super("Insufficiend condition!");
	}

	public InsufficientConditionException(String message) {
		super(message + " insufficient condition");
	}
}
