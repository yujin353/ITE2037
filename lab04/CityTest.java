package lab04;

public class CityTest {

	public static void main(String[] args) {
		City c1 = new City("Seoul", 23, 45);
		City c2 = new City("Paris", 123, 41);
		City c3 = new City("Racoon City");
		City c4 = new City("Mega City");
		
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		System.out.println(c3.toString());
		System.out.println(c4.toString());

		System.out.println(c1.getName() + "-" + c2.getName() + " : " + City.getDistance(c1, c2));
		System.out.println(c1.getName() + "-" + c3.getName() + " : " + City.getDistance(c1, c3));
		System.out.println(c2.getName() + "-" + c4.getName() + " : " + City.getDistance(c2, c4));
	}

}
