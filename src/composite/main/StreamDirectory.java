package composite.main;

import java.util.ArrayList;

public class StreamDirectory extends Entry {
	private String name;

	private ArrayList<Entry> directory = new ArrayList<>();

	public StreamDirectory(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getSize() {
		return directory.stream().mapToInt(e -> e.getSize()).sum();
	}

	@Override
	public Entry add(Entry entry) {
		directory.add(entry);
		return this;
	}

	@Override
	protected void printList(String prefix) {
		System.out.println(prefix + "/" + this);
		directory.stream().forEach(e -> e.printList(prefix + "/" + name));
	}
}
