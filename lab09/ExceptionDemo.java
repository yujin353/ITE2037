package lab09;

import java.util.Scanner;

public class ExceptionDemo {

	public static void main(String[] args) {
		Employee e1 = new Employee("Lee");
		Scanner scan = new Scanner(System.in);

		for (;;) {
			try {
				System.out.print(e1.getWorkDay() + "일차 근무 시간을 입력하세요 : ");
				int hours = scan.nextInt();

				if (hours < 0)
					throw new NegativeException();
				else if (hours == 0)
					throw new Exception("Program Exit");
				else if (hours > 24)
					throw new TooMuchStuffException(hours);
				else {
					e1.addWorkHours(hours);
					e1.addWorkDay();
					System.out.println("이름 : " + e1.getName());
					System.out.println("누적 근무 시간 : " + e1.getWorkHours());
					System.out.println("No Exception has been occurred");
				}
			} catch (NegativeException e) {
				System.out.println(e.getMessage());
			} catch (TooMuchStuffException e) {
				System.out.println(e.getInputNum() + ", " + e.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.exit(0);
			} finally {
				System.out.println("End of try-catch statement");
			}
		}

	}

}
