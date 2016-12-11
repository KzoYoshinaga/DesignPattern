package prototype.main;

import java.util.function.Supplier;

import prototype.concrete.MessageBox;
import prototype.concrete.UnderlinePen;
import prototype.framework.Product;

/**
 * enumだとインスタンス生成が無駄になるかも
 *  -> プロダクトは生成時から不変なので遅延生成をしてみる
 * カリー化やファクトリに近い動作をしている
 * @author ict816
 *
 */
public enum ProductType {
	Strong(() -> new UnderlinePen('~')),
	Warning(() -> new MessageBox('*')),
	Slash(() -> new MessageBox('/'));

	private Product product = null;
	private Supplier<Product> supplier;

	private ProductType(Supplier<Product> supplier) {
		this.supplier = supplier;
	}

	public Product create() {
		if (product == null) product = supplier.get();
		return product.createClone();
	}
}
