package aula10;

class Gerente {
	String nome = "Samuel Bobrick";
	double salario = 1500;

	void aumentarSalario() {
		this.salario += this.salario * 0.1;
	}

}

public class TestaMetodoGerente {

	public static void main(String[] args) {

		Gerente gerenteBanco = new Gerente();

		System.out.println("Salario atual: " + gerenteBanco.salario + "\n");

		System.out.println("O gerente: " + gerenteBanco.nome + " recebera um aumento de salario em 10% \n");

		gerenteBanco.aumentarSalario();
		System.out.println("Salario atual: " + gerenteBanco.salario);

	}
}