package memento.game;

public enum Fruits {
	TastyApple("りんご", true),
	TastyGrape("ぶどう", true),
	TastyBanana("バナナ", true),
	TastyOrange("みかん", true),
	Apple("りんご", false),
	Grape("ぶどう", false),
	Banana("バナナ", false),
	Orange("みかん", false);
	private String name;
	private boolean isTasty;
	private Fruits(String name, boolean isTasty) {
		this.name = name;
		this.isTasty = isTasty;
	}
	public String getName() {
		return name;
	}
	public boolean isTasty() {
		return isTasty;
	}
	public String toString() {
		return (isTasty ? "おいしい" : "" ) + name;
	}
}
