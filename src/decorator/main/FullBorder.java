package decorator.main;

public class FullBorder extends Border {

	public FullBorder(Display display) {
		super(display);
	}

	@Override
	public int getColumns() {
		return 1 + display.getColumns() + 1;
	}

	@Override
	public int getRows() {
		return 1 + display.getRows() + 1;
	}

	@Override
	public String getRowText(int rowIndex) {
		if (rowIndex == 0) return "+" + makeLine('-', display.getColumns()) + "+";
		else if (rowIndex == display.getRows() + 1) return "+"+ makeLine('-', display.getColumns()) + "+";
		else return "|"+ display.getRowText(rowIndex - 1) +"|";
	}

	private String makeLine(char c, int count) {
		StringBuilder buf = new StringBuilder();
		for (int i = 0; i < count; i++)
			buf.append(c);
		return buf.toString();
	}

}
