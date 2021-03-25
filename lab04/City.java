package lab04;

import java.util.Random;

public class City {
	private String name;
	private int locationX, locationY;
	
	public City (String name, int locationX, int locationY) {
		this.name = name;
		this.locationX = locationX;
		this.locationY = locationY;
	}
	public City (String name) {
		Random rnd = new Random();
		this.name = name;
		this.locationX = rnd.nextInt(360);
		this.locationY = rnd.nextInt(360);
	}
	
	public String getName() { return name; }
	public int getLocationX() { return locationX; }
	public int getLocationY() { return locationY; }
	
	public boolean eqauls(City c1) {
		if(this.name == c1.name && this.locationX == c1.locationX && this.locationY == c1.locationY)
			return true;
		else
			return false;
	}
	
	public String toString() {
		return  name + ", " + locationX + ", " + locationY;
	}
	
	public static double getDistance(City c1, City c2) {
		return Math.sqrt(Math.pow(c1.locationX - c2.locationX, 2) + Math.pow(c1.locationY - c2.locationY, 2));
	}
}