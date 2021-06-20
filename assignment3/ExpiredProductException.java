package assignment3;

import java.time.LocalDateTime;

public class ExpiredProductException extends Exception {
	public ExpiredProductException() {
		super();
	}

	public ExpiredProductException(String s) {
		super(s);
	}

	public ExpiredProductException(LocalDateTime t) {
		super("ExpirationDate is " + t);
	}
}
