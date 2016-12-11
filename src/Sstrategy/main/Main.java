package Sstrategy.main;

public class Main {

	public static void main(String[] args) {
		Player player1 = new Player("田中", new WinningStrategy((int)System.currentTimeMillis()));
		Player player2 = new Player("佐藤", new ProvabilityStrategy((int)System.currentTimeMillis()));
		for (int i = 0; i < 1000; i++) {
			Hand player1Hand = player1.nextHand();
			Hand player2Hand = player2.nextHand();
			System.out.println("Game" + i + " " + player1Hand + " vs " + player2Hand);
			player1.battle(player1Hand, player2Hand);
			player2.battle(player2Hand, player1Hand);
			System.out.println(player1.toString());
			System.out.println(player2.toString());
			System.out.println();
		}
	}
}
