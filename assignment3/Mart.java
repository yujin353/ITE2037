package assignment3;

import java.util.ArrayList;

public class Mart extends InventoryManager {
	private ArrayList<Product> salesList; // �Ǹ� ���
	public static int transactionNum = 1000; // ��Ʈ�� transaction ��ȣ

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
