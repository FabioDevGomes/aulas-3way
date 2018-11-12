package lab02;


public class MediaNumerica {

	public static void main(String[] args) {
		//declara numeros inteiros
		int num1 = 10;
		int num2 = 20;
		int num3 = 45;
		int num4 = 75;
		
		//retorna a media numerica dos tres numeros
		// e salva-o na variavel media
		int media = (num1+num2+num3+num4)/4;
		
		
		
		//imprime na saída padrão
		System.out.println("numero 1 = "+ num1);
		System.out.println("numero 2 = "+ num2);
		System.out.println("numero 3 = "+ num3);
		System.out.println("numero 4 = "+ num4);
		System.out.println("media = "+ media);
	}
}