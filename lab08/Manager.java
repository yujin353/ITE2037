package lab08;

public class Manager extends Employee{
	private double overtimeRate, rate;
	private int regularHrs;
	
	public Manager(String name, int employeeNum) {
		super(name, employeeNum);
		this.rate = 4.0;
		this.overtimeRate = 8.0;
		this.regularHrs = 40;
		setDepartment("Management");
	}
	
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		else if (getClass() != obj.getClass())
			return false;
		else {
			Manager m1 = (Manager)obj;
			return super.equals(m1);
		}
	}
	
	public String toString() {
		return super.toString() + ", " + getDepartment();
	}
	
	public double getPaid() {
		int overtimeHrs = getWorkHrs() - regularHrs;
		if (getWorkHrs() < 40)
			return getWorkHrs() * rate;
		else
			return (regularHrs * rate) + (overtimeHrs * overtimeRate);
	}
}
