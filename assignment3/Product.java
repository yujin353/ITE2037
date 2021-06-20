package assignment3;

public class Product {
	private String name; // ��ǰ��
	private int price; // ��ǰ�� ����
	private int quantity; // ��ǰ�� ����

	public Product(String name, int price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getName() {
		return this.name;
	}

	public int getPrice() {
		return this.price;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void IncreaseQuantity(int n) {
		this.quantity += n;
	}

	public void DecreaseQuantity(int n) {
		this.quantity -= n;
	}
}
