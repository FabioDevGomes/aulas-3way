package aula03;

import java.util.Arrays;

public class OredenarArray {

	public static void main(String[] args) {

		//ordenação inesperada com caracteres maiúsculos / minpusculos
		String[] arrayString = {"Cenoura", "Abacate", "Pudim", "abc"}; 
		
		Arrays.sort(arrayString);
		
		for (String string : arrayString) {
			System.out.println(string);
		}
	}

}
