package lab03;

public class EmployeeManager {

	public static void main(String[] args) {
		Employee e1 = new Employee("James Wright", 42, "Manager", 20000);
		Employee e2 = new Employee("Amy Smith", 27, "Design Coordinator", 8000, 15);
		Employee e3 = new Employee("Peter Coolidge", 32, "Assistant Manager", 12000, 7);
		Employee e4 = new Employee("John Doe", 22, "Engineer", 10000, 10);
		
		System.out.println(e1.toString());
		System.out.println(e2.toString());
		System.out.println(e3.toString());
		System.out.println(e4.toString());
		
		Employee e5 = new Employee("Yujin Kim", 27);
		
		if (e5.eqauls(e2)) {
			System.out.println("같은 직원입니다.");
		}
		else {
			System.out.println("다른 직원입니다.");
		}
		
		e1.vacation(10);
		e3.vacation(10);
		
		System.out.println(e1.toString());
		System.out.println(e2.toString());
		System.out.println(e3.toString());
		System.out.println(e4.toString());
		System.out.println(e5.toString());
	}

}
