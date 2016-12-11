package strategy.main;

public class Player {

	private String name;

	private Strategy strategy;

	private ResultCounter counter;

	public Player(String name, Strategy strategy) {
		this.name = name;
		this.strategy = strategy;
		counter = new ResultCounter();
	}

	public Hand nextHand() {return strategy.nexHand();}

	public void battle(Hand hand, Hand foeHand) {
		Result result = hand.battle(foeHand);
		counter.setResult(result);

		// 戦略の関心は自手のみ
		// 拡張可能性(hand, foeHand, Result)を渡す？
		strategy.setHand(hand);
		strategy.study(result);
	}

	public String toString() {
		return "[" + name +": " + counter.toString() + "]";
	}
}
