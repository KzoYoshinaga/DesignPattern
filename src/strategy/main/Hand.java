package strategy.main;

/**
 * 拡張 -> neme, List<Same>, List<Stronger>, List<Weaker> 状態増えた場合
 * @author ict816
 *
 */
public enum Hand {
	Rock("グー", "パー", "チョキ"),
	Scissors("チョキ", "グー", "パー"),
	Paper("パー", "チョキ", "グー");
	private String name;
	private String stronger;
	private String weaker;
	private Hand(String name, String stronger, String weaker) {
		this.name = name;
		this.stronger = stronger;
		this.weaker = weaker;
	}
	public Result battle(Hand foeHand) {
		if (this.stronger.equals(foeHand.name)) return Result.Lose;
		if (this.weaker.equals(foeHand.name)) return Result.Win;
		return Result.Game;
	}

	public String toString() {
		return name;
	}
}
