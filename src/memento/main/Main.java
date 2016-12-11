package memento.main;

import java.util.stream.Stream;

import memento.game.Gamer;
import memento.game.Memento;

public class Main {

	public static void main(String...args) {
		new Main().start();
	}

	private Memento memento;

	private void start() {
		int money = 400;
		Gamer gamer = new Gamer(money);
		memento = gamer.createMemento();

		int gameTimes = 100;
		Stream.iterate(0, i -> {return i + 1;}).limit(gameTimes).forEach(i -> {
			System.out.println("==== game count : " + i + " ====");
			System.out.println("現状:" + gamer.currentStatusString());
			gamer.bet();
			System.out.println("所持金は" + gamer.getMoney() + Gamer.MoneyUnit + "になりました");

			if (earnMoreMoneyThanMemento(gamer, memento) == true) {
				System.out.println("勝ち越したので保存する");
				memento = gamer.createMemento();
			} else if ( loseHarfMoneyFromMemento(gamer, memento) == true ) {
				System.out.println("半減したので以前の状態に戻す");
				gamer.restoreMemento(memento);
			}
			System.out.println();
		});
	}

	private static boolean earnMoreMoneyThanMemento(Gamer gamer, Memento memento) {
		 return gamer.getMoney() > memento.getMoney();
	}

	private static boolean loseHarfMoneyFromMemento(Gamer gamer, Memento memento) {
		return gamer.getMoney() < memento.getMoney();
	}
}
