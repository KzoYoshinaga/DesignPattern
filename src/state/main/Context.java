package state.main;

public interface Context {

	public void setClock(int hour);

	public void changeOperation(HourOperation operation);

	public void callSecurityCenter(String string);

	public void recordLog(String string);

}
