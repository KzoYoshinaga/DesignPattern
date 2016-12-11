package bridge.main;

import bridge.util.Util;

/**
 * Displayの機能拡張
 * @author ict816
 *
 */
public class CountDisplay extends Display {

	public CountDisplay(DisplayImplementor implementor) {
		super(implementor);
	}

	public void multiDisplay(int times) {
		open();
		Util.repeat(times, () -> {this.print();});
		close();
	}

}
