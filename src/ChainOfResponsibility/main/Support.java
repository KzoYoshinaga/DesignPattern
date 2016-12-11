package ChainOfResponsibility.main;

public abstract class Support {

	private String name;

	private Support nextSupport;

	public Support(String name) {
		this.name = name;
	}

	/**
	 * 次の依頼先を設定
	 * クエリとコマンドが一体となっている
	 * @param nextSupport
	 * @return
	 */
	public Support setNext(Support nextSupport) {
		this.nextSupport = nextSupport;
		return nextSupport;
	}

	public final void support(Trouble trouble) {
		if (resolve(trouble) == true) {
			done(trouble);
		} else if (nextSupport != null) {
			nextSupport.support(trouble);
		} else {
			fail(trouble);
		}
	}

	public String toString() {
		return "[" + name + "]";
	}

	/**
	 * コマンドとクエリの一体化
	 * @param trouble
	 * @return
	 */
	protected abstract boolean resolve(Trouble trouble);

	protected void done(Trouble trouble) {
		System.out.println(trouble + " is resolved by " + this + ".");
	}

	protected void fail(Trouble trouble) {
		System.out.println(trouble + " cannot be resolved.");
	}
}
