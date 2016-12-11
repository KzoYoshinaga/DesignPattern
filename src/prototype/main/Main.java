package prototype.main;

import prototype.concrete.MessageBox;
import prototype.concrete.UnderlinePen;
import prototype.framework.Manager;
import prototype.framework.Product;

/**
 * Prototypeパターンの適用
 * 1. 種類が多すぎてクラスにまとめられない場合
 * 2. クラスからのインスタンス生成が難しい場合
 *    e.g. 生成パラメータが多い場合
 * 3. フレームワークと生成するインスタンスを分けたい場合
 *
 * enum に生成メソッドを持たせた場合
 *
 * @author ict816
 *
 */
public class Main {


	public static void main(String[] args) {
		Manager manager = new Manager();

		UnderlinePen wavyUnderlinePen = new UnderlinePen('~');

		MessageBox asteriskMessageBox = new MessageBox('*');
		MessageBox slashMessageBox = new MessageBox('/');

		manager.register("strong message", wavyUnderlinePen);
		manager.register("warning box", asteriskMessageBox);
		manager.register("slash box", slashMessageBox);

		Product p1 = manager.create("strong message");
		p1.use("Hello world");

		Product p2 = manager.create("warning box");
		p2.use("Hello world");

		Product p3 = manager.create("slash box");
		p3.use("Helloworld");

		System.out.println();

		// enum 型に生成メソッドを持たせた場合

		Product p4 = ProductType.Strong.create();
		p4.use("enum creation");

		Product p5 = ProductType.Warning.create();
		p5.use("enum creation");

		Product p6 = ProductType.Slash.create();
		p6.use("enum creation");
	}
}
