package ChainOfResponsibility.main;

public class LimitSupport extends Support {

	private int supportedTroubleNumberLimit;

	public LimitSupport(String name, int supportedTroubleNumberLimit) {
		super(name);
		this.supportedTroubleNumberLimit = supportedTroubleNumberLimit;
	}

	@Override
	protected boolean resolve(Trouble trouble) {
		return trouble.getNumber() < supportedTroubleNumberLimit;
	}

}
