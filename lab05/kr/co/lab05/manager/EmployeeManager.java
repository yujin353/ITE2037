package kr.co.lab05.manager;
import java.time.LocalDate;
import kr.co.lab05.employee.*;
import java.util.Random;

public class EmployeeManager {

	public static void main(String[] args) {
		Employee e1 = new Employee("Kim", 4500);
		
		LocalDate contractDate = LocalDate.of(2021, 4, 1);
		System.out.print("계약일: " + contractDate + "\n");
		
		LocalDate d1 = LocalDate.of(2021, 4, 1);
		System.out.print(e1.toString()+"\n");
		
		Random rnd = new Random();//방법까먹음주의
		int incentive = rnd.nextInt(11) + 1;
		
		int m = 0, y = 1;
		while(e1.getBalance() < 20000) {
			m++;	d1 = d1.plusMonths(1);//한달 지남
			e1.receiveSalary();//월급받음
			
			if(d1.getMonthValue() == incentive) {//인센티브 받는 달
				e1.receiveSalary();
				System.out.print(y + "년차 " + d1.getMonthValue() + "월에 인센티브를 받았습니다.\n");
			}			
			if(m == 12) {//근무 12개월 지나 연봉 증가
				y++;	m = 0;
				int percent = rnd.nextInt(10);
				e1.increaseYearlySalary(percent);
				System.out.print(y+ "년차 연봉이 " + percent + "% 인상되었습니다.\n");
				incentive = rnd.nextInt(11) + 1;//인센티브 부여할 월 초기화
			}
		}
		System.out.print("날짜: " + d1 + "\n");
		System.out.print(e1.toString()+ "\n");
	}

}
