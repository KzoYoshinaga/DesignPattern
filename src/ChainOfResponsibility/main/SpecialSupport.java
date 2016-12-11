package ChainOfResponsibility.main;

public class SpecialSupport extends Support {

	private int specialSupportedTroubleNumber;

	public SpecialSupport(String name, int supecialSupportedTroubleNumber) {
		super(name);
		this.specialSupportedTroubleNumber = supecialSupportedTroubleNumber;
	}

	@Override
	protected boolean resolve(Trouble trouble) {
		return trouble.getNumber() == specialSupportedTroubleNumber;
	}


}
