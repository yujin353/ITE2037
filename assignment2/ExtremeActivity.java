package assignment2;

public class ExtremeActivity extends Activity {
	private int minHeight;
	private int minWeight;

	public ExtremeActivity(String name, String location, int price, int minHeight, int minWeight) {
		super(name, location, price);
		this.minHeight = minHeight;
		this.minWeight = minWeight;
	}

	public int getActualPrice(Person person) {
		if (person.getAge() >= 60)
			return (int) (getPrice() * 1.3);
		else
			return getPrice();
	}

	public int getMinHeight() {
		return this.minHeight;
	}

	public int getMinWeight() {
		return this.minWeight;
	}
}
