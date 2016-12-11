package templateMethod.template;

public class SubA extends Super{

	@Override
	protected void doSomethingA() {
		System.out.println("do A A");
	}

	@Override
	protected void doSomethingB() {
		System.out.println("do A B");
	}

}
