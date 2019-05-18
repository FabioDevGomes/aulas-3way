package generics2;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Classe que implementa um movimento de transacoes ou de outro tipo definido na
 * criação do objeto Movimento.
 */
public class Movimento<T> {
	// uma colecao, deve manter a ordem de inserçao
	private ArrayList<T> transacoes;

	// Construtor
	/**
	 * Controi um Movimento vazio (sem transacoes).
	 */
	public Movimento() {
		this.transacoes = new ArrayList<T>();
	}

	/**
	 * Adiciona uma transacoes ao movimento.
	 */
	public void add(T transacao) {
		transacoes.add(transacao);
	}

	/**
	 * Fornece um Iterator para percorrer as transacoes.
	 */
	public Iterator<T> getTransacoes() {
		return transacoes.iterator();
	}
}
