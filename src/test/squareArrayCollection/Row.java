package test.squareArrayCollection;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ２次元配列の行を抽象化
 * @author ict816
 *
 */
public class Row<T> {

	private List<T> elements;

	public Row(int rowSize, T initialElement) {
		elements = Arrays.asList(new Object[rowSize]).stream().map(t -> initialElement).collect(Collectors.toList());
	}

	public String toString(String delimiter) {
		return elements.stream().map(e -> e.toString()).collect(Collectors.joining(delimiter));
	}
}
