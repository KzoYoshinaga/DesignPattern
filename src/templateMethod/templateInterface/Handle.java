package templateMethod.templateInterface;

public class Handle implements Handler{
	public void doSomething(Interface handlable) {
		handlable.doSomethingA();
		handlable.doSomethingB();
	}
}
