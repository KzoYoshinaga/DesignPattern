package facade.pagemaker;

import java.io.IOException;
import java.io.Writer;

public class HTMLWriter {

	private Writer writer;

	public HTMLWriter(Writer writer) {
		this.writer = writer;
	}

	public void writeTitle(String title) throws IOException {
		writer.write("<html>");
		writer.write("<head>");
		writer.write("<title>" + title + "</title>");
		writer.write("</head>");
		writer.write("<body>\n");
		writer.write("<h1>" + title + "</h>");
	}

	public void writeParagraph(String message) throws IOException {
		writer.write("<p>" + message + "</p>\n");
	}

	public void writeLink(String href, String caption) throws IOException {
		writeParagraph("<a href=\"" + href + "\">"+ caption + "</a>");
	}

	public void writeMailto(String mailAddress, String userName) throws IOException {
		writeLink("mailto:" + mailAddress, userName);
	}

	public void close() throws IOException {
		writer.write("</body>");
		writer.write("</html>\n");
		writer.close();
	}
}
