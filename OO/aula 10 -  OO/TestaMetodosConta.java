package aula10;

class Conta {
	int numero;
	double saldo = 100;
	double limite = 500;

	void deposita(double valor) {
		this.saldo += valor;
	}

	void saque(double valor) {
		this.saldo -= valor;
	}

	void impExtrato() {
		System.out.println("Extratato da Conta - Seu saldo e de: " + this.saldo + "\n");
	}

	double consultaSaldoDisponivel() {
		return this.saldo + this.limite;
	}
}

public class TestaMetodosConta {

	public static void main(String[] args) {

		Conta c = new Conta();

		c.deposita(875.90);
		c.impExtrato();

		c.saque(250);
		c.impExtrato();

		double saldoDisponivel = c.consultaSaldoDisponivel();
		System.out.println("Seu saldo disponivel e de: " + saldoDisponivel);

	}

}
