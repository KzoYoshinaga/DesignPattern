package enumration.main;

import java.util.Enumeration;
import java.util.List;

/**
 * 実装してみる
 * @author ict816
 *
 * @param <T>
 */
public class TestEnumeration<T> implements Enumeration<T> {

	private List<T> list;

	private int currentIndex = 0;

	private int lastIndex;

	public TestEnumeration(final List<T> list) {
		this.list = list;
		lastIndex = list.size() - 1;
	}

	@Override
	public boolean hasMoreElements() {
		int nextIndex = currentIndex + 1;
		return  nextIndex < lastIndex;
	}

	// 未検査だと最終インデックスでヌルポ
	@Override
	public T nextElement() {
		return list.get(++currentIndex);
	}

}
