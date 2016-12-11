package builder.main;

import java.util.Arrays;

public class TextBuilder extends Builder{

	private StringBuffer buffer = new StringBuffer();

	@Override
	public void makeTitle(String title) {
		buffer.append("===================================\n");
		buffer.append("『"+ title + "』\n");
		buffer.append("\n");
	}

	@Override
	public void makeString(String s) {
		buffer.append('■' + s + "\n");
		buffer.append("\n");
	}

	@Override
	public void makeItems(String[] items) {
		Arrays.asList(items).forEach(item -> buffer.append("   ・" + item + "\n"));
		buffer.append("\n");
	}

	@Override
	public void close() {
		buffer.append("===================================\n");
	}

	public String getResult() {
		return buffer.toString();
	}
}
