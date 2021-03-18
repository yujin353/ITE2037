package lab03;

public class Employee {
	private String name, position;
	private int age, salary, vacationDays;
	
	public Employee(String name, int age) {
		this.name = name;
		this.age = age;
		
		position = "Employee";
		salary = 5000;
		vacationDays = 20;
	}
	public Employee(String name, int age, String position, int salary) {
		this.name = name;
		this.age = age;
		this.position = position;
		this.salary = salary;

		vacationDays = 20;
	}
	public Employee(String name, int age, String position, int salary, int vacationDays) {
		this.name = name;
		this.age = age;
		this.position = position;
		this.salary = salary;
		this.vacationDays = vacationDays;
	}
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getPosition() { return position; }
	public void setPosition(String position) { this.position = position; }
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }
	public int getSalary() { return salary; }
	public void setSalary(int salary) { this.salary = salary; }
	public int getVacationDays() { return vacationDays; }
	public void setVacationDays(int vacationDays) { this.vacationDays = vacationDays; }
	
	public boolean eqauls(Employee e1) {
		if (this.name.equals(e1.name) && this.age == e1.age && this.position == e1.position) {
			return true;
		}
		else
			return false;
	}
	public String toString() {
		return "Name: " + name + ", Age: " + age + ", Position: " + position + ", Salary: " + salary + ", VacationDays: " + vacationDays;
	}
	public void vacation(int day) {
		if (day > this.vacationDays) {
			System.out.println("남은 휴가 일수가 부족합니다.");
		}
		else {
			this.vacationDays -= day;
			System.out.printf("휴가를 사용하였습니다. 남은 휴가 일수: %d\n", this.vacationDays);
		}
	}

}
