package assignment2;

public class Schedule {
	private String name;
	private int days, expense;
	private Activity[][] plan;
	private Person[] member;
	public static int scheduleNum;

	public Schedule(String name, int days, Person[] member) {
		this.name = name;
		this.days = days;
		this.expense = 0;
		this.plan = new Activity[days][12];
		this.member = new Person[member.length];
		for (int i = 0; i < member.length; i++)
			this.member[i] = new Person(member[i]);
		scheduleNum++;
	}

	public Schedule(String name, Schedule s1, Person[] member) {
		this.name = name;
		this.days = s1.days;
		this.expense = s1.expense;
		this.plan = new Activity[days][12];
		for (int i = 0; i < days; i++)
			for (int j = 0; j < 12; j++)
				this.plan[i][j] = s1.plan[i][j];
		this.member = new Person[member.length];
		for (int i = 0; i < member.length; i++)
			this.member[i] = new Person(member[i]);
		scheduleNum++;
	}

	public int getDays() {
		return this.days;
	}

	public String getName() {
		return this.name;
	}

	public int getExpense() {
		return this.expense;
	}

	public Person[] getMember() {
		return this.member;
	}

	public int setPlan(Activity activity, int day, int time) {
		if (plan[day - 1][time - 9] != null)
			return 0;
		for (int i = 0; i < this.days; i++)
			for (int j = 0; j < 12; j++)
				if (activity.equals(this.plan[i][j]))
					return 0;

		this.plan[day - 1][time - 9] = activity;
		for (Person m : member)
			this.expense += activity.getActualPrice(m);
		return 1;
	}

	public int removePlan(int day, int time) throws InvalidAccessException {
		if (plan[day - 1][time - 9] == null)
			throw new InvalidAccessException();
		for (Person m : member)
			this.expense -= this.plan[day - 1][time - 9].getActualPrice(m);
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
