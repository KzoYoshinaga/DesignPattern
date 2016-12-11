package observer.main;

import java.util.Random;
import java.util.stream.Stream;

/**
 * 一様分布の乱数を生成しその度にオブサーバーに通知する
 * @author ict816
 *
 */
public class RandomNumberGenerator extends NumberGenerator {

	private Random random;
	private int number;
	private int limit;

	/**
	 * コンストラクタ
	 * @param seed ランダム生成のシード値
	 * @param limit 上限数値 0から limt-1 までの整数がランダム生成される
	 */
	public RandomNumberGenerator(int seed, int limit) {
		this.random = new Random(seed);
		this.limit = limit;
	}

	/**
	 * 現在保持しているランダム数値を返す
	 */
	@Override
	public int getValue() {
		return number;
	}

	@Override
	public void execute(int times) {
		Stream.iterate(0, i -> {return i + 1;}).limit(times).forEach(i -> {
			this.number = random.nextInt(this.limit);
			this.notifyObservers();});
	}

}
