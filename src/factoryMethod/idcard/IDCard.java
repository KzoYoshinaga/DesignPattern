package factoryMethod.idcard;

import factoryMethod.framework.Product;

/**
 * IDCardは与えられたオーナー名を所持した状態で生成される
 * IDCardは製品として使用することができる
 * IDCardはオーナー名を返す機能を持つ
 * @author ict816
 *
 */
public class IDCard extends Product{

	private String owner;

	IDCard(String owner) {
		System.out.println(owner + "のカードを作ります。");
		this.owner = owner;
	}

	@Override
	public void use() {
		System.out.println(owner + "のカードを使います。");
	}

	public String getOwner() {
		return owner;
	}
}
