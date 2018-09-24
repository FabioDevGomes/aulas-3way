package lab03;

import java.util.Scanner;

public class While {
	public static void main(String[] args) {
		
		int valor = 1;
		
		
		while (valor > 0) {
			Scanner sc = new Scanner(System.in);
			valor =  sc.nextInt();
			System.out.println(valor);
		}
	}
}
