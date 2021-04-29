package lab08;

public abstract class Employee {
	private String name, department;
	private int employeeNum, workHrs;
	private double salary;
	
	public Employee(String name, int employeeNum) {
		this.name = name;
		this.employeeNum = employeeNum;
		this.workHrs = 0;
		this.salary = 0.0;
	}
	
	public String getDepartment() { return this.department; }
	public void setDepartment(String department) { this.department = department; }
	public int getWorkHrs() { return this.workHrs; }
	public double getSalary() { return this.salary; }
	
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		else if (getClass() != obj.getClass())
			return false;
		else {
			Employee e1 = (Employee)obj;
			return this.name.equals(e1.name) && this.employeeNum == e1.employeeNum;
		}
	}
	
	public String toString() {
		return this.name + ", " + this.employeeNum;
	}
	
	public abstract double getPaid();
	
	public void doWork(int hrs) {
		this.workHrs += hrs;
		salary = getPaid();
	}
}
