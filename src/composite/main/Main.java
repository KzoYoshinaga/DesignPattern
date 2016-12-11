package composite.main;

public class Main {

	/**
	 * loop = 300
	 * ArrayList.forEach 78ms
	 * Stream.forEach 49ms
	 * @param args
	 */

	public static void main(String[] args) {
		try {

			int loop = 300;

			long start = System.currentTimeMillis();

			for (int i = 0; i < loop; i++ )
				byList();

			long t1 = System.currentTimeMillis();

			for (int i = 0; i < loop; i++ )
				byStream();

			long t2 = System.currentTimeMillis();

			System.out.println("byList: " + (t1 - start) + "ms");
			System.out.println("byStream: " + (t2 - t1) + "ms");

		} catch(FileTreatmentException e) {
			e.printStackTrace();
		}
	}

	private static void byList() throws FileTreatmentException {
		System.out.println("Making root entries...");

		Directory rootdir = new Directory("root");
		Directory bindir = new Directory("bin");
		Directory tmpdir = new Directory("tmp");
		Directory usrdir = new Directory("usr");

		rootdir.add(bindir);
		rootdir.add(tmpdir);
		rootdir.add(usrdir);

		bindir.add(new File("vi", 10000));
		bindir.add(new File("latex", 20000));

		rootdir.printList();

		System.out.println();

		System.out.println("Making user entries...");

		Directory yuki = new Directory("yuki");
		Directory hanako = new Directory("hanako");
		Directory tomura = new Directory("tomura");

		usrdir.add(yuki);
		usrdir.add(hanako);
		usrdir.add(tomura);

		yuki.add(new File("diary.html", 100));
		yuki.add(new File("Composite.java", 200));
		hanako.add(new File("memo.txt", 300));
		tomura.add(new File("game.doc", 400));
		tomura.add(new File("junk.mail", 500));

		rootdir.printList();
	}

	private static void byStream() throws FileTreatmentException {
		System.out.println("Making root entries...");

		StreamDirectory rootdir = new StreamDirectory("root");
		StreamDirectory bindir = new StreamDirectory("bin");
		StreamDirectory tmpdir = new StreamDirectory("tmp");
		StreamDirectory usrdir = new StreamDirectory("usr");

		rootdir.add(bindir);
		rootdir.add(tmpdir);
		rootdir.add(usrdir);

		bindir.add(new File("vi", 10000));
		bindir.add(new File("latex", 20000));

		rootdir.printList();

		System.out.println();

		System.out.println("Making user entries...");

		StreamDirectory yuki = new StreamDirectory("yuki");
		StreamDirectory hanako = new StreamDirectory("hanako");
		StreamDirectory tomura = new StreamDirectory("tomura");

		usrdir.add(yuki);
		usrdir.add(hanako);
		usrdir.add(tomura);

		yuki.add(new File("diary.html", 100));
		yuki.add(new File("Composite.java", 200));
		hanako.add(new File("memo.txt", 300));
		tomura.add(new File("game.doc", 400));
		tomura.add(new File("junk.mail", 500));

		rootdir.printList();
	}
}
