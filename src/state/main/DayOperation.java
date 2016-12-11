package state.main;

public class DayOperation implements HourOperation {

	private static DayOperation singleton = new DayOperation();

	private DayOperation() {}

	public static HourOperation getInstance() {
		return singleton;
	}

	@Override
	public void doWhenSettingClock(Context context, int hour) {
		int current = Math.abs(hour % 24);
		if (current < 9 || current >= 17)
			context.changeOperation(NightOperation.getInstance());

	}

	@Override
	public void doWhenUsingSafe(Context context) {
		context.recordLog("金庫使用(昼間)");
	}

	@Override
	public void doWhenUsingAlarm(Context context) {
		context.callSecurityCenter("非常ベル(昼間)");
	}

	@Override
	public void doWhenUsingPhone(Context context) {
		context.callSecurityCenter("通常の通話(昼間)");
	}

	public String toString() {
		return "[昼間]";
	}



}
