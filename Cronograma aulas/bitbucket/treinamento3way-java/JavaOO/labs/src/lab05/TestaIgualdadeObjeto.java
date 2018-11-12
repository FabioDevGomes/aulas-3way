package lab05;


public class TestaIgualdadeObjeto {

	public static void main(String[] args) {
	
		// Declara duas variáveis do tipo String, str1 e str2
		Integer int1, int2;
		
		// Inicializando as variáveis. Note que as variáveis contem
		// ponteiros para instância de mesmo objeto atual.
		int1 = 56;
		int2 = int1;
		
		// Mostra o valor das variáveis str1 e str2
		System.out.println("Integer1: " + int1);
		System.out.println("Integer2: " + int2);
		
		// A notação "==", quando e usada com variáveis de referência,
		// se retornar true significa que as variáveis apontam para
		// mesma instância de um objeto, e se false não, são referencias diferentes
		// Checa se str1 e str2 são o mesmo objeto para as duas variáveis
		// apontando para mesma instância de um objeto do tipo String
		System.out.println("Mesmo objeto? " + ( int1 == int2 ));
		
		// Reinicializa variável str2. Ela agora aponta para um nova
		// instância de objeto String
		int2 = new Integer(int1);
		
		// Mostra valor das variáveis str1 e str2
		System.out.println("Integer1: " + int1);
		System.out.println("Integer2: " + int2);
		
		// Checa novamente se str1 e str2 são os mesmos
		// objetos para as duas variáveis
		// apontando para mesma instância de um objeto do tipo String
		System.out.println("Mesmo objeto? " + ( int1 == int2 ));
		
		// Checa se str1 e str2 tem o mesmo valor
		System.out.println("Mesmo valor? " + int1.equals(int2));
	}
}