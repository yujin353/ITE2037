package assignment1;

import java.util.Scanner;

public class TravelScheduler {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		Schedule[] scheduleList = new Schedule[5];
		Activity[] activityList = new Activity[8];

		activityList[0] = new Activity("Hiking", "Mountain", 0);
		activityList[1] = new Activity("Horse Riding", "Hill", 3000);
		activityList[2] = new Activity("Visiting Museum", "Museum", 8000);
		activityList[3] = new Activity("Watching movie", "Theater", 11000);
		activityList[4] = new Activity("Fishing", "Sea", 15000);
		activityList[5] = new Activity("Surffing", "Beach", 20000);
		activityList[6] = new Activity("Camping", "Field", 30000);
		activityList[7] = new Activity("Paragliding", "Mountain", 50000);

		int input[] = new int[10];
		int check;

		for (; input[0] != 3;) {// 3을 고르면 출력후 빠져나감
			System.out.println("1) Select schedule");
			System.out.println("2) Edit schedule");
			System.out.println("3) End program");
			System.out.print("Select menu: ");
			input[0] = scan.nextInt();

			switch (input[0]) {
			case 1:// 1) Select schedule
					// 만들어진 schedule을 나열
				for (int i = 0; i < scheduleList.length; i++) {
					if (scheduleList[i] != null)
						System.out.println(i + 1 + ") " + scheduleList[i].getName());
					else
						System.out.println(i + 1 + ") EMPTY SCHEDULE");
				}
				System.out.print("Select a schedule: ");
				input[1] = scan.nextInt();
				if (input[1] == 0 || scheduleList[input[1] - 1] == null) // 0 또는 EMPTY SCHEDULE을 선택하면 이전 메뉴로 돌아 감
					continue;
				// Schedule을 선택하면 해당 schedule에 대한 수정 및 출력을 반복 수행
				do {// 0고르면 탈출
					System.out.println("1) Add activity");
					System.out.println("2) Remove activity");
					System.out.println("3) Print schedule");
					System.out.print("Select menu: ");
					input[2] = scan.nextInt();
					switch (input[2]) {
					case 0:
						break;
					case 1:// input[1]에 add activity
						for (int i = 0; i < activityList.length; i++)
							System.out.println(i + 1 + ") " + activityList[i].toString());
						System.out.print("Select activity to do: ");
						input[3] = scan.nextInt();
						System.out.print("Enter the day to do activity: ");
						input[4] = scan.nextInt();
						System.out.print("Enter the time to do activity(9~20): ");
						input[5] = scan.nextInt();
						check = scheduleList[input[1] - 1].setPlan(activityList[input[3] - 1], input[4], input[5]);
						if (check == 0)
							System.out.println("Fail to add activity");
						break;

					case 2:// input[1]에 remove activity
						scheduleList[input[1] - 1].printSchedule();
						System.out.print("Enter the day to remove activity: ");
						int day = scan.nextInt();
						System.out.print("Enter the time to remove activity: ");
						int time = scan.nextInt();
						check = scheduleList[input[1] - 1].removePlan(day, time);
						if (check == 1)
							System.out.println("Removed successfully");
						break;

					case 3:// input[1]에 print schedule
						scheduleList[input[1] - 1].printSchedule();
						break;
					}
				} while (input[2] != 0);
				break;

			case 2:// 2) Edit schedule //Schedule을 초기화하며 생성
				do {
					System.out.println("1) Make a new schedule");
					System.out.println("2) Copy an existing schedule");
					System.out.print("Select menu: ");
					input[6] = scan.nextInt();

					switch (input[6]) {
					case 0:
						break;
					case 1:// 1) Make a new schedule
							// Make a new schedule 이름, 전체 일 수를 입력 받아서 schedule 생성
						System.out.print("Enter a name for the schedule: ");
						scan.nextLine();
						String name = scan.nextLine();
						System.out.print("Enter travel days: ");
						int days = scan.nextInt();
						scheduleList[Schedule.scheduleNum] = new Schedule(name, days);
						break;
					case 2:// 2) Copy an existing schedule
							// Copy an exist schedule
						for (int i = 0; i < scheduleList.length; i++) {
							if (scheduleList[i] != null)
								System.out.println(i + 1 + ") " + scheduleList[i].getName());
							else
								System.out.println(i + 1 + ") EMPTY SCHEDULE");
						}
						System.out.print("Select the schedule to copy: ");
						input[7] = scan.nextInt();
						scan.nextLine();
						if (scheduleList[input[7] - 1] == null) // EMPTY SCHEDULE을 선택하면 이전 메뉴로 돌아 감
							continue;
						System.out.print("Enter a new schedule name: ");
						String s_1 = scan.nextLine();
						scheduleList[Schedule.scheduleNum] = new Schedule(s_1, scheduleList[input[7] - 1]);
						break;
					}
				} while (input[6] != 0);
				break;

			case 3:// 3) End program
				break;
			}

		}
		scan.close();
	}

}
