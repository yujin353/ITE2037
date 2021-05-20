package assignment2;

public class ArrayFullException extends Exception {
	public ArrayFullException() {
		super("Array full!");
	}

	public ArrayFullException(String message) {
		super(message);
	}
}
