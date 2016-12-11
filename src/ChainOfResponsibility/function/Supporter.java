package ChainOfResponsibility.function;

import java.util.function.BiPredicate;

public enum Supporter {
	alice(SupportFunction.NoSupport, 0),
	bob(SupportFunction.LimitSupport, 100),
	charlie(SupportFunction.SupecialSupport, 429),
	dianna(SupportFunction.LimitSupport, 200),
	elmo(SupportFunction.NoSupport, 0),
	fred(SupportFunction.OddSupport, 0);
	private BiPredicate<Integer, Integer> pred;
	private int num;
	private Supporter(BiPredicate<Integer, Integer> pred, int num) {
		this.pred = pred;
		this.num = num;
	}
	public boolean apply(int troubleNum) {
		return pred.test(troubleNum, this.num);
	}
}
