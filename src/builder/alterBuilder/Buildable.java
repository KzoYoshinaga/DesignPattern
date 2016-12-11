package builder.alterBuilder;

public interface Buildable {
	public void makeTitle(String title);
	public void makeString(String s);
	public void makeItems(String[] items);
	public void close();
}
