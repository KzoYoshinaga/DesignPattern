package bridge.util;

public class Util {
	public static <T> void repeat(int count, Repeatable repeatable) {
		for (int i = 0; i < count; i++)
			repeatable.repeat();
	}
}
