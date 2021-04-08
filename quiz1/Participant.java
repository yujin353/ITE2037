package quiz1;

import java.util.Random;

public class Participant {
	private String name;
	private Card card;
	private int point;
	
	public Participant(String name) {
		this.name = name;
		Random rnd = new Random();
		int s = rnd.nextInt(4);		
		int n = rnd.nextInt(13)+1;
		Card c = new Card(s, n);
		this.card = c;
		this.point = 0;
	}

	public String getName() { return this.name; }
	public void setName(String name) { this.name = name; }
	public Card getCard() {return this.card; }
	public void setCard(Card card) { this.card.setNumber(card.getNumber()); this.card.setSymbol(card.getSymbol());}/////?
	public int getPoint() { return this.point; }
	public void setPoint(int point) { this.point = point; }
	
	public void addPoint(int point) {
		this.point += point;
	}
	public void changeCard() {
		Random rnd = new Random();
		int s = rnd.nextInt(4);		
		int n = rnd.nextInt(13)+1;
		Card c = new Card(s, n);
		this.card = c;
	}
	public String toString() {
		switch(this.card.getSymbol()) {
		case 0:
			return this.name + " has Clubs, " + this.card.getNumber() + "(point: " + this.point + ")";
		case 1:
			return this.name + " has Diamonds, " + this.card.getNumber() + "(point: " + this.point + ")";
		case 2:
			return this.name + " has Hearts, " + this.card.getNumber() + "(point: " + this.point + ")";
		case 3:
			return this.name + " has Spades, " + this.card.getNumber() + "(point: " + this.point + ")";
		default:
			return null;
		}
	}
}
