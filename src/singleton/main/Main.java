package singleton.main;

public class Main {

	public static void main(String[] args) {
		// クラスロード時に最初のインスタンスが生成されている
		Singleton singleton = Singleton.getInstance();
		singleton = Singleton.getInstance();

		// null初期化するとnullと等値になる
		singleton.nullInitialize();
		singleton = Singleton.getInstance();
		System.out.println("null_? " + (singleton == null));

		System.out.println();

		// 取得メソッドが呼び出された際に最初のインスタンスが生成される
		DefectiveSingleton defectiveSingleton = DefectiveSingleton.getInstance();
		defectiveSingleton = DefectiveSingleton.getInstance();

		// null初期化しても新しいインスタンスが返される
		defectiveSingleton.nullInitialize();
		defectiveSingleton = DefectiveSingleton.getInstance();
		System.out.println("null_? " + (defectiveSingleton == null));

	}

}
