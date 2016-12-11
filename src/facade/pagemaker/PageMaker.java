package facade.pagemaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PageMaker {

	private PageMaker() {}

	public static void makeWelcomePage(String mailAddress, String fileName) {
		try {
			Properties mailprop = Database.getProperties("sample");
			String userName = mailprop.getProperty(mailAddress);
			HTMLWriter writer = new HTMLWriter(new FileWriter(fileName));
			writer.writeTitle("Wlcome to "+ userName + "'s page'");
			writer.writeParagraph(userName + "のページへようこそ");
			writer.writeParagraph("property");
			writer.writeMailto(mailAddress, userName);
			writer.close();
			System.out.println(fileName + " is created for " + mailAddress + "(" + userName + ")");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
