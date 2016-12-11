package templateMethod.templateStrategy;

public class ClassB extends Super{

	@Override
	public void doSomethingA() {
		System.out.println("do B A");
	}

	@Override
	public void doSomethingB() {
		System.out.println("do B B");
	}

}
