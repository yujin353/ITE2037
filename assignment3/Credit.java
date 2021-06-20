package assignment3;

public class Credit implements Payable {
	private String bank; // 은행
	private int limit; // 사용 한도
	private int amountUsed;// 현재 누적 사용 금액

	public void pay(int price) {
		if (limit - amountUsed >= price)
			this.amountUsed += price;
	}

	public Credit(String bank, int limit, int amountUsed) {
		this.bank = bank;
		this.limit = limit;
		this.amountUsed = amountUsed;
	}

	public String toString() {
		return bank + ", Amount used: " + amountUsed + " won (Limit: " + limit + " won)";
	}

	public String getBank() {
		return this.bank;
	}

	public int getAmountUsed() {
		return this.amountUsed;
	}

	public int getLimit() {
		return this.limit;
	}
}
