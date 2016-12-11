package templateMethod.template;

public class Main {
	public static void main(String[] args) {
		System.out.println("Template");
		new SubA().doSomething();
		new SubB().doSomething();
		new SubA().doSomethingExtended();
		new SubB().doSomethingExtended();
	}
}
