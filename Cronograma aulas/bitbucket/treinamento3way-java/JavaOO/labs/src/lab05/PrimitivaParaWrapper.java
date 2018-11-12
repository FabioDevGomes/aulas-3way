package lab05;


public class PrimitivaParaWrapper {

	public static void main(String[] args) {
		
		// cria uma instância de objeto Long
		Long longObjeto = new Long(7801);
		
		// Converte de Integer para primitivo long usando método longValue()
		long longPrimitiva = longObjeto.longValue();
		System.out.println("long intPrimitiva = " + longPrimitiva);
	}
}