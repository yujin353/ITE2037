package quiz1;
import java.util.Scanner;

public class CardGame {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Player Name: ");
		String name = scan.next();
		
		Participant participant = new Participant(name);
		Participant dealer = new Participant("Dealer");
		
		for(int i = 0; i < 3; i++) {
			System.out.println("------------------------------------");
			System.out.println(dealer.toString());
			System.out.println(participant.toString());
			
			int point = Card.compareCard(dealer.getCard(), participant.getCard());
			
			if (point == 1)
				participant.addPoint(1);
			
			participant.setCard(dealer.getCard());
			dealer.changeCard();
			
		}
		System.out.println("------------------------------------");
		System.out.println(participant.getName() + ", " + participant.getPoint() + " points");

	}

}
