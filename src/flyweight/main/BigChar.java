package flyweight.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

/**
 * 大きな文字を構成している文字列をファイルから読み込み保持する
 * もしもファイルが開けなかった場合は与えられたchar文字に "?" を付けた文字列を保持
 * @author ict816
 *
 */
public class BigChar {

	private String fontdata;

	public BigChar(char charname) {
		try {
			String filePath = new File("").getAbsolutePath() + "\\Fonts\\";
			BufferedReader reader = new BufferedReader(new  FileReader(filePath + "big" + charname + ".txt"));
			this.fontdata = reader.lines().collect(Collectors.joining("\n"));
			reader.close();
		} catch (IOException e) {
			this.fontdata = charname + "?";
		}
	}

	public void print() {
		System.out.println(fontdata);
	}
}
