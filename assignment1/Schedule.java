package assignment1;

public class Schedule {
	private String name;
	private int days, expense;
	private Activity[][] plan;
	public static int scheduleNum;

	public Schedule(String name, int days) {
		this.name = name;
		this.days = days;
		this.expense = 0;
		plan = new Activity[days][12];
		scheduleNum++;
	}

	public Schedule(String name, Schedule s1) {
		this.name = name;
		this.days = s1.days;
		this.expense = s1.expense;
		this.plan = new Activity[days][12];
		for (int i = 0; i < days; i++)
			for (int j = 0; j < 12; j++)
				this.plan[i][j] = s1.plan[i][j];
		scheduleNum++;
	}

	public String getName() {
		return this.name;
	}

	public int getExpense() {
		return this.expense;
	}

	public int setPlan(Activity activity, int day, int time) {
		if (day > this.days || plan[day - 1][time - 9] != null)
			return 0;
		this.plan[day - 1][time - 9] = activity;
		this.expense += activity.getPrice();
		return 1;
	}

	public int removePlan(int day, int time) {
		if (day > this.days || plan[day - 1][time - 9] == null)
			return 0;
		this.expense -= this.plan[day - 1][time - 9].getPrice();
		this.plan[day - 1][time - 9] = null;
		return 1;
	}

	public String print(int day, int time) {
		if (plan[day - 1][time - 9] == null)
			return "----";
		else
			return this.plan[day - 1][time - 9].getName();
	}

	public void printSchedule() {
		for (int i = 1; i <= days; i++)
			System.out.print("-------------------");
		System.out.println();
		System.out.print("                ");
		for (int i = 1; i <= days; i++)
			System.out.printf("%-16s", "Day " + i);
		System.out.println();
		for (int i = 0; i < 12; i++) {
			System.out.printf("%-16s", i + 9 + ":00");
			for (int j = 1; j <= days; j++)
				System.out.printf("%-16s", print(j, i + 9));
			System.out.println();
		}
		for (int i = 1; i <= days; i++)
			System.out.print("-------------------");
		System.out.println();
		System.out.println("Total expenses: " + getExpense() + " won");
		for (int i = 1; i <= days; i++)
			System.out.print("-------------------");
		System.out.println();
	}
}
