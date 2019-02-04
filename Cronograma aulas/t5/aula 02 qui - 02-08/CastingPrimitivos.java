package teste2;

public class CastingPrimitivos {
	public static void main(String[] args) {
		int tipoInt = 12121;
		long tipoLong = 4561212100l;
		double tipoDouble = 454545;
		float tipoFloatPrimitivo = 4545646;
		short tShort = 5565;
		char teste = 3; //char numérico
		short tShort3 = 556665; //erro

		// No caso do double sendo convertido para o int isso é possivel, 
		//pois com o cast
		// você indica ao Java que você tem ciência da perda de 
		//precisão ao converter de double para int.
		
		
		
		
		
		

		// erro: Já a transferência de dados de um tipo mais
		// preciso para um menos preciso requer um casting explícito.
		// Isso ocorre porque pode haver perda de dados durante a moldagem.
		// Java pretende alertar o programador do possível perigo de
		// uma conversão desse tipo:
		int testeCasting = tipoLong; //**************************
		tipoInt = (int) tipoLong;
		tipoFloatPrimitivo = (float) tipoDouble;
		
		System.out.println(tipoInt); //imprime um valor diferente se long for grande
		
		// Sempre que houver uma transferência de dados
		// de um tipo menos preciso para um mais preciso, o casting explícito
		// não é obrigatório.
		tipoLong = tipoInt;
		tipoDouble = tipoFloatPrimitivo;
		
		//Faça os castings abaixo declarando novas variáveis;
		//Long (objeto) para int (primitivo) 
		//double (primitivo) para int (primitivo) 
		
		castingWrapper();
	}
	
	public static void castingWrapper(){
		Integer objetoInteiro = 1112311;
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
	}

}
