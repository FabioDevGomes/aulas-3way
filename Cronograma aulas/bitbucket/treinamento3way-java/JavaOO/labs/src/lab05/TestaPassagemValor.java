package lab05;


public class TestaPassagemValor {

	public static void main(String[] args) {
	int i = 10;
	int j = 5;
	
	// Imprime valor de i
		System.out.println("inicia método main e i = " + i + "  j = " + j);
		
		// Chama método test, que está definido abaixo
		// e passa valor inteiro como um parâmetro. Uma vez que
		// int é um tipo primitivo, este argumento e passado
		// por valor.
		test(i,j);
		
		// imprime o valor de i, note que valor de i não muda
		System.out.println("termina o método main e i = " + i + "  j = " + j);
	}
	
	// Método estático na classe
	public static void test(int k, int l) {
		System.out.println("inicia método test e k = " + k + "  l = " + l);
		// muda valor parâmetro i
		k = 33;
		l = 66;
		System.out.println("termina método test e k = " + k + "  l = " + l);
	}
}