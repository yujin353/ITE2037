package lab07;

public class Manager extends Employee{
	private int officeNum;
	private String team;
	
	public Manager(String name, int employeeNum, int officeNum, String team) {
		super(name, employeeNum, "Management");
		this.officeNum = officeNum;
		this.team = team;
	}
	public Manager() {}
	public String toString() {
		return super.toString() + "\nOffice# : " + this.officeNum + "\nTeam : " + this.team;
	}
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		else if(getClass() != obj.getClass())
			return false;
		else {
			Manager m1 = (Manager)obj;
			return super.equals(m1) && this.officeNum == m1.officeNum && team.equals(m1.team);
		}
	}
}
