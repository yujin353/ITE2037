package assignment3;

public class NotEnoughBalanceException extends Exception {
	public NotEnoughBalanceException() {
		super();
	}

	public NotEnoughBalanceException(int n) {
		super(n + " won is not enough");
	}
}
