package arrauList;

import java.util.ArrayList;
import java.util.List;

public class TesteArrayList {

	public static void main(String[] args) {

		List<String> listaString = new ArrayList<String>();
		
		//checa o tamanho
		System.out.println(listaString + ", size = " + listaString.size());

		// Adiciona itens ao ArrayList
		listaString.add("Contrato");
		listaString.add("Documento");
		listaString.add("Nota Fiscal");

		System.out.println(listaString + ", size = " + listaString.size());

		// Remove item, usa equals e hashCode
		listaString.remove("Documento");
		System.out.println(listaString + ", size = " + listaString.size());

		// Checa se a lista contem o elemento especificado
		Boolean contem = listaString.contains("Nota Fiscal");
		System.out.println("A lista contem Nota Fiscal = " + contem);

		contem = listaString.contains("Documento");
		System.out.println("A lista contem Documento = " + contem);
	}	
	//	Adicione mais 3 elementos na lista
	//	Verifique o tamanho
	//	Remova um deles 
	//	Verifique o tamanho
	//
	//	percora os valores num la�o for

}
