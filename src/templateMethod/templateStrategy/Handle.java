package templateMethod.templateStrategy;

public class Handle implements Handler{

	@Override
	public void doSomething(Interface handlable) {
		handlable.doSomethingA();
		handlable.doSomethingB();
	}

}
