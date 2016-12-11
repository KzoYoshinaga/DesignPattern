package strategy.main;

public class HandElements {
	private Hand hand;
	private int amount;
	public HandElements(Hand hand, int amount) {
		this.hand = hand;
		this.amount = amount;
	}
	public Hand getHand() {
		return hand;
	}
	public int getAmount() {
		return amount;
	}
}
