package observer.main;

public abstract class NumberObserver implements Observer {
	protected int getNumberFrom(NumberGenerator generator) {return generator.getValue();}
}
