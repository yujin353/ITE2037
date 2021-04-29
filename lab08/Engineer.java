package lab08;

public class Engineer extends Employee {
	private double rate;
	
	public Engineer(String name, int employeeNum) {
		super(name, employeeNum);
		this.rate = 4.0;
		setDepartment("Engineering");
	}
	
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		else if (getClass() != obj.getClass())
			return false;
		else {
			Engineer e1 = (Engineer)obj;
			return super.equals(e1);
		}
	}
	
	public String toString() {
		return super.toString() + ", " + getDepartment();
	}
	
	public double getPaid() {
		return getWorkHrs() * rate;
	}
}
