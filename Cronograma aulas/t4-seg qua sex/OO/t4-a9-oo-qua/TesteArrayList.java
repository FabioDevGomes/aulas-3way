package arrauList;

import java.util.ArrayList;
import java.util.List;

public class TesteArrayList {

	public static void main(String[] args) {

		List<String> listaString = new ArrayList<String>();
		
		//checa o tamanho
		System.out.println(listaString + ", size = " + listaString.size());

		// Adiciona itens ao ArrayList
		listaString.add("Robaum");
		listaString.add("Usurpa");
		listaString.add("Omitte");

		System.out.println(listaString + ", size = " + listaString.size());

		// Remove item, usa equals e hashCode
		listaString.remove("Usurpa");
		System.out.println(listaString + ", size = " + listaString.size());

		// Checa se a lista contem o elemento especificado
		Boolean contem = listaString.contains("Omitte");
		System.out.println("A lista contem Omitte = " + contem);

		contem = listaString.contains("Paumdu");
		System.out.println("A lista contem Paumdu = " + contem);
	}	
	//	Adicione mais 3 elementos na lista
	//	Verifique o tamanho
	//	Remova um deles 
	//	Verifique o tamanho
	//
	//	percora os valores num laço for

}
