package abstractFactory.listFactory;

import abstractFactory.factory.Item;
import abstractFactory.factory.Page;

public class ListPage extends Page {

	public ListPage(String title, String author) {
		super(title, author);
	}

	@Override
	public String makeHTML() {
		StringBuilder builder = new StringBuilder();
		builder.append("<html><head><title>" + title + "</title></head>\n");
		builder.append("<body>\n");
		builder.append("<h1>" + title + "</h1>\n");
		builder.append("<ul>\n");
		content.forEach(item -> builder.append(((Item)item).makeHTML()));
		builder.append("</ul>\n");
		builder.append("<hr><address>" + author + "</address>\n");
		builder.append("</body></html>");
		return builder.toString();
	}

}
