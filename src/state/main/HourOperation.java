package state.main;

public interface HourOperation {

	public void doWhenSettingClock(Context context, int hour);

	public void doWhenUsingSafe(Context context);

	public void doWhenUsingAlarm(Context context);

	public void doWhenUsingPhone(Context context);
}
