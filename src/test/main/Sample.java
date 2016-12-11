package test.main;

import test.squareArrayCollection.SquareArray;

public class Sample {
	public static void main(String[] args) {
		SquareArray<String> squareArray = new SquareArray<>(6, 8, "*");
		System.out.println(squareArray.toString("\n"," "));
	}


}
