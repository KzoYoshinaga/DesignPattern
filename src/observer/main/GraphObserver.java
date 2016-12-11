package observer.main;

import java.util.stream.Stream;

/**
 * 数字を"*"のヒストグラムで表示するオブサーバー
 * @author ict816
 *
 */
public class GraphObserver extends NumberObserver {
	@Override
	public void update(NumberGenerator generator) {
		System.out.print("GraphObserver: ");
		Stream.iterate(0, i -> {return i + 1;}).limit(super.getNumberFrom(generator)).forEach(n -> System.out.print("*"));
		System.out.println();
		try { Thread.sleep(100); } catch (InterruptedException e) {}
	}
}
