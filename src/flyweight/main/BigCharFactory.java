package flyweight.main;

import java.util.HashMap;

/**
 * シングルトンのインスタンファクトリースプール
 * @author ict816
 *
 */
public class BigCharFactory {

	private HashMap<Character, BigChar> pool = new HashMap<>();

	private static BigCharFactory singleton = new BigCharFactory();

	private BigCharFactory() {}

	public static BigCharFactory getInstance() {
		return singleton;
	}

	/**
	 * インスタンスがければ作成しプールに貯める
	 * @param charname
	 * @return
	 */
	public synchronized BigChar getBigChar(char charname) {
		BigChar bc = pool.get("" + charname);
		if (bc == null) {
			bc = new BigChar(charname);
			pool.put(charname, bc);
		}
		return bc;
	}
}
