package bridge.main;

public class Main {
	public static void main(String[] args) {
		Display d1 = new Display(new StringDisplayImplementor("Hello,  Japan"));
		Display d2 = new CountDisplay(new StringDisplayImplementor("Hello, World"));
		CountDisplay d3 = new CountDisplay(new StringDisplayImplementor("Hello, Universe"));

		Display d4 = new Display(new InsaneDisplayImplementor());
		CountDisplay d5 = new CountDisplay(new InsaneDisplayImplementor());

		d1.display();
		d2.display();
		d3.display();
		d3.multiDisplay(5);

		d4.display();
		d5.multiDisplay(5);
	}
}
