package Sstrategy.main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 連続した２手の直行マップの整数値を加算していく
 *
 * @author ict816
 *
 */
public class History {

	/**
	 * マップの最低値
	 */
	private static final int BASE_VALUE = 1;

	/**
	 * 連続２手の直行マップ
	 * 勝ち数＋１の値を保持
	 */
	private HashMap<Hand, HashMap<Hand, Integer>> history;

	/**
	 * コンストラクタ
	 */
	public History() {
		history = new HashMap<>();
	}

	/**
	 * 連続手を格納
	 * @param previousHand 前回勝負手
	 * @param currentHand 今回勝負手
	 */
	public void addHistory(Hand previousHand, Hand currentHand) {
		if (history.containsKey(previousHand) == false)
			history.put(previousHand, new HashMap<>());

		HashMap<Hand, Integer> temp = history.get(previousHand);

		if(temp.containsKey(currentHand) == false)
			temp.put(currentHand, BASE_VALUE);

		temp.put(currentHand, temp.get(currentHand) + BASE_VALUE);
	}

	/**
	 * 前回手をキー
	 * @param previousHand
	 * @return
	 */
	public List<HandElements> getHandElementsList(Hand previousHand) {
		if (history.containsKey(previousHand) == false)
			return Arrays.asList(Hand.values()).stream().map(hand -> new HandElements(hand, BASE_VALUE)).collect(Collectors.toList());

		return Arrays.asList(Hand.values()).stream().map(hand -> getFunc(history.get(previousHand)).apply(hand)).collect(Collectors.toList());
	}

	private Function<Hand, HandElements> getFunc(HashMap<Hand, Integer> temp) {
		return new Function<Hand, HandElements>(){
			@Override
			public HandElements apply(Hand hand) {
				if (temp.containsKey(hand) == false) {
					return new HandElements(hand, BASE_VALUE);
				}
				return new HandElements(hand, temp.get(hand));
			}
		};
	}

}
