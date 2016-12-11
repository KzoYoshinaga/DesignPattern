package templateMethod.template;

public class SubB extends Super{

	@Override
	protected void doSomethingA() {
		System.out.println("do B A");
	}

	@Override
	protected void doSomethingB() {
		System.out.println("do B B");
	}

}
