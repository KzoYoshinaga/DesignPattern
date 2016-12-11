package factoryMethod.idcard;

import java.util.ArrayList;
import java.util.List;

import factoryMethod.framework.Factory;
import factoryMethod.framework.Product;

/**
 * IDCardFactoryはIDCardを生成返す機能を持つ
 * IDCardFactoryは与えられた製品がIDCardだった場合にそのオーナー名をオーナー名リストに登録する機能を持つ
 * IDCardFactoryはオーナー名リストを返す機能を持つ
 * @author ict816
 *
 */
public class IDCardFactory extends Factory{

	List<String> owners = new ArrayList<>();

	@Override
	public Product createProduct(String owner) {
		return new IDCard(owner);
	}

	@Override
	public void registerProduct(Product product) {
		owners.add(((IDCard)product).getOwner());
	}

	public List<String> getOwners() {
		return owners;
	}

}
