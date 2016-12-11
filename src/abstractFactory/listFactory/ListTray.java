package abstractFactory.listFactory;

import abstractFactory.factory.Item;
import abstractFactory.factory.Tray;

public class ListTray extends Tray {

	public ListTray(String caption) {
		super(caption);
	}
	/**
	 * Tray は 所持する trayリストに格納されたアイテムからHTMLを作成
	 * @return
	 */
	@Override
	public String makeHTML() {
		StringBuilder builder = new StringBuilder();
		builder.append("<li>\n");
		builder.append(caption + "\n");
		builder.append("<ul>\n");
		tray.forEach(item -> builder.append(((Item)item).makeHTML()));
		builder.append("</ul>\n");
		builder.append("</li>\n");
		return builder.toString();
	}

}
