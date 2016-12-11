package strategy.main;

public class WinningStrategy implements Strategy {

	private RandomHand randomHand;
	private Hand previousHand = Hand.values()[0];
	private Result result = Result.Lose;

	public WinningStrategy(int seed) {
		this.randomHand = new RandomHand(seed);
	}

	@Override
	public Hand nexHand() {
		if (result.equals(Result.Win) == false) {
			return randomHand.getRandomHand();
		}
		return previousHand;
	}

	@Override
	public void setHand(Hand hand) {
		previousHand = hand;
	}

	@Override
	public void study(Result result) {
		this.result = result;
	}



}
