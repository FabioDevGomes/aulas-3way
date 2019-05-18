package teste2;

public class CastingPrimitivos {

	public static void main(String[] args) {
		int tipoInt = 12121;
		long tipoLong = 4561212100l;
		double tipoDouble = 454545;
		float tipoFloatPrimitivo = 4545646;
		short tShort = 5565;
		char teste = 3; //char num�rico
		//short tShort3 = 556665; //erro

		// No caso do double sendo convertido para o int isso � possivel, pois com o cast
		// voc� indica ao Java que voc� tem ci�ncia da perda de precis�o ao converter de double para int.

		// erro: J� a transfer�ncia de dados de um tipo mais
		// preciso para um menos preciso requer um casting expl�cito.
		// Isso ocorre porque pode haver perda de dados durante a moldagem.
		// Java pretende alertar o programador do poss�vel perigo de
		// uma convers�o desse tipo:
		//int testeCasting = tipoLong; //**************************
		tipoInt = (int) tipoLong;
		tipoFloatPrimitivo = (float) tipoDouble;
		
//		System.out.println(tipoInt); //imprime um valor diferente se long for grande
		
		// Sempre que houver uma transfer�ncia de dados
		// de um tipo menos preciso para um mais preciso, o casting expl�cito
		// n�o � obrigat�rio.
		tipoLong = tipoInt;
		tipoDouble = tipoFloatPrimitivo;
		
		//Fa�a um cast expl�cito e um impl�cito e imprima o valor;
		double valor1 =  3.45;
		int valor = (int) valor1;
		
		Long exemp2 = 10l;
		int explicito2 =  exemp2.intValue();
		
		castingWrapper();
	}
	
	public static void castingWrapper(){
		Integer objetoInteiro = 1112311;
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
	}

}
