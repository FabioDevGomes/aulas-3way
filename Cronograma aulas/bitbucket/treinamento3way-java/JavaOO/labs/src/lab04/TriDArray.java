package lab04;


public class TriDArray {

	public static void main(String[] args) {
	
		// Declara e cria um array de duas dimensões de int com tamanho 10x5
		int[][][] idades = new int[8][3][4];
		
		// Mostra numero de linhas e colunas
		System.out.println("idades.length =" + idades.length); //linhas
		System.out.println("idades.length[1] =" + idades[1].length); //colunas
		
		// Registra e Imprime o valor de cada elemento do array
		for (int i = 0; i < idades.length; i++) {
			System.out.println("\n Linha inicio " + i);
			for (int j = 0; j < idades[i].length; j++) {
				for (int k = 0; k < idades[i][j].length; k++) {
					idades[i][j][k] = i * j * k;
					System.out.print(idades[i][j][k] + " ");
				}
			}
		}
	}
}