package kr.co.lab05.employee;

public class Employee {
	private String name;
	private double yearlySalary, monthlySalary, balance;
	public Employee (String name, double yearlySalary) {
		this.name = name;
		this.yearlySalary = yearlySalary;
		this.monthlySalary = this.yearlySalary / 12;
		this.balance = 0;
	}
	public double getBalance() { return this.balance; }
	public void increaseYearlySalary(int byPercent) {
		this.yearlySalary *= (1 + (double)byPercent/100);
		this.monthlySalary = this.yearlySalary /12;
	}
	public void receiveSalary() {
		this.balance += this.monthlySalary;
	}
	public String toString() {
		return "�̸�: " + this.name + " ����: " + this.yearlySalary + " ����: " + this.monthlySalary + " ���: " + this.balance; 
	}
}
