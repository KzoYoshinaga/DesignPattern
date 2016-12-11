package bridge.main;

import bridge.util.Util;

public class StringDisplayImplementor extends DisplayImplementor{

	// 表示文字列
	private String string;

	// バイト単位で計算した文字列の幅
	private int byteLength;

	public StringDisplayImplementor(String string) {
		this.string = string;
		this.byteLength = string.getBytes().length;
	}

	@Override
	public void rawOpen() {
		printLine();
	}

	@Override
	public void rawPrint() {
		System.out.println("|" + string + "|");
	}

	@Override
	public void rawClose() {
		printLine();
	}

	private void printLine() {
		System.out.print("+");
		Util.repeat(byteLength, () -> {System.out.print("-");});
		System.out.println("+");
	}


}
