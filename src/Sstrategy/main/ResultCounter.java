package Sstrategy.main;

public class ResultCounter {

	private int game = 0;
	private int win  = 0;
	private int lose = 0;

	public void setResult(Result result) {
		switch (result) {
		case Game:
			game();
			break;
		case Win:
			win();
			break;
		case Lose:
			lose();
			break;
		default:
			break;
		}
	}

	public void game() {game++;}
	public void win() {win++;}
	public void lose() {lose++;}

	public int getGame() {return game;}
	public int getWin() {return win;}
	public int getLose() {return lose;}

	public String toString() {
		return "" + game + "games, " + win + "wins, " + lose + "loses";
	}

}
