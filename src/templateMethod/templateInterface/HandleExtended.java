package templateMethod.templateInterface;

// 処理フローの違いはハンドラの責任になる
public class HandleExtended implements Handler{
	public void doSomething(Interface handlable) {
		handlable.doSomethingB();
		handlable.doSomethingB();
	}
}
