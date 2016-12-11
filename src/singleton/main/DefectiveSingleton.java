package singleton.main;

/**
 * 欠陥のあるシングルトン
 * null初期化された場合はどうか？
 * マルチスレッド環境ではどうか？
 * @author ict816
 *
 */
public class DefectiveSingleton {
	/**
	 * マルチスレッド環境で同時にインスタンス取得された場合
	 * null状態で複数のスレッドから呼び出される可能性があり
	 * その時にコンストラクタが複数回呼び出され新しいインスタンスで上書きされる
	 */
	private static DefectiveSingleton singleton = null;
	private static int count = 0;
	private DefectiveSingleton() {
		System.out.println("「不完全な」シングルトンが生成されました");
	}
	public static DefectiveSingleton getInstance() {
		System.out.println((++count) + "回目の「不完全な」シングルトンのインスタンス取得です");
		if (singleton == null) {
			singleton = new DefectiveSingleton();
		}
		return singleton;
	}

	/*
	 *  インスタンスをnull初期化するメソッドを作ることが出来るため
	 *  次回の呼び出し時に新しいインスタンスが生成されてしまう
	 *  これは「インスタンスが１つだけであることの保証」に反する
	 */
	public void nullInitialize() {
		singleton = null;
	}
}
