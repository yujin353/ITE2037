package assignment2;

public class Activity {
	private String name, location;
	private int price;

	public Activity() {
	}

	public Activity(String name, String location, int price) {
		this.name = name;
		this.location = location;
		this.price = price;
	}

	public String toString() {
		return name + "(" + location + ", " + price + " won)";
	}

	public int getPrice() {
		return this.price;
	}

	public String getName() {
		return this.name;
	}

	public int getActualPrice(Person person) {
		return price;
	}

	public boolean eqauls(Object obj) {
		if (obj == null)
			return false;
		else if (getClass() != obj.getClass())
			return false;
		else {
			Activity a = (Activity) obj;
			return name.equals(a.name) && location.equals(a.location) && price == a.price;
		}
	}
}
