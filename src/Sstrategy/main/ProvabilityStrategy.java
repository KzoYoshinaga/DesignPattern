package Sstrategy.main;

public class ProvabilityStrategy implements Strategy{

	private RandomHand randomHand;

	private History history;

	private Hand previousHand;
	private Hand currentHand;

	public ProvabilityStrategy(int seed) {
		this.randomHand = new RandomHand(seed);
		this.history = new History();
		this.previousHand = Hand.values()[0];
		this.currentHand = Hand.values()[0];
	}

	@Override
	public Hand nexHand() {
		return randomHand.getRandomHand(history.getHandElementsList(previousHand));
	}

	@Override
	public void setHand(Hand hand) {
		turnNext(hand);
	}

	@Override
	public void study(Result result) {
		if (result.equals(Result.Win))
			this.history.addHistory(previousHand, currentHand);
	}

	private void turnNext(Hand nextHand) {
		previousHand = currentHand;
		currentHand = nextHand;
	}


}
