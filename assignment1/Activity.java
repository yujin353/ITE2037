package assignment1;

public class Activity {
	private String name, location;
	private int price;
	
	public Activity() {}
	public Activity(String name, String location, int price) {
		this.name = name;
		this.location = location;
		this.price = price;
	}
	
	public String toString() {
		return name + "(" + location + ", " + price +" won)";
	}
	
	public int getPrice() { return this.price; }
	public String getName() { return this.name; }
}
