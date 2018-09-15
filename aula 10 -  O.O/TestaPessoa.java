package aula10;

class Pessoa {

	int idade;
	int dia;
	int mes;
	int ano;
	String nome;
	
	
	public void calcularIdade(int dia, int mes, int ano) {
		idade = ano - this.ano;
		if(mes < this.mes ) {
			this.idade = this.idade - 1;
		}
		if(mes == this.mes && this.dia < dia) {
			this.idade = this.idade - 1;
		}
	}
	
}

public class TestaPessoa{
	public static void main(String[] args) {
		Pessoa pessoa = new Pessoa();
		pessoa.dia = 10;
		pessoa.mes = 10;
		pessoa.ano = 2000;
		
		pessoa.calcularIdade(11, 10, 2010);
		
		System.out.println(pessoa.idade);
	}
}
