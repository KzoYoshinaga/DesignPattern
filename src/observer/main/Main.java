package observer.main;

public class Main {

	public static void main(String...args) {

		boolean useFunctionalImplementation = true;

		NumberGenerator generator = new ContinuousNumberGenerator(0);

		int times = 20;

		if (useFunctionalImplementation == true)
			functionalImplementation(generator, times);
		else
			classImplementation(generator, times);

	}

	/**
	 * Observerをクラスオブジェクトとして実装
	 */
	private static void classImplementation(NumberGenerator generator, int times) {
		generator.addObserver(new DigitObserver());
		generator.addObserver(new GraphObserver());
		generator.execute(times);
	}

	/**
	 * コンストラクタを持たない実装ならばインターフェイスの中でスタティックオブジェクトとして保持できる
	 */
	private static void functionalImplementation(NumberGenerator generator, int times) {
		generator.addObserver(Observer.DisitObserver);
		generator.addObserver(Observer.GraphObserver);
		generator.execute(times);
	}
}
