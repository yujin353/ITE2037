package quiz2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortCard {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int len = 0;

		try {
			System.out.print("Enter the length of array: ");
			len = scan.nextInt();
			if (len <= 0)
				throw new BadNumberException();
		} catch (BadNumberException e) {
			System.out.println(e.getMessage() + ", " + len + " cannot be used");
			System.out.print("Enter the length of array: ");
			len = scan.nextInt();
		}
		System.out.println("------------------------------");

		Card[] cardArray = new Card[len];
		Random rand = new Random();
		for (int i = 0; i < len; i++) {
			cardArray[i] = new Card(rand.nextInt(4), rand.nextInt(13) + 1);
			System.out.println(cardArray[i]);
		}

		System.out.println("------------------------------");
		Arrays.sort(cardArray);
		for (Card c : cardArray)
			System.out.println(c);
		System.out.println("------------------------------");

		ArrayList<Card> cList = new ArrayList<Card>();
		System.out.print("Enter the number to increase: ");
		int increase = scan.nextInt();

		for (Card c : cardArray)
			cList.add(c);
		for (int i = 0; i < increase; i++) {
			Card card = new Card(rand.nextInt(4), rand.nextInt(13) + 1);
			for (int j = 0; j < cList.size(); j++)
				if (card.compareTo(cList.get(j)) == -1 || card.compareTo(cList.get(j)) == 0) {
					cList.add(j, card);
					break;
				}
		}
		System.out.println("------------------------------");
		for (Card c : cList)
			System.out.println(c);

		scan.close();
	}

}
