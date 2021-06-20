package assignment3;

import java.util.ArrayList;

public class Mart extends InventoryManager {
	private ArrayList<Product> salesList; // 판매 목록
	public static int transactionNum = 1000; // 마트의 transaction 번호

	public Mart(ArrayList<Product> salesList) {
		this.salesList = salesList;
	}

	public int salesListSize() {
		return salesList.size();
	}

	public Product getProduct(int i) {
		return salesList.get(i);
	}
}
