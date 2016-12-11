package bridge.main;

/**
 * 実装の階層トップであるImplementorの機能を呼び出すことで
 * クライアントに基本的な機能を提供している
 * @author ict816
 *
 */
public class Display {

	private DisplayImplementor implementor;

	public Display(DisplayImplementor implementor) {
		this.implementor = implementor;
	}

	public void open() {
		implementor.rawOpen();
	}

	public void print() {
		implementor.rawPrint();
	}

	public void close() {
		implementor.rawClose();
	}

	public final void display() {
		open();
		print();
		close();
	}

}
