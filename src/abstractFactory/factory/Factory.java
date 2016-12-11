package abstractFactory.factory;

/**
 * 抽象的なファクトリを返すファクトリ
 * 引数として渡された文字列から実装ファクトリクラス名を解決
 * @author ict816
 *
 */
public abstract class Factory {

	public static Factory getFactory(String classname) {
		Factory factory = null;

		try {
			// クラス名から引数なしコンストラクタが呼ばれインスタンスが生成される
			factory = (Factory)Class.forName(classname).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return factory;
	}

	public abstract Link createLink(String caption, String url);

	public abstract Tray createTray(String caption);

	public abstract Page createPage(String title, String author);
}
