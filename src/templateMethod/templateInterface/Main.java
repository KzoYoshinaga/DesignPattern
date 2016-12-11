package templateMethod.templateInterface;

public class Main {
	public static void main(String[] args) {
		System.out.println("TemplateInterface");
		new Handle().doSomething(new ClassA());
		new Handle().doSomething(new ClassB());
		new HandleExtended().doSomething(new ClassA());
		new HandleExtended().doSomething(new ClassB());
	}
}
