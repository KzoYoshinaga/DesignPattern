package memento.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Gamer {

	public  static final String MoneyUnit = "円";

	private int money;

	private List<Fruits> fruits = new ArrayList<>();

	private Random random = new Random();

	public Gamer(int money) {
		this.money = money;
	}

	public int getMoney() {
		return money;
	}

	public void bet() {
		int dice = diceRoll(6, 1);
		System.out.println("Dice = " + dice);
		switch (dice) {
		case 1:
			addMoney(100);
			break;
		case 2:
			loseMoney(100);
			break;
		case 6:
			getFruit();
			break;
		}
	}

	public Memento createMemento() {
		Memento m = new Memento(money);
		fruits.stream().filter(f -> {return f.isTasty();}).forEach(f -> m.addFruit(f));
		return m;
	}

	public void restoreMemento(Memento memento) {
		this.money = memento.money;
		this.fruits = memento.getFruits();
	}

	public String currentStatusString() {
		return "[money = " + money + ", fruits = " + fruits + "]";
	}

	// 以下ヘルパ *****************************************************************************
	private void addMoney(int amount) {
		this.money += amount;
		System.out.println("所持金が"+ amount + "増えました");
	}

	private void loseMoney(int amount) {
		this.money -= amount;
		System.out.println("所持金が" + amount + "減りました");
	}

	private void getFruit() {
		int length = Fruits.values().length;
		Fruits fruit = Fruits.values()[random.nextInt(length)];
		System.out.println("フルーツ（" + ( fruit.isTasty() ? "おいしい" : "" ) + fruit.getName() + "）をもらいました");
		this.fruits.add(fruit);
	}

	private int diceRoll(int diceMax, int rollTimes) {
		return Math.abs(rollTimes * (random.nextInt(diceMax) + 1));
	}
}
