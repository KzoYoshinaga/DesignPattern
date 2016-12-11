package strategy.main;

import java.util.List;
import java.util.Random;

public class RandomHand {

	private Random random;

	public RandomHand(int seed) {
		this.random = new Random(seed);
	}

	public Hand getRandomHand() {
		Hand[] hands = Hand.values();
		return hands[random.nextInt(hands.length)];
	}

	/**
	 * 抽選個数のリストからランダムに手を選
	 * @param handElementsList // 抽選個数のリスト
	 * @return
	 */
	public Hand getRandomHand(List<HandElements> handElementsList) {
		int totalSize = handElementsList.stream().mapToInt(elements -> elements.getAmount()).sum();
		int randomValue = random.nextInt(totalSize);
		for (int i = 0; i < handElementsList.size(); i++) {
			randomValue -= handElementsList.get(i).getAmount();
			if (randomValue < 0) return handElementsList.get(i).getHand();
		}
		return Hand.values()[0];
	}
}
