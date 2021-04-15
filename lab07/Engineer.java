package lab07;

public class Engineer extends Employee{
	private String workZone, project;
	
	public Engineer(String name, int employeeNum, String workZone, String project) {
		super(name, employeeNum, "Engineering");
		this.workZone = workZone;
		this.project = project;
	}
	public boolean equals(Object obj ) {
		if (obj == null)
			return false;
		else if(getClass() != obj.getClass())
			return false;
		else {
			Engineer e1 = (Engineer) obj;
			return super.equals(e1) && workZone.equals(e1.workZone) && project.equals(e1.project);
		}
	}
	public String toString() {
		return super.toString() + "\nZone : " + this.workZone;
	}
}
