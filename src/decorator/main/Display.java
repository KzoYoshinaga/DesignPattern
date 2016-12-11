package decorator.main;

/**
 * 複数行からなる文字列を表示するための抽象クラス
 * @author ict816
 *
 */
public abstract class Display {

	/**
	 * １行の文字列長を得
	 * @return
	 */
	public abstract int getColumns();

	/**
	 * 行数を得る
	 * @return
	 */
	public abstract int getRows();

	/**
	 * 指定された行インデックスのテキストを取得
	 * @param rowIndex 行インデックス
	 * @return rowIndexに対応するテキスト
	 */
	public abstract String getRowText(int rowIndex);

	/**
	 * getRows() も getRowText() もサブクラス実装任せなので
	 * 期待する(i行目のテキストを表示)機能は得られないかもしれない
	 * getRowsが正当な行数を返さない場合, getRowText が rowIndex に対応するテキストを返さない場合
	 */
	public final void show() {
		for (int i = 0; i < getRows(); i++) {
			System.out.println(getRowText(i));
		}
	}
}
