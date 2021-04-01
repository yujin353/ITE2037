package kr.co.lab05.manager;
import java.time.LocalDate;
import kr.co.lab05.employee.*;
import java.util.Random;

public class EmployeeManager {

	public static void main(String[] args) {
		Employee e1 = new Employee("Kim", 4500);
		
		LocalDate contractDate = LocalDate.of(2021, 4, 1);
		System.out.print("�����: " + contractDate + "\n");
		
		LocalDate d1 = LocalDate.of(2021, 4, 1);
		System.out.print(e1.toString()+"\n");
		
		Random rnd = new Random();//������������
		int incentive = rnd.nextInt(11) + 1;
		
		int m = 0, y = 1;
		while(e1.getBalance() < 20000) {
			m++;	d1 = d1.plusMonths(1);//�Ѵ� ����
			e1.receiveSalary();//���޹���
			
			if(d1.getMonthValue() == incentive) {//�μ�Ƽ�� �޴� ��
				e1.receiveSalary();
				System.out.print(y + "���� " + d1.getMonthValue() + "���� �μ�Ƽ�긦 �޾ҽ��ϴ�.\n");
			}			
			if(m == 12) {//�ٹ� 12���� ���� ���� ����
				y++;	m = 0;
				int percent = rnd.nextInt(10);
				e1.increaseYearlySalary(percent);
				System.out.print(y+ "���� ������ " + percent + "% �λ�Ǿ����ϴ�.\n");
				incentive = rnd.nextInt(11) + 1;//�μ�Ƽ�� �ο��� �� �ʱ�ȭ
			}
		}
		System.out.print("��¥: " + d1 + "\n");
		System.out.print(e1.toString()+ "\n");
	}

}
