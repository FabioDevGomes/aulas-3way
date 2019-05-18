package aula08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Listas {
	public static void main(String[] args) {
		List<String> lista = new ArrayList<>();
		lista.add("beste");
		lista.add("aeste2");
		lista.add("ceste3");
		
		Collections.sort(lista, Collections.reverseOrder());
		
		System.out.println(lista);
	}
}
