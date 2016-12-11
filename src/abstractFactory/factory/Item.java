package abstractFactory.factory;

/**
 * 項目は見出しを持つ
 * 項目はHTMLを作成することが出来る
 * @author ict816
 *
 */
public abstract class Item {
	protected String caption;
	public Item(String caption) {
		this.caption = caption;
	}
	public abstract String makeHTML();
}
