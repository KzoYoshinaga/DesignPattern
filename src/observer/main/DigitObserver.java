package observer.main;

/**
 * 数字をそのままプリントするオブサーバー
 * @author ict816
 *
 */
public class DigitObserver extends NumberObserver {
	@Override
	public void update(NumberGenerator generator) {
		System.out.println("DigitObserver: " + super.getNumberFrom(generator));
		try { Thread.sleep(100); } catch (InterruptedException e) {}
	}
}
