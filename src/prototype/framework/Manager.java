package prototype.framework;

import java.util.HashMap;

/**
 * Productインターフェイスを利用してインスタンスの複製を行うクラス
 * @author ict816
 *
 */
public class Manager {
	private HashMap<String, Product> showcase = new HashMap<>();
	public void register(String name, Product prototype) {
		showcase.put(name, prototype);
	}
	public Product create(String prototypeName) {
		return showcase.get(prototypeName).createClone();
	}
}
