package observer.main;

import java.util.ArrayList;
import java.util.List;

public abstract class NumberGenerator implements Subject{

	public List<Observer> observers = new ArrayList<>();

	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void deleteObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		observers.stream().forEach(o -> o.update(this));
	}

	public abstract void execute(int times);

}
