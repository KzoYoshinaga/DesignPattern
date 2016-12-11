package factoryMethod.framework;

/**
 * 製品(Product)は生成され登録(register)された状態で工場(Factory)から提供される
 * @author ict816
 *
 */
public abstract class Factory {
	// TemplatePattarn
	public final Product create(String owner) {
		Product p = createProduct(owner);

		// ... some factory methods
		registerProduct(p);

		return p;
	}

	public abstract Product createProduct(String owner);

	/**
	 * 実装をサブクラスに任せる
	 * @param product
	 */
	public abstract void registerProduct(Product product);

	/**
	 * デフォルトの実装を用意する
	 * オーバライド忘れそう、間違ってオーバライドしそう
	 * 抽象メソッドのサブクラス実装でスーパクラスのfinalデフォルトメソッドを呼び出す？
	 */
	public void canBeOverrided() {
		System.out.println("doSomething in default");
	}

	/**
	 * 実装されていない場合エラーを投げる
	 * 実行時まで判明しないため実用的ではない
	 */
	public void mustBeOverrided() {
		throw new RuntimeException();
	}
}
