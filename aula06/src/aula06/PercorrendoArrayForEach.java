package aula06;

import java.util.Arrays;

public class PercorrendoArrayForEach {
	public static void main(String[] args) {

		int[] num = { 5, 2, 4 };
		String[] strin = { "1", "2", "3" };

		System.out.println(num);
		System.out.println(Arrays.toString(num));
		
		for (int i : num) {
//			System.out.println(num[i]);
			System.out.println(i);
		}

		for (String i : strin) {

		}
	}
}
