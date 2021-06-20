package assignment3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Shopping {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Scanner inputStream = null;
		PrintWriter outputStream = null;

		LocalDateTime current = LocalDateTime.of(2021, 5, 27, 15, 00);
		int input[] = new int[20];

		// customerlist 초기화
		try {
			inputStream = new Scanner(new FileInputStream("customerWallets.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("File customerWallet.txt was not found");
			System.out.println("or could not be opened.");
			System.exit(0);
		}

		int cNum = inputStream.nextInt();
		inputStream.nextLine();

		Customer[] cstm = new Customer[cNum];
		for (int i = 0; inputStream.hasNextLine(); i++) {
			ArrayList<Payable> p = new ArrayList<Payable>();
			String s1 = inputStream.nextLine();
			String[] ss1 = s1.split(", ");
			String s2 = inputStream.nextLine();
			String[] ss2 = s2.split(", ");
			Cash c1 = null;
			Credit c2 = null;
			if (ss2[0].equals("Cash")) {
				c1 = new Cash(ss2[1], Integer.parseInt(ss2[2]));
				p.add(c1);
			} else if (ss2[0].equals("Credit")) {
				c2 = new Credit(ss2[1], Integer.parseInt(ss2[2]), Integer.parseInt(ss2[3]));
				p.add(c2);
			}

			if (ss1[1].equals("2")) {
				String s3 = inputStream.nextLine();
				String[] ss3 = s3.split(", ");
				if (ss3[0].equals("Cash")) {
					c1 = new Cash(ss3[1], Integer.parseInt(ss3[2]));
					p.add(c1);
				} else if (ss3[0].equals("Credit")) {
					c2 = new Credit(ss3[1], Integer.parseInt(ss3[2]), Integer.parseInt(ss3[3]));
					p.add(c2);
				}
			}
			cstm[i] = new Customer(ss1[0], p);
		}

		// 물건 list 초기화
		try {
			inputStream = new Scanner(new FileInputStream("Mart.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("File Mart.txt was not found");
			System.out.println("or could not be opened.");
			System.exit(0);
		}

		int pNum = inputStream.nextInt();
		inputStream.nextLine();
		ArrayList<Product> sList = new ArrayList<Product>(pNum);
		for (int i = 0; inputStream.hasNextLine(); i++) {
			Product prod;
			String s = inputStream.nextLine();
			String[] ss = s.split(", ");

			if (ss[0].equals("Food")) {
				LocalDateTime exp = LocalDateTime.of(Integer.parseInt(ss[3]), Integer.parseInt(ss[4]),
						Integer.parseInt(ss[5]), Integer.parseInt(ss[6]), Integer.parseInt(ss[7]));
				prod = new Food(ss[1], Integer.parseInt(ss[2]), Integer.parseInt(ss[8]), exp);
				sList.add(prod);
			} else if (ss[0].equals("Manufactured")) {
				prod = new Manufactured(ss[1], Integer.parseInt(ss[2]), Integer.parseInt(ss[4]), ss[3]);
				sList.add(prod);
			}
		}
		Mart mart = new Mart(sList);

		while (input[0] != 3) {
			System.out.println("1) Manager Mode");
			System.out.println("2) Customer Mode");
			System.out.println("3) End program");
			while (true) {
				try {
					System.out.print("Select menu: ");
					input[0] = scan.nextInt();
					if (input[0] > 3 || input[0] < 1)
						throw new InvalidAccessException(1, 3);
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
			switch (input[0]) {
			case 1:// Manager Mode
				do {
					System.out.println("1) Add Inventory");
					System.out.println("2) Replace expired");

					do {
						try {
							System.out.print("Select menu: ");
							input[1] = scan.nextInt();
							if (input[1] > 2 || input[1] < 0)
								throw new InvalidAccessException(1, 2);
							break;
						} catch (InvalidAccessException e) {
							System.out.println(e.getMessage());
						} catch (InputMismatchException e) {
							scan.nextLine();
							System.out.println("Enter number!");
							input[1] = -1;
						}
					} while (input[1] != 0);

					if (input[1] == 0)
						break;
					switch (input[1]) {
					case 1:// add inventory
						for (int i = 0; i < mart.salesListSize(); i++) {
							Product p = mart.getProduct(i);
							System.out.print((i + 1) + ". (Quantity: " + p.getQuantity() + ") " + p.getName() + ", "
									+ p.getPrice() + "won");
							if (mart.getProduct(i) instanceof Food) {
								Food f = (Food) p;
								System.out.println(" Best before: " + f.getExp());
							} else
								System.out.println();
						}
						while (true) {
							try {
								System.out.print("Select Product: ");
								input[2] = scan.nextInt();
								if (input[2] > mart.salesListSize() || input[2] < 1)
									throw new InvalidAccessException(1, mart.salesListSize());
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
								System.out.print("Enter quantity: ");
								input[3] = scan.nextInt();
								if (input[3] < 0)
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

						if (mart.getProduct(input[2] - 1).getQuantity() == 0) {
							// shopping cart에 추가가능해짐 OBSERVER이용
							mart.getProduct(input[2] - 1).IncreaseQuantity(input[3]);
							mart.notifyObservers();
						} else
							mart.getProduct(input[2] - 1).IncreaseQuantity(input[3]);
						break;

					case 2:// replace expired
						ArrayList<Food> expired = new ArrayList<Food>();
						for (int i = 0; i < mart.salesListSize(); i++) {
							if (mart.getProduct(i) instanceof Food) {
								Food f = (Food) mart.getProduct(i);
								if (f.isExpired(current)) {
									expired.add(f);
									System.out.println((i + 1) + ". (Quantity: " + f.getQuantity() + ") " + f.getName()
											+ ", " + f.getPrice() + "won, Best before: " + f.getExp());
								}
							}
						}
						if (expired.size() == 0) {
							System.out.println("유통기한 넘은 음식 없다");
							break;
						}
						while (true) {
							try {
								System.out.print("늘릴 유통기한 입력: ");
								input[4] = scan.nextInt();
								if (input[4] < 0)
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
						for (Food food : expired)
							food.extendExp(current, input[4]);
					}
				} while (input[1] != 0);
				break;

			case 2:// Customer Mode
				for (int i = 0; i < cstm.length; i++)
					System.out.println((i + 1) + ") " + cstm[i].getName());
				do {
					try {
						System.out.print("Choose Customer: ");
						input[5] = scan.nextInt();
						if (input[5] < 0 || input[5] > cstm.length)
							throw new InvalidAccessException(1, cstm.length);
						break;
					} catch (InvalidAccessException e) {
						System.out.println(e.getMessage());
						input[5] = -1;
					} catch (InputMismatchException e) {
						scan.nextLine();
						System.out.println("Enter number!");
						input[5] = -1;
					}
				} while (input[5] != 0);
				if (input[5] == 0)
					break;

				do {
					System.out.println("1. Shopping");
					System.out.println("2. Print Shopping Cart");
					System.out.println("3. Paying");
					System.out.println("4. Print Wallet");
					do {
						try {
							System.out.print("Choose Mode: ");
							input[6] = scan.nextInt();
							if (input[6] < 0 || input[6] > 4)
								throw new InvalidAccessException(1, 4);
							break;
						} catch (InvalidAccessException e) {
							System.out.println(e.getMessage());
						} catch (InputMismatchException e) {
							scan.nextLine();
							System.out.println("Enter number!");
							input[6] = -1;
						}
					} while (input[6] != 0);
					if (input[6] == 0)
						break;

					switch (input[6]) {
					case 1:// Shopping
						do {
							for (int i = 0; i < mart.salesListSize(); i++) {
								Product p = mart.getProduct(i);
								System.out.print((i + 1) + ". (Quantity: " + p.getQuantity() + ") " + p.getName() + ", "
										+ p.getPrice() + "won");
								if (mart.getProduct(i) instanceof Food) {
									Food f = (Food) p;
									System.out.println(" Best before: " + f.getExp());
								} else
									System.out.println();
							}
							do {
								try {
									System.out.print("Select Product: ");
									input[7] = scan.nextInt();
									if (input[7] == 0)
										break;
									if (input[7] > mart.salesListSize() || input[7] < 1)
										throw new InvalidAccessException(1, 10);
									if (mart.getProduct(input[7] - 1) instanceof Food) {
										Food f = (Food) mart.getProduct(input[7] - 1);
										if (f.isExpired(current))
											throw new ExpiredProductException("유통기한 지난 식품으로 구매 불가");
									}
									break;
								} catch (ExpiredProductException e) {
									System.out.println(e.getMessage());
								} catch (InvalidAccessException e) {
									System.out.println(e.getMessage());
									continue;
								} catch (InputMismatchException e) {
									scan.nextLine();
									System.out.println("Enter number!");
									input[7] = -1;
									continue;
								}
							} while (input[7] != 0);
							if (input[7] == 0)
								break;

							while (true) {
								try {
									System.out.print("Enter quantity: ");
									input[8] = scan.nextInt();
									if (input[8] < 0)
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
							try {
								if (mart.getProduct(input[7] - 1) instanceof Food) {
									Food f = (Food) mart.getProduct(input[7]);
									if (f.isExpired(current))
										throw new ExpiredProductException(f.getExp());
								}
							} catch (ExpiredProductException e) {
								System.out.println(e.getMessage());
							}
							if (mart.getProduct(input[7] - 1).getQuantity() < input[8]) {
								// 재고부족
								mart.addObserver(cstm[input[5] - 1]);
							} else {
								// customer의 shopping cart에 추가
								Product p = new Product(mart.getProduct(input[7] - 1).getName(),
										mart.getProduct(input[7] - 1).getPrice(), input[8]);
								cstm[input[5] - 1].setShoppingCart(p);
								mart.getProduct(input[7] - 1).DecreaseQuantity(input[8]);
							}
						} while (input[7] != 0);

						continue;
					case 2:// Print Shopping Cart
						int tot = 0;
						System.out.println(current);
						System.out.printf("%12s%12s%12s%12s\n", "Product name", "Unit price", "Quantity", "Amount");
						System.out.println("------------------------------------------------");
						for (Product p : cstm[input[5] - 1].getShoppingCart()) {
							int amount = p.getPrice() * p.getQuantity();
							System.out.printf("%12s%12s%12s%12s\n", p.getName(), p.getPrice(), p.getQuantity(), amount);
							tot += amount;
						}
						System.out.println("------------------------------------------------");
						System.out.printf("%s%37d\n", "Total price", tot);
						System.out.println("------------------------------------------------");
						continue;
					case 3:// Paying
						int total = 0;
						System.out.println(current);
						System.out.printf("%12s%12s%12s%12s\n", "Product name", "Unit price", "Quantity", "Amount");
						System.out.println("------------------------------------------------");
						for (Product p : cstm[input[5] - 1].getShoppingCart()) {
							int amount = p.getPrice() * p.getQuantity();
							System.out.printf("%12s%12s%12s%12s\n", p.getName(), p.getPrice(), p.getQuantity(), amount);
							total += amount;
						}
						System.out.println("------------------------------------------------");
						System.out.printf("%s%37d\n", "Total price", total);
						System.out.println("------------------------------------------------");

						for (int i = 0; i < cstm[input[5] - 1].getWallet().size(); i++)
							System.out.println((i + 1) + ". " + cstm[input[5] - 1].getWallet().get(i));

						while (true) {
							try {
								System.out.print("Select payment method: ");
								input[9] = scan.nextInt();
								if (input[9] < 1 || input[9] > cstm[input[5] - 1].getWallet().size())
									throw new InvalidAccessException(1, cstm[input[5] - 1].getWallet().size());

								if (cstm[input[5] - 1].getWallet().get(input[9] - 1) instanceof Credit) {
									Credit c = (Credit) cstm[input[5] - 1].getWallet().get(input[9] - 1);
									if (c.getLimit() < c.getAmountUsed() + total)
										throw new NotEnoughBalanceException(c.getAmountUsed() + total - c.getLimit());
								} else if (cstm[input[5] - 1].getWallet().get(input[9] - 1) instanceof Cash) {
									Cash c1 = (Cash) cstm[input[5] - 1].getWallet().get(input[9] - 1);
									if (c1.getAmount() < total)
										throw new NotEnoughBalanceException(total - c1.getAmount());
								}
								break;
							} catch (NotEnoughBalanceException e) {
								System.out.println(e.getMessage());
							} catch (InvalidAccessException e) {
								System.out.println(e.getMessage());
								continue;
							} catch (InputMismatchException e) {
								scan.nextLine();
								System.out.println("Enter number!");
								continue;
							}
						}

						cstm[input[5] - 1].getWallet().get(input[9] - 1).pay(total);

						try {
							outputStream = new PrintWriter(
									new FileOutputStream("Receipt(" + mart.transactionNum + ").txt"));
						} catch (FileNotFoundException e) {
							System.exit(0);
						}

						outputStream.println(current);
						outputStream.printf("%12s%12s%12s%12s\n", "Product name", "Unit price", "Quantity", "Amount");
						outputStream.println("------------------------------------------------");
						for (Product p : cstm[input[5] - 1].getShoppingCart()) {
							int amount = p.getPrice() * p.getQuantity();
							outputStream.printf("%12s%12s%12s%12s\n", p.getName(), p.getPrice(), p.getQuantity(),
									amount);
							total += amount;
						}
						outputStream.println("------------------------------------------------");
						outputStream.printf("%s%37d\n", "Total price", total);
						outputStream.println("------------------------------------------------");
						if (cstm[input[5] - 1].getWallet().get(input[9] - 1) instanceof Credit) {
							Credit c = (Credit) cstm[input[5] - 1].getWallet().get(input[9] - 1);
							outputStream.println("Credit, " + c.getBank());
						} else
							outputStream.println("Cash");

						mart.transactionNum++;
						cstm[input[5] - 1].setShoppingCart(null);

						continue;
					case 4:// Print Wallet
						for (int i = 0; i < cstm[input[5] - 1].getWallet().size(); i++)
							System.out.println((i + 1) + ". " + cstm[input[5] - 1].getWallet().get(i));

						continue;
					}
				} while (input[6] != 0);
				break;
			case 3:// End program
				break;
			}
		}
		scan.close();
		inputStream.close();
		outputStream.close();
	}
}
