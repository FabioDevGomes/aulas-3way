package aula10;

class ExArray {
	int[] arrayInteiros;
	int maxElementos;
	int numeroAtual = 0;

	public ExArray(int maxElementos) {
		arrayInteiros = new int[maxElementos];
		this.maxElementos = maxElementos;
	}

	public boolean adicionar(int valor) throws Exception {
		if (maxElementos > numeroAtual) {
			arrayInteiros[numeroAtual] = valor;
			numeroAtual++;
			return true;
		} else {
			throw new Exception("sss");
//			return false;
		}
	}

}

public class TestaExArray {
	public static void main(String[] args) {
		ExArray array = new ExArray(5);
		try {
			System.out.println(array.adicionar(1));
			System.out.println(array.adicionar(2));
			System.out.println(array.adicionar(4));
			System.out.println(array.adicionar(10));
			System.out.println(array.adicionar(22));
			System.out.println(array.adicionar(25));
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (int valor : array.arrayInteiros) {
			System.out.print(valor + " ");
		}
	}

}
