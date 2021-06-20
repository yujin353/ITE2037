package assignment3;

import java.time.LocalDateTime;

public class Food extends Product {
	private LocalDateTime expirationDateTime; // 유통기한

	public boolean isExpired(LocalDateTime present) {
		return expirationDateTime.isBefore(present);
	}

	public Food(String name, int price, int quantity, LocalDateTime t) {
		super(name, price, quantity);
		this.expirationDateTime = t;
	}

	public LocalDateTime getExp() {
		return this.expirationDateTime;
	}

	public void extendExp(LocalDateTime t1, int t2) {
		this.expirationDateTime = t1.plusDays(t2);
	}
}
