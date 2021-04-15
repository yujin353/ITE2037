package lab07;

public class Employee {
	private String name;
	private int employeeNum;
	private String department;
	
	public Employee(String name, int employeeNum, String department) {
		this.name = name;
		this.employeeNum = employeeNum;
		this.department = department;
	}
	public Employee() {}
	
	public String getName() {return this.name; }
	public void setName(String name) { this.name = name; }
	public int getEmployeeNum() {return this.employeeNum; }
	public void setEmployeeNum(int employeeNum) {this.employeeNum = employeeNum; }
	public String getDepartment() {return this.department; }
	public void setDepartment(String department) { this.department = department; }
	
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		else if (getClass() != obj.getClass())
			return false;
		else {
			Employee e1 = (Employee)obj;
			return name.equals(e1.name) && employeeNum == e1.employeeNum && department.equals(e1.department);
		}
	}
	
	public String toString() {
		return "Name : " + this.name + "\nEmp# : " + this.employeeNum + "\nDepartment : " + this.department;
	}
}
