package lab05;


public class TresTiposDeVariaveis {

	// Exemplo de variável estática
	static String staticVariable = "Variável de classe, ou estática";

	// Exemplo de variável de instância
	static String instanceVariable = "variável de instância";

	public static void main(String[] args) {
		String localVariable = "variável local";
		System.out.println("Variável estática = " + staticVariable);
		System.out.println("Variável de instância = " + instanceVariable);
		System.out.println("Variável local = " + localVariable);
	}
}