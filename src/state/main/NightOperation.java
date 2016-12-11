package state.main;

public class NightOperation implements HourOperation{

	private static NightOperation singleton = new NightOperation();

	private NightOperation() {}

	public static HourOperation getInstance() {
		return singleton;
	}

	@Override
	public void doWhenSettingClock(Context context, int hour) {
		int current = Math.abs(hour % 24);
		if (current >= 9 && current < 17)
			context.changeOperation(DayOperation.getInstance());
	}

	@Override
	public void doWhenUsingSafe(Context context) {
		context.callSecurityCenter( "非常: 夜間の金庫使用");
	}

	@Override
	public void doWhenUsingAlarm(Context context) {
		context.callSecurityCenter("非常ベル(夜間)");
	}

	@Override
	public void doWhenUsingPhone(Context context) {
		context.callSecurityCenter("夜間の通話録音");
	}

	public String toString() {
		return "[夜間]";
	}


}
