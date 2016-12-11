package builder.alterBuilder;

public class Direction {
	public void constract(Buildable builder) {
		builder.makeTitle("Greeting");
		builder.makeString("朝から昼にかけて");
		builder.makeItems(new String[]{
				"おはようございます",
				"こんにちは"});
		builder.makeString("夜に");
		builder.makeItems(new String[]{
				"こんばんは",
				"おやすみなさい",
				"さようなら"});
		builder.close();
	}
}
