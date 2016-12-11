package ChainOfResponsibility.function;

import java.util.function.BiPredicate;

public class SupportFunction {
	public static BiPredicate<Integer, Integer> NoSupport = (n, s) -> {return false;};
	public static BiPredicate<Integer, Integer> LimitSupport = (n, s) -> {return n < s;};
	public static BiPredicate<Integer, Integer> OddSupport = (n, s) -> {return n % 2 == 1;};
	public static BiPredicate<Integer, Integer> SupecialSupport = (n, s) -> {return n == s;};
}
