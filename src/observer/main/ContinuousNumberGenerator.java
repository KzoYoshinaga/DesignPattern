package observer.main;

import java.util.stream.Stream;

/**
 * 連続する数字を生成しその度にオブサーバーに通知する
 * @author ict816
 *
 */
public class ContinuousNumberGenerator extends NumberGenerator {

	private int start;
	private int number;

	public ContinuousNumberGenerator(int start) {
		this.start = start;
	}

	@Override
	public int getValue() {
		return number;
	}

	@Override
	public void execute(int times) {
		Stream.iterate(start, i -> {return i + 1;}).limit(times).forEach(i -> {
			this.number = i;
			this.notifyObservers();});
		this.number = start;
	}

}
