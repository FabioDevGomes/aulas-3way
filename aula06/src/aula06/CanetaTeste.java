package aula06;

public class CanetaTeste {

	public static void main(String[] args) {
		
		Caneta caneta = new Caneta();
		caneta.cor = "azul";
		
		System.out.println(caneta.cor);
		caneta.escrever();
		
	}
}
