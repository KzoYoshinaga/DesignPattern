package observer.main;

import java.util.stream.Stream;

public interface Observer {

	public abstract void update(NumberGenerator generator);

	/**
	 * コンストラクタを持たない実装(オブジェクトに個性がない)ならばスタティックオブジェクトとして保持できる
	 */
	public static Observer DisitObserver  = new Observer() {
		@Override
		public void update(NumberGenerator generator) {
			System.out.println("DigitObserver: " + generator.getValue());
			try { Thread.sleep(100); } catch (InterruptedException e) {}
		}
	};

	public static Observer GraphObserver = new Observer() {
		@Override
		public void update(NumberGenerator generator) {
			System.out.print("GraphObserver: ");
			Stream.iterate(0, i -> {return i + 1;}).limit(generator.getValue()).forEach(n -> System.out.print("*"));
			System.out.println();
			try { Thread.sleep(100); } catch (InterruptedException e) {}
		}
	};


}
