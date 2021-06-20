package assignment3;

import java.util.ArrayList;

public class Customer implements Observer {
	private String name; // 이름
	private ArrayList<Payable> wallet; // 소지한 Payable 목록
	private ArrayList<Product> shoppingCart; // 구매할 Product 목록

	public Customer(String name, ArrayList<Payable> wallet, ArrayList<Product> shoppingCart) {
		this.name = name;
		this.wallet = wallet;
		this.shoppingCart = shoppingCart;
	}

	public Customer(String name, ArrayList<Payable> wallet) {
		this.name = name;
		this.wallet = wallet;
		this.shoppingCart = new ArrayList<Product>();
	}

	public void update(InventoryManager generator) {
		// for(Product p : generator)
	}

	public String getName() {
		return this.name;
	}

	public void setShoppingCart(Product p) {
		if (p == null)
			this.shoppingCart.clear();
		else
			this.shoppingCart.add(p);
	}

	public ArrayList<Payable> getWallet() {
		return this.wallet;
	}

	public ArrayList<Product> getShoppingCart() {
		return this.shoppingCart;
	}
}
