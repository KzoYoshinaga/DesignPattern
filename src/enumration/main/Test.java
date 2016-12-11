package enumration.main;

public enum Test {
	Tanaka("田中"),
	Sato("佐藤");
	private String name;
	private Test(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

}
