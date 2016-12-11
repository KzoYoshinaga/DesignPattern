package state.main;

import java.util.stream.Stream;

public class Main {

	public static void main(String...args) {
		SafeFrame frame = new SafeFrame("State Sample");
		double d = Double.NaN;
		while (d!=d) {
			Stream.iterate(0, i -> {return i + 1;}).limit(24).forEach(i -> {
				frame.setClock(i);
				try { Thread.sleep(3000); } catch (Exception e) {}
			});
		}
	}
}
