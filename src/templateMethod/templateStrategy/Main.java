package templateMethod.templateStrategy;

public class Main {
	public static void main(String[] args) {
		System.out.println("TemplateStrategy");
		new ClassA().doSomething(new Handle());
		new ClassB().doSomething(new Handle());
		new ClassA().doSomething(new HandleExtended());
		new ClassB().doSomething(new HandleExtended());
	}
}
