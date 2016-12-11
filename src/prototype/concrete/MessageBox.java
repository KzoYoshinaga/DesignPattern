package prototype.concrete;

import prototype.framework.Product;

public class MessageBox implements Product{

	private char decolationChar;

	public MessageBox(char decolationChar) {
		this.decolationChar = decolationChar;
	}

	@Override
	public void use(String s) {
		// 半角文字列長を取得
		int length = s.getBytes().length;
		for (int i = 0; i < length + 4; i++)
			System.out.print(decolationChar);
		System.out.println();
		System.out.println(decolationChar + " " + s + " " + decolationChar);
		for (int i = 0; i < length + 4; i++)
			System.out.print(decolationChar);
		System.out.println();
	}

	@Override
	public Product createClone() {
		Product p = null;
		try {
			p = (Product)this.clone();
		} catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return p;
	}


}
