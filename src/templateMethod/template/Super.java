package templateMethod.template;

public abstract class Super {
	protected abstract void doSomethingA();
	protected abstract void doSomethingB();
	public void doSomething() {
		doSomethingA();
		doSomethingB();
	}

	// 処理フローの違いはクラス自身の責任になる
	public void doSomethingExtended() {
		doSomethingB();
		doSomethingA();
	}
}
