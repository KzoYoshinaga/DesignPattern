package decorator.main;

public class SideBorder extends Border{

	private char borderChar;

	public SideBorder(Display display, char c) {
		super(display);
		this.borderChar = c;
	}

	@Override
	public int getColumns() {
		return 1 + display.getColumns() + 1;
	}

	@Override
	public int getRows() {
		return display.getRows();
	}

	@Override
	public String getRowText(int rowIndex) {
		return borderChar + display.getRowText(rowIndex) + borderChar;
	}

}
