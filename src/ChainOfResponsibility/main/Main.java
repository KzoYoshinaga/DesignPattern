package ChainOfResponsibility.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import ChainOfResponsibility.function.Supporter;

public class Main {
	public static void main(String[] args) {
		
		int loop = 100000;
		
		Support alice = new NoSupport("Alice");
		Support bob = new LimitSupport("Bob", 100);
		Support charlie = new SpecialSupport("Charlie", 429);
		Support diana = new LimitSupport("Diana", 200);
		Support elmo = new OddSupport("Elmo");
		Support fred = new LimitSupport("Fred", 300);
		alice.setNext(bob).setNext(charlie).setNext(diana).setNext(elmo).setNext(fred);

		List<Support> list = new ArrayList<>(Arrays.asList(
				new Support[]{alice, bob, charlie, diana, elmo, fred}));

		List<Supporter> supporters =  Arrays.asList(Supporter.values());

		long start = System.currentTimeMillis();

		/**
		 * Stack
		 */
		for (int i = 0; i < loop; i++)
			alice.support(new Trouble(i));

		long method1 = System.currentTimeMillis();

		/**
		 * Stream
		 */
		for (int i = 0; i < loop; i++) {
			Trouble t = new Trouble(i);
			// findFirst() によりpredicatorで始めてヒットしたresolverのみresolve() が実行される
			Optional<Support> resolver = list.stream().filter(s -> {return s.resolve(t);}).findFirst();
			if (resolver.isPresent()) System.out.println(resolver.get() + " resolved ****************");
			else System.out.println("cant resolve");
		}

		long method2 = System.currentTimeMillis();

		/*
		 * enum + Stream
		 */
		for (int i = 0; i < loop; i++) {
			int n = new Trouble(i).getNumber();
			Optional<Supporter> resolver = supporters.stream().filter(s -> s.apply(n)).findFirst();
			if (resolver.isPresent()) System.out.println(resolver.get() + " resolved");
			else System.out.println("cant resolve");
		}

		long method3 = System.currentTimeMillis();


		System.out.println("Stack : " + (method1 - start)   + "ms"); // 7ms
		System.out.println("Heap  : " + (method2 - method1) + "ms"); // 9ms
		System.out.println("Heap  : " + (method3 - method2) + "ms"); // 6ms
	}
}
