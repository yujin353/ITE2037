package assignment2;

public class Person {
	private String name;
	private int age, height, weight;

	public Person(String name, int age, int height, int weight) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}

	public Person(Person p) {
		this.name = p.name;
		this.age = p.age;
		this.height = p.height;
		this.weight = p.weight;
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}

	public int getHeight() {
		return this.height;
	}

	public int getWeight() {
		return this.weight;
	}
}
