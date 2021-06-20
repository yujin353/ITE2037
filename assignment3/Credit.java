package assignment3;

public class Credit implements Payable {
	private String bank; // ����
	private int limit; // ��� �ѵ�
	private int amountUsed;// ���� ���� ��� �ݾ�

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
