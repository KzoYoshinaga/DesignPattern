package flyweight.main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class BigString {

	private List<BigChar> bigchars = new ArrayList<>();

	public BigString(String string) {
		BigCharFactory factory = BigCharFactory.getInstance();
		Stream.iterate(0, i->{return i+1;}).limit(string.length()).forEach(i->{
			bigchars.add(factory.getBigChar(string.charAt(i)));});
	}

	public void print() {
		bigchars.stream().forEach(b->b.print());
	}
}
