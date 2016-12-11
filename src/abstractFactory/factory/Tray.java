package abstractFactory.factory;

import java.util.ArrayList;

/**
 * 複数のLinkやTrayを集めてひとまとめにしたもの
 * @author ict816
 *
 */
public abstract class Tray extends Item{
	protected ArrayList<Item> tray = new ArrayList<>();
	public Tray(String caption) {
		super(caption);
	}
	public void add(Item item) {
		tray.add(item);
	}
}
