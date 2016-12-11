package composite.main;

/**
 * ファイルを表す具象クラス
 * @author ict816
 *
 */
public class File extends Entry {

	public String name;

	private int size;

	public File(String name, int size) {
		this.name = name;
		this.size = size;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	protected void printList(String prefix) {
		System.out.println(prefix + "/" + this);
	}
}
