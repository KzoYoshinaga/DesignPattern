package builder.alterBuilder;

/**
 * ビルダーにディレクションを渡して組み立てる
 * テキストのビルドとファイル出力は分けるべき
 *
 * 組み立てるクラス
 * Buildable -> Builder -> ConcreteBuilder.construct(Direction)
 *
 * 組み立てつつ出力するクラス
 * Buildable -> BuildStreamWriter(Output) -> ConcreteBuildStreamWriter.print(Direction)
 *
 * @author ict816
 *
 */
public class Main {
	public static void main(String[] args) {
		if (args.length != 1) {
			usage();
			System.exit(0);
		}
		if (args[0].equals("plain")) {
			TextBuilder builder = new TextBuilder();
			builder.construct(new Direction());   // ビルダ内部でテキストが組み立てられるだけ
			System.out.println(builder.getResult());
		} else if (args[0].equals("html")) {
			HTMLBuilder builder = new HTMLBuilder();
			builder.construct(new Direction());   // HTMLファイルが出力される 副作用が予想できない
			System.out.println(builder.getResult() + "が作成されました");
		} else {
			usage();
			System.exit(0);
		}
	}

	private static void usage() {
		System.out.println("Usage: java Main plain");
		System.out.println("Usage: java Main html");
	}
}
