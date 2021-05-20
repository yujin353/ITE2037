package lab11;

public class Employee {
	private String name, department;
	private int employeeNum;
	private double salary;

	public Employee(String name, int employeeNum, String department, double salary) {
		this.name = name;
		this.employeeNum = employeeNum;
		this.department = department;
		this.salary = salary;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmployeeNum() {
		return this.employeeNum;
	}

	public void setEmployeeNume(int employeeNum) {
		this.employeeNum = employeeNum;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return this.salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String toString() {
		return "Name: " + this.name + "\nEmployee Number: " + this.employeeNum + "\nDepartment: " + this.department
				+ "\nSalary: " + this.salary;
	}
}
