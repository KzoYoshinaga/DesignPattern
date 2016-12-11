package memento.game;

import java.util.ArrayList;
import java.util.List;

public class Memento {

	int money;

	List<Fruits> fruits;

	Memento(int money) {
		this.money = money;
		this.fruits = new ArrayList<>();
	}

	public int getMoney() {
		return money;
	}

	void addFruit(Fruits fruit) {
		fruits.add(fruit);
	}

	List<Fruits> getFruits() {
		return new ArrayList<>(fruits);
	}
}
