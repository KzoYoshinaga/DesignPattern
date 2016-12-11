package templateMethod.templateStrategy;

public abstract class Super implements Interface{
	public void doSomething(Handler handler) {
		handler.doSomething(this);
	}
}
