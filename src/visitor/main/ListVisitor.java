package visitor.main;

public class ListVisitor extends Visitor {

	private String currentDirectory = "";

	@Override
	public void visit(File file) {
		System.out.println(currentDirectory + "/" + file);
	}

	@Override
	public void visit(Directory directory) {

		System.out.println(currentDirectory + "/" + directory);

		String tmp = currentDirectory;

		currentDirectory = currentDirectory + "/" + directory.getName();

		directory.getStream().forEach(e -> e.accept(this));

		currentDirectory = tmp;
	}

}
