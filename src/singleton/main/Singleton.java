package singleton.main;

/**
 * シングルトンパターン
 * 指定したインスタンスが絶対に１つしか存在しないことを保証
 * インスタンスが１つしかないことをプログラム上で表現
 * @author ict816
 *
 */
public class Singleton {
	private static Singleton instance = new Singleton();
	private static int count = 0;
	private Singleton(){
		System.out.println("シングルトンが生成されました");
	}
	public static Singleton getInstance() {
		System.out.println((++count) +" 回目のシングルトンのインスタンス取得です");
		return instance;
	}

	/**
	 * nullと等値なインスタンスとなりシングルトンを保証できる
	 */
	public void nullInitialize() {
		instance = null;
	}
}
