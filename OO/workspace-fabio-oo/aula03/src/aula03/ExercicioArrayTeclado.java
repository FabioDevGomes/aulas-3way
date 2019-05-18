package aula03;

import java.util.Scanner;

public class ExercicioArrayTeclado {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double[] array = new double[5];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = sc.nextDouble();
		}

		System.out.println("imprimindo o array com for");
		
		for (int i = 0; i < array.length; i++) {
			String traco = "";
			if(i < array.length - 1) {
				traco = " - ";
			}
			System.out.print(array[i] + traco);
		}
		
		System.out.println();
		System.out.println("imprimindo o array com foreach");
		
		for (double i : array) {
			System.out.print(i + " - ");
		}
	}

}
