package comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.sql.rowset.spi.TransactionalWriter;

public class TestaComparable {

	public static void main(String[] args) throws Exception {
		Conta conta1 = new Conta(5452, "Phillip Lahm");
		Conta conta2 = new Conta(1234, "Lucas Podolski");
		Conta conta3 = new Conta(3145, "Arne Friedrich");

		List<Conta> lista = new ArrayList();
		lista.add(conta1);
		lista.add(conta2);
		lista.add(conta3);
		
		for (Conta conta : lista) {
			System.out.println("=======+ "+conta.getNumero());
		}
		
		Collections.sort(lista);
		
		for (Conta conta : lista) {
			System.out.println("======= "+conta.getNumero());
		}
		
		//throw new Exception();

	}

}
