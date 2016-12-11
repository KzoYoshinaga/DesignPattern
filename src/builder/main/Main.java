package builder.main;

/**
 * 実に気持ちが悪い
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
			Director director = new Director(builder);
			director.constract();
			String result = builder.getResult();
			System.out.println(result);
		} else if (args[0].equals("html")) {
			HTMLBuilder builder = new HTMLBuilder();
			Director director = new Director(builder);
			director.constract();
			String filename = builder.getResult();
			System.out.println(filename + "が作成されました");
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
