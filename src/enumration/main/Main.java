package enumration.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<String> people = new ArrayList<>(Arrays.asList(new String[]{"a", "b", "c", "d", "e"}));
		Enumeration<String> testEnum = new TestEnumeration<>(people);
		while (testEnum.hasMoreElements()) {
			System.out.println(testEnum.toString());
		}
	}
}
