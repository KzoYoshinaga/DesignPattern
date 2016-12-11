package abstractFactory.main;

import abstractFactory.factory.Factory;
import abstractFactory.factory.Link;
import abstractFactory.factory.Page;
import abstractFactory.factory.Tray;

/**
 * ファクトリの実装を増やすのは簡単だが
 * プロダクトの種類を増やすのは難しい、全てのファクトリ実装にプロダクトに対応した修正が必要
 *
 * @author ict816
 *
 */
public class Main {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Usage: java Main class.name.of.ConcreteFactory");
			System.out.println("Example 1: java Main listfactory.ListFactory");
			System.out.println("Example 2: java Main tablefactory.TableFactory");
			System.exit(0);
		}

		// 抽象的な部品を返す抽象的な工場
		Factory factory = Factory.getFactory(args[0]);

		// Factoryの実装によってLinkの実装が返される
		Link asahi = factory.createLink("朝日新聞", "http://www.asahi.com/");
		Link yomiuri = factory.createLink("読売新聞", "http://www.yomiuri.co.jp/");

		Link us_yahoo = factory.createLink("Yahoo!", "http://www.yahoo.com/");
		Link jp_yahoo = factory.createLink("Yahoo!Japan", "http://www.yahoo.co.jp/");

		Link excite = factory.createLink("Excite", "http://www.excite.com/");
		Link google = factory.createLink("Google", "https://www.google.com/");

		// Factoryの実装によってTrayの実装が返される
		Tray traynews = factory.createTray("新聞");
		traynews.add(asahi);
		traynews.add(yomiuri);

		Tray trayyahoo = factory.createTray("Yahoo!");
		trayyahoo.add(us_yahoo);
		trayyahoo.add(jp_yahoo);

		// Link Tray はどちらも Item なので Tray に add できる
		Tray traysearch = factory.createTray("サーチエンジン");
		traysearch.add(trayyahoo);
		traysearch.add(excite);
		traysearch.add(google);

		// Page には Item を add できる
		Page page = factory.createPage("LinkPage", "結城 浩");
		page.add(traynews);
		page.add(traysearch);

		page.output();
	}
}
