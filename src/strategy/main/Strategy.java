package strategy.main;

/**
 * 次の手を決める戦略の抽象メソッドをまとめたインターフェイス
 * @author ict816
 *
 */
public interface Strategy {

	/**
	 * 次の手を返す
	 * @return 次の手を表すenum Hand
	 */
	public abstract Hand nexHand();

	/*
	 * 今回の勝負手を渡す
	 */
	public abstract void setHand(Hand hand);

	/**
	 * 今回の勝負結果を学習用に渡す
	 * @param result
	 */
	public abstract void study(Result result);
}
