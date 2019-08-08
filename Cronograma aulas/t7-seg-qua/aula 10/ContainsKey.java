package hashMap;

import java.util.HashMap;
import java.util.Map;

public class ContainsKey {
	public static void main(String args[]) {
		Map<Long, String> example0 = new HashMap<Long, String>();
		example0.put(12339931231233L, "V1");

		Map<String, String> example = new HashMap<String, String>();
		
		// Vamos adicionar alguns valores ao nosso HashMap
		example.put("K1", "V1");
		example.put("K2", "V2");
		example.put("K3", "V3");
		example.put("K4", "V4");
		example.put("K5", "V5---");
		example.put("K5", "V5ss");

		
		String keyToSearch = "K1";

		if (example.containsKey(keyToSearch)) {
			System.out.println("Valor da Chave " + keyToSearch + " = " + example.get(keyToSearch));
		} else {
			System.err.println("Chave não existe");
		}

		 /*
         * O método "keySet()" retorna um Set com todas as chaves do
         * nosso HashMap, e tendo o Set com todas as Chaves, 
         * podemos facilmente pegar os valores que desejamos
         * */
		for (String key : example.keySet()) {
			// Capturamos o valor a partir da chave
			String value = example.get(key);
			System.out.println(key + " = " + value);
		}
	}

}
