package templateMethod.templateInterface;

public class ClassB implements Interface{

	@Override
	public void doSomethingA() {
		System.out.println("do B A");
	}

	@Override
	public void doSomethingB() {
		System.out.println("do B B");
	}

}
