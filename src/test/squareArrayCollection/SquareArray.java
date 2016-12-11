package test.squareArrayCollection;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
/**
 * 二次元配列のコレクションの一般的な扱いを抽象化する
 * @author ict816
 *
 */
public class SquareArray<T> {

	List<Row<T>> rows;

	public SquareArray(int columnSize, int rowSize, T initialElement){
		rows = Arrays.asList(new Object[columnSize]).stream().map(t -> new Row<T>(rowSize, initialElement)).collect(Collectors.toList());
	}

	public String toString(String columnDelimiter, String rowDelimiter) {
		return rows.stream().map(row -> row.toString(rowDelimiter)).collect(Collectors.joining(columnDelimiter));
	}
}
