package templateMethod.templateStrategy;

public class HandleExtended implements Handler{

	@Override
	public void doSomething(Interface handlable) {
		handlable.doSomethingB();
		handlable.doSomethingA();
	}

}
