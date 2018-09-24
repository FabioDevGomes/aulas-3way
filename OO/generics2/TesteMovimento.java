package generics2;

import java.util.Iterator;

public class TesteMovimento {

	public static void main(String[] args) {
		Movimento<Transacao> movimento1 = new Movimento<Transacao>();
		Movimento<String> movimento2 = new Movimento<String>();

		movimento1.add(new Transacao());

		// erro compilacao
		// m1.add(new String("qq coisa"));
		movimento2.add(new String("nda de +"));
		
		Iterator it;
		
		it = movimento1.getTransacoes();
		
		while (it.hasNext())
			System.out.println(it.next());
		
		it = movimento2.getTransacoes();
		
		while (it.hasNext())
			System.out.println(it.next());
	}

}
