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
		return "이름: " + this.name + " 연봉: " + this.yearlySalary + " 월급: " + this.monthlySalary + " 재산: " + this.balance; 
	}
}
