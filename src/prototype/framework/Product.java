package prototype.framework;
/**
 * プロトタイプのクローンを生成することを可能にするインターフェイス
 * @author ict816
 *
 */
public interface Product extends Cloneable{
	public abstract void use(String s);
	public abstract Product createClone();
}
