package lab02;


public class OperadorCondicional {

	public static void main(String[] args) {
		// Declara e inicializa duas variáveies, uma variável do tipo String
		// chamado estado e a outra variável chamada grau do
		// tipo primitivo int
		String estado = "";
		int salario = 100000;
		
		// pega estado do aluno.
		estado = ( salario >= 50000 ) ? "Você está rico!" : "Você é pobre!";
		
		// Imprime estado
		System.out.println(estado);
	}
}
