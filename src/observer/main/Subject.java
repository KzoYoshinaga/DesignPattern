package observer.main;

public interface Subject {
	public void addObserver(Observer observer);

	public void deleteObserver(Observer observer);

	public void notifyObservers();

	public abstract int getValue();
}
