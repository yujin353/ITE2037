package assignment3;

public class Manufactured extends Product {
	public String brand; // ������

	public Manufactured(String name, int price, int quantity, String brand) {
		super(name, price, quantity);
		this.brand = brand;
	}
}
