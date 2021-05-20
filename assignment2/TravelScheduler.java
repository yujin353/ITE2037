package assignment2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TravelScheduler {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Scanner inputStream = null;

		Schedule[] scheduleList = new Schedule[5];

		// activityList 초기화
		try {
			inputStream = new Scanner(new FileInputStream("ActivityList.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("File ActivityList.txt was not found");
			System.out.println("or could not be opened.");
			System.exit(0);// File read/write에서 발생하는 Exception은 프로그램을 종료
		} catch (IOException e) {
			System.exit(0);// File read/write에서 발생하는 Exception은 프로그램을 종료
		}
		int activityNum = inputStream.nextInt();
		inputStream.nextLine();
		Activity[] activityList = new Activity[activityNum];
		for (int i = 0; inputStream.hasNextLine(); i++) {
			String s = inputStream.nextLine();
			String[] ss = s.split(", ");
			int price = Integer.parseInt(ss[3]);
			if (ss[0].equals("Activity")) {
				activityList[i] = new Activity(ss[1], ss[2], price);
			} else if (ss[0].equals("Show")) {
				int age = Integer.parseInt(ss[4]);
				activityList[i] = new ShowActivity(ss[1], ss[2], price, age);
			} else if (ss[0].equals("Extreme")) {
				int height = Integer.parseInt(ss[4]);
				int weight = Integer.parseInt(ss[5]);
				activityList[i] = new ExtremeActivity(ss[1], ss[2], price, height, weight);
			}
		}

		// memberList 초기화
		try {
			inputStream = new Scanner(new FileInputStream("MemberList.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("File MemberList.txt was not found");
			System.out.println("or could not be opened.");
			System.exit(0);// File read/write에서 발생하는 Exception은 프로그램을 종료
		} catch (IOException e) {
			System.exit(0);// File read/write에서 발생하는 Exception은 프로그램을 종료
		}
		int memberNum = inputStream.nextInt();
		inputStream.nextLine();
		Person[] member = new Person[memberNum];
		for (int i = 0; inputStream.hasNextLine(); i++) {
			String s = inputStream.nextLine();
			String[] ss = s.split(", ");
			int age = Integer.parseInt(ss[1]);
			int height = Integer.parseInt(ss[2]);
			int weight = Integer.parseInt(ss[3]);
			member[i] = new Person(ss[0], age, height, weight);
		}

		int input[] = new int[10];
		int check = 0;

		while (input[0] != 3) {// 3을 고르면 출력후 빠져나감
			try {
				System.out.println("1) Select schedule");
				System.out.println("2) Edit schedule");
				System.out.println("3) End program");
				System.out.print("Select menu: ");
				input[0] = scan.nextInt();
				if (input[0] > 3 || input[0] < 1)
					throw new InvalidAccessException();
			} catch (InvalidAccessException e) {
				System.out.println(e.getMessage());
			} catch (InputMismatchException e) {
				// 왜 scanner.nextLine만 써주면 문제가 해결되는가?
				// scanner에 이미 입력된 키를 모두 제거하기 위해
				// 저장되어있는 값을 제거
				scan.nextLine();
				System.out.println("Enter number!");
				continue;
			}
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
				try {
					input[1] = scan.nextInt();
					if (input[1] > scheduleList.length || input[1] < 0)
						throw new InvalidAccessException();
				} catch (InvalidAccessException e) {
					System.out.println(e.getMessage());
					break;
				} catch (InputMismatchException e) {
					scan.nextLine();
					System.out.println("Enter number!");
					break;
				}
				if (input[1] == 0 || scheduleList[input[1] - 1] == null) // 0 또는 EMPTY SCHEDULE을 선택하면 이전 메뉴로 돌아 감
					continue;

				// Schedule을 선택하면 해당 schedule에 대한 수정 및 출력을 반복 수행
				do {
					System.out.println("1) Add activity");
					System.out.println("2) Remove activity");
					System.out.println("3) Print schedule");
					System.out.print("Select menu: ");
					try {
						input[2] = scan.nextInt();
						if (input[2] > 3 || input[2] < 0)
							throw new InvalidAccessException();
					} catch (InvalidAccessException e) {
						System.out.println(e.getMessage());
						continue;
					} catch (InputMismatchException e) {
						scan.nextLine();
						System.out.println("Enter number!");
						continue;
					}

					switch (input[2]) {
					case 0:
						break;
					case 1:// input[1]에 add activity
						int occur = 0;
						do {
							occur = 0;
							for (int i = 0; i < activityList.length; i++)
								System.out.println(i + 1 + ") " + activityList[i].toString());
							try {
								System.out.print("Select activity to do: ");
								input[3] = scan.nextInt();
								if (input[3] > activityList.length || input[3] < 1)
									throw new InvalidAccessException("Activity");
								System.out.print("Enter the day to do activity: ");
								input[4] = scan.nextInt();
								if (input[4] > scheduleList.length || input[4] < 1)
									throw new InvalidAccessException("Day");
								System.out.print("Enter the time to do activity(9~20): ");
								input[5] = scan.nextInt();
								if (input[5] > 20 || input[5] < 9)
									throw new InvalidAccessException("Time");
							} catch (InvalidAccessException e) {
								System.out.println(e.getMessage());
								break;
							} catch (InputMismatchException e) {
								scan.nextLine();
								System.out.println("Enter number!");
								continue;
							}

							try {
								if (activityList[input[3] - 1] instanceof ShowActivity) {
									ShowActivity s = (ShowActivity) activityList[input[3] - 1];
									for (Person m : scheduleList[input[1] - 1].getMember())
										if (m.getAge() < s.getMinAge())
											throw new InsufficientConditionException("age");
									check = scheduleList[input[1] - 1].setPlan(s, input[4], input[5]);
								} else if (activityList[input[3] - 1] instanceof ExtremeActivity) {
									ExtremeActivity e = (ExtremeActivity) activityList[input[3] - 1];
									for (Person m : scheduleList[input[1] - 1].getMember())
										if (m.getHeight() < e.getMinHeight() || m.getWeight() < e.getMinWeight())
											throw new InsufficientConditionException("height of weight");
									check = scheduleList[input[1] - 1].setPlan(e, input[4], input[5]);
								} else
									check = scheduleList[input[1] - 1].setPlan(activityList[input[3] - 1], input[4],
											input[5]);

								if (check == 0)
									System.out.println("Fail to add activity");
							} catch (InsufficientConditionException e) {
								System.out.println(e.getMessage());
								occur = 1;
							}
						} while (occur == 1);
						break;

					case 2:// input[1]에 remove activity
						scheduleList[input[1] - 1].printSchedule();
						try {
							System.out.print("Enter the day to remove activity: ");
							int day = scan.nextInt();
							System.out.print("Enter the time to remove activity: ");
							int time = scan.nextInt();
							check = scheduleList[input[1] - 1].removePlan(day, time);
							if (check == 1)
								System.out.println("Removed successfully");
							break;
						} catch (InvalidAccessException e) {
							System.out.println(e.getMessage());
							continue;
						} catch (InputMismatchException e) {
							scan.nextLine();
							System.out.println("Enter number!");
							continue;
						}

					case 3:// input[1]에 print schedule
						scheduleList[input[1] - 1].printSchedule();
						for (Person m : scheduleList[input[1] - 1].getMember())
							System.out.println(
									m.getName() + ", " + m.getAge() + ", " + m.getHeight() + ", " + m.getWeight());

						break;
					}
				} while (input[2] != 0);
				break;

			case 2:// 2) Edit schedule //Schedule을 초기화하며 생성
				do {
					System.out.println("1) Make a new schedule");
					System.out.println("2) Copy an existing schedule");
					try {
						System.out.print("Select menu: ");
						input[6] = scan.nextInt();
						if (input[6] > 2 || input[6] < 0)
							throw new InvalidAccessException();
						if (Schedule.scheduleNum == 5)
							throw new ArrayFullException();
					} catch (InvalidAccessException e) {
						System.out.println(e.getMessage());
					} catch (ArrayFullException e) {
						System.out.println(e.getMessage());
					} catch (InputMismatchException e) {
						scan.nextLine();
						System.out.println("Enter number!");
						continue;
					}

					switch (input[6]) {
					case 0:
						break;
					case 1:// 1) Make a new schedule
							// Make a new schedule 이름, 전체 일 수를 입력 받아서 schedule 생성
						scan.nextLine();
						String name = null;
						try {
							System.out.print("Enter a name for the schedule: ");
							name = scan.nextLine();
						} catch (InputMismatchException e) {
							System.out.println("Enter String!");
						}
						int days = 0;
						try {
							System.out.print("Enter travel days: ");
							days = scan.nextInt();
							if (days <= 0)
								throw new InvalidAccessException();
						} catch (InvalidAccessException e) {
							System.out.println(e.getMessage());
							continue;
						} catch (InputMismatchException e) {
							scan.nextLine();
							System.out.println("Enter number!");
							break;
						}

						int num = 0;
						try {
							System.out.print("Enter number of member: ");
							num = scan.nextInt();
							scan.nextLine();
							if (num > member.length || num < 0)
								throw new InvalidAccessException();
						} catch (InvalidAccessException e) {
							System.out.println(e.getMessage());
							continue;
						} catch (InputMismatchException e) {
							scan.nextLine();
							System.out.println("Enter number!");
							continue;
						}
						Person[] members = new Person[num];
						int mem = 1;
						for (Person m : member) {
							System.out.println(mem + ") " + m.getName() + ", " + m.getAge() + ", " + m.getHeight()
									+ ", " + m.getWeight());
							mem++;
						}
						for (int i = 0; i < num;) {
							int n = 0;
							try {
								System.out.print("Choose member " + (i + 1) + ": ");
								n = scan.nextInt();
								scan.nextLine();
								if (n > member.length || n < 0)
									throw new InvalidAccessException();
							} catch (InvalidAccessException e) {
								System.out.println(e.getMessage());
							} catch (InputMismatchException e) {
								scan.nextLine();
								System.out.println("Enter number!");
								continue;
							}
							members[i] = new Person(member[n - 1]);
							i++;
						}
						scheduleList[Schedule.scheduleNum] = new Schedule(name, days, members);
						break;

					case 2:// 2) Copy an existing schedule
							// Copy an exist schedule
						for (int i = 0; i < scheduleList.length; i++) {
							if (scheduleList[i] != null)
								System.out.println(i + 1 + ") " + scheduleList[i].getName());
							else
								System.out.println(i + 1 + ") EMPTY SCHEDULE");
						}
						try {
							System.out.print("Select the schedule to copy: ");
							input[7] = scan.nextInt();
							scan.nextLine();
							if (input[7] > Schedule.scheduleNum || input[7] < 0)
								throw new InvalidAccessException();
						} catch (InvalidAccessException e) {
							System.out.println(e.getMessage());
							continue;
						} catch (InputMismatchException e) {
							scan.nextLine();
							System.out.println("Enter number!");
							continue;
						}
						String s_1 = null;
						try {
							System.out.print("Enter a new schedule name: ");
							s_1 = scan.nextLine();
						} catch (InputMismatchException e) {
							System.out.println("Enter String!");
							continue;
						}
						scheduleList[Schedule.scheduleNum] = new Schedule(s_1, scheduleList[input[7] - 1], member);
						break;
					}
				} while (input[6] != 0);
				break;

			case 3:// 3) End program
				break;
			}

		}
		scan.close();
		inputStream.close();
	}

}
