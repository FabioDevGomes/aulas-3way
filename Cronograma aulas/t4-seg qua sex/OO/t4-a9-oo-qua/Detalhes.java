package hashMap;

import java.util.ArrayList;
import java.util.HashMap;

public class Detalhes {
	
	public static void main(String args[]) {
		
		ArrayList<String> lista = new ArrayList<>();
		lista.add("Stack");
		lista.add("Overflow");
		
//		Index | Elemento
//		  0   | "Stack"
//		  1   | "Overflow"
		
		String str1 = lista.get(0); //str1 receberá "Stack"
		

		HashMap<Integer, String> hashMap = new HashMap<>();
		hashMap.put(1, "Stack");
		hashMap.put(5, "Overflow");
		
//		Key | Value
//		 1  | "Stack"
//		 5  | "Overflow"
		
		String str = hashMap.get(5); //str receberá ?
		
 }
}