package assignment3;

public class Cash implements Payable {
	private String currency;
	private int amount;

	public void pay(int amount) {
		if (this.amount >= amount)
			this.amount -= amount;
	}

	public Cash(String currency, int amount) {
		this.currency = currency;
		this.amount = amount;
	}

	public String toString() {
		return currency + ", " + amount + "won";
	}

	public int getAmount() {
		return this.amount;
	}
}
