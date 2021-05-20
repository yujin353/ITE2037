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

		// activityList �ʱ�ȭ
		try {
			inputStream = new Scanner(new FileInputStream("ActivityList.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("File ActivityList.txt was not found");
			System.out.println("or could not be opened.");
			System.exit(0);// File read/write���� �߻��ϴ� Exception�� ���α׷��� ����
		} catch (IOException e) {
			System.exit(0);// File read/write���� �߻��ϴ� Exception�� ���α׷��� ����
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

		// memberList �ʱ�ȭ
		try {
			inputStream = new Scanner(new FileInputStream("MemberList.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("File MemberList.txt was not found");
			System.out.println("or could not be opened.");
			System.exit(0);// File read/write���� �߻��ϴ� Exception�� ���α׷��� ����
		} catch (IOException e) {
			System.exit(0);// File read/write���� �߻��ϴ� Exception�� ���α׷��� ����
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

		while (input[0] != 3) {// 3�� ���� ����� ��������
			System.out.println("1) Select schedule");
			System.out.println("2) Edit schedule");
			System.out.println("3) End program");
			while (true) {
				try {
					System.out.print("Select menu: ");
					input[0] = scan.nextInt();
					if (input[0] > 3 || input[0] < 1)
						throw new InvalidAccessException();
					break;
				} catch (InvalidAccessException e) {
					System.out.println(e.getMessage());
					// continue;
				} catch (InputMismatchException e) {
					// �� scanner.nextLine�� ���ָ� ������ �ذ�Ǵ°�?
					// scanner�� �̹� �Էµ� Ű�� ��� �����ϱ� ����
					// ����Ǿ��ִ� ���� ����
					scan.nextLine();
					System.out.println("Enter number!");
					// continue;
				}
			}
			switch (input[0]) {
			case 1:// 1) Select schedule
					// ������� schedule�� ����
				for (int i = 0; i < scheduleList.length; i++) {
					if (scheduleList[i] != null)
						System.out.println(i + 1 + ") " + scheduleList[i].getName());
					else
						System.out.println(i + 1 + ") EMPTY SCHEDULE");
				}

				while (true) {
					try {
						System.out.print("Select a schedule: ");
						input[1] = scan.nextInt();
						if (input[1] > scheduleList.length || input[1] < 0)
							throw new InvalidAccessException();
						break;
					} catch (InvalidAccessException e) {
						System.out.println(e.getMessage());
						continue;
					} catch (InputMismatchException e) {
						scan.nextLine();
						System.out.println("Enter number!");
						continue;
					}
				}
				if (input[1] == 0 || scheduleList[input[1] - 1] == null) // 0 �Ǵ� EMPTY SCHEDULE�� �����ϸ� ���� �޴��� ���� ��
					continue;

				// Schedule�� �����ϸ� �ش� schedule�� ���� ���� �� ����� �ݺ� ����
				do {
					System.out.println("1) Add activity");
					System.out.println("2) Remove activity");
					System.out.println("3) Print schedule");
					while (true) {
						System.out.print("Select menu: ");
						try {
							input[2] = scan.nextInt();
							if (input[2] > 3 || input[2] < 0)
								throw new InvalidAccessException();
							break;
						} catch (InvalidAccessException e) {
							System.out.println(e.getMessage());
							continue;
						} catch (InputMismatchException e) {
							scan.nextLine();
							System.out.println("Enter number!");
							continue;
						}
					}

					switch (input[2]) {
					case 0:
						break;
					case 1:// input[1]�� add activity
						int occur = 0;
						do {
							occur = 0;
							for (int i = 0; i < activityList.length; i++)
								System.out.println(i + 1 + ") " + activityList[i].toString());

							while (true) {
								try {
									System.out.print("Select activity to do: ");
									input[3] = scan.nextInt();
									if (input[3] > activityList.length || input[3] < 1)
										throw new InvalidAccessException("Activity");
									break;
								} catch (InvalidAccessException e) {
									System.out.println(e.getMessage());
									continue;
								} catch (InputMismatchException e) {
									scan.nextLine();
									System.out.println("Enter number!");
									continue;
								}
							}

							while (true) {
								try {
									System.out.print("Enter the day to do activity: ");
									input[4] = scan.nextInt();
									if (input[4] > scheduleList[input[1] - 1].getDays() || input[4] < 1)
										throw new InvalidAccessException(" Day");
									break;
								} catch (InvalidAccessException e) {
									System.out.println(e.getMessage());
									continue;
								} catch (InputMismatchException e) {
									scan.nextLine();
									System.out.println("Enter number!");
									continue;
								}
							}

							while (true) {
								try {
									System.out.print("Enter the time to do activity(9~20): ");
									input[5] = scan.nextInt();
									if (input[5] > 20 || input[5] < 9)
										throw new InvalidAccessException(" Time");
									break;
								} catch (InvalidAccessException e) {
									System.out.println(e.getMessage());
									continue;
								} catch (InputMismatchException e) {
									scan.nextLine();
									System.out.println("Enter number!");
									continue;
								}
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

					case 2:// input[1]�� remove activity
						scheduleList[input[1] - 1].printSchedule();
						int day = 0, time = 0;
						while (true) {
							try {
								System.out.print("Enter the day to remove activity: ");
								day = scan.nextInt();
								if (day > scheduleList[input[1] - 1].getDays() || day < 1)
									throw new InvalidAccessException(" Day");
								break;
							} catch (InvalidAccessException e) {
								System.out.println(e.getMessage());
								continue;
							} catch (InputMismatchException e) {
								scan.nextLine();
								System.out.println("Enter number!");
								continue;
							}
						}
						while (true) {
							try {
								System.out.print("Enter the time to remove activity: ");
								time = scan.nextInt();
								if (time > 20 || time < 9)
									throw new InvalidAccessException(" Time");
								break;
							} catch (InvalidAccessException e) {
								System.out.println(e.getMessage());
								continue;
							} catch (InputMismatchException e) {
								scan.nextLine();
								System.out.println("Enter number!");
								continue;
							}
						}
						try {
							check = scheduleList[input[1] - 1].removePlan(day, time);
							if (check == 1)
								System.out.println("Removed successfully");
						} catch (InvalidAccessException e) {
							System.out.println(e.getMessage());
							continue;
						}
						break;

					case 3:// input[1]�� print schedule
						scheduleList[input[1] - 1].printSchedule();
						for (Person m : scheduleList[input[1] - 1].getMember())
							System.out.println(
									m.getName() + ", " + m.getAge() + ", " + m.getHeight() + ", " + m.getWeight());

						break;
					}
				} while (input[2] != 0);
				break;

			case 2:// 2) Edit schedule //Schedule�� �ʱ�ȭ�ϸ� ����
				do {
					System.out.println("1) Make a new schedule");
					System.out.println("2) Copy an existing schedule");
					while (true) {
						try {
							System.out.print("Select menu: ");
							input[6] = scan.nextInt();
							if (input[6] > 2 || input[6] < 0)
								throw new InvalidAccessException();
							if (Schedule.scheduleNum == 5)
								throw new ArrayFullException();
							break;
						} catch (InvalidAccessException e) {
							System.out.println(e.getMessage());
							continue;
						} catch (ArrayFullException e) {
							System.out.println(e.getMessage());
							continue;
						} catch (InputMismatchException e) {
							scan.nextLine();
							System.out.println("Enter number!");
							continue;
						}
					}

					switch (input[6]) {
					case 1:// 1) Make a new schedule
							// Make a new schedule �̸�, ��ü �� ���� �Է� �޾Ƽ� schedule ����
						scan.nextLine();
						String name = null;
						while (true) {
							try {
								System.out.print("Enter a name for the schedule: ");
								name = scan.nextLine();
								break;
							} catch (InputMismatchException e) {
								System.out.println("Enter String!");
							}
						}

						int days = 0;
						while (true) {
							try {
								System.out.print("Enter travel days: ");
								days = scan.nextInt();
								if (days <= 0)
									throw new InvalidAccessException();
								break;
							} catch (InvalidAccessException e) {
								System.out.println(e.getMessage());
								continue;
							} catch (InputMismatchException e) {
								scan.nextLine();
								System.out.println("Enter number!");
								continue;
							}
						}

						int num = 0;
						while (true) {
							try {
								System.out.print("Enter number of member: ");
								num = scan.nextInt();
								scan.nextLine();
								if (num > member.length || num < 1)
									throw new InvalidAccessException();
								break;
							} catch (InvalidAccessException e) {
								System.out.println(e.getMessage());
								continue;
							} catch (InputMismatchException e) {
								scan.nextLine();
								System.out.println("Enter number!");
								continue;
							}
						}

						Person[] members = new Person[num];
						int mem = 1;
						for (Person m : member) {
							System.out.println(mem + ") " + m.getName() + ", " + m.getAge() + ", " + m.getHeight()
									+ ", " + m.getWeight());
							mem++;
						}
						int[] n = new int[num];
						for (int i = 0; i < num;) {
							try {
								System.out.print("Choose member " + (i + 1) + ": ");
								n[i] = scan.nextInt();
								scan.nextLine();
								if (n[i] < 1 || n[i] > member.length)
									throw new InvalidAccessException();
								for (int j = 0; j < i; j++)
									if (n[i] == n[j])
										throw new InvalidAccessException(" Already selected member");

							} catch (InvalidAccessException e) {
								System.out.println(e.getMessage());
								continue;
							} catch (InputMismatchException e) {
								scan.nextLine();
								System.out.println("Enter number!");
								continue;
							}
							members[i] = new Person(member[n[i] - 1]);
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
						while (true) {
							try {
								System.out.print("Select the schedule to copy: ");
								input[7] = scan.nextInt();
								scan.nextLine();
								if (input[7] > scheduleList.length || input[7] < 0)
									throw new InvalidAccessException();
								break;
							} catch (InvalidAccessException e) {
								System.out.println(e.getMessage());
								continue;
							} catch (InputMismatchException e) {
								scan.nextLine();
								System.out.println("Enter number!");
								continue;
							}
						}

						if (input[7] > Schedule.scheduleNum || input[7] == 0)
							break;

						String s_1 = null;
						while (true) {
							try {
								System.out.print("Enter a new schedule name: ");
								s_1 = scan.nextLine();
								break;
							} catch (InputMismatchException e) {
								System.out.println("Enter String!");
								continue;
							}
						}
						scheduleList[Schedule.scheduleNum] = new Schedule(s_1, scheduleList[input[7] - 1], member);
						break;
					}
				} while (input[6] != 0);
				// break;

			case 3:// 3) End program
				break;
			}

		}
		scan.close();
		inputStream.close();
	}

}
