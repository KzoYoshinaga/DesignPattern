package abstractFactory.factory;

/**
 * HTMLのハイパーリンクの抽象
 * @author ict816
 *
 */
public abstract class Link extends Item{
	protected String url;
	public Link(String caption, String url) {
		super(caption);
		this.url = url;
	}
}
