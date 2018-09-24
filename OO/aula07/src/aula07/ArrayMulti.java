package aula07;

public class ArrayMulti {

	public static void main(String[] args) {

//		int[][] matriz = {{11, 12, 13}, {21, 22, 23}, {31, 32, 33}};
		int[][] matriz = new int[3][3];
		matriz[0][0] = 11;
		matriz[0][1] = 11;
		matriz[0][2] = 11;
		matriz[1][0] = 11;
		
		for (int linha = 0; linha < matriz.length; linha++) {
			for (int coluna = 0; coluna < matriz.length; coluna++) {
				System.out.print(matriz[linha][coluna] + " ");
			}
			System.out.println("\n");
		}
		
		
	}

}
