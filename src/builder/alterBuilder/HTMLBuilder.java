package builder.alterBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class HTMLBuilder extends Builder{

	private String filename;

	private PrintWriter writer;

	@Override
	public void makeTitle(String title) {
		filename = title + ".html";
		try {
			writer = new PrintWriter(new FileWriter(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
		writer.println("<html><head><title>" + title + "</title></head><body>");
		writer.println("<h1>" + title + "</h1>");
	}

	@Override
	public void makeString(String s) {
		writer.println("<p>" + s  + "</p>");
	}

	@Override
	public void makeItems(String[] items) {
		writer.println("<ul>");
		Arrays.asList(items).forEach(item -> writer.println("<li>" + item + "<li>"));
		writer.println("</ul>");
	}

	@Override
	public void close() {
		writer.println("</body></html>");
		writer.close();
	}

	public String getResult() {
		return filename;
	}

}
