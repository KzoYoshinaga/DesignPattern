package visitor.main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Directory extends Entry {

	private String name;

	private List<Entry> directory = new ArrayList<>();

	public Directory(String name) {
		this.name = name;
	}

	@Override
	public String getName() { return name; }

	@Override
	public int getSize() {
		return getStream().mapToInt(d -> d.getSize()).sum();
	}

	@Override
	public Entry add(Entry entry) {
		directory.add(entry);
		return this;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	public Stream<Entry> getStream() {
		return directory.stream();
	}
}
