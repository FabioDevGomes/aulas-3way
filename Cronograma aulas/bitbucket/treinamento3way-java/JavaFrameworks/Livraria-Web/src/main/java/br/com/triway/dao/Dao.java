package br.com.triway.dao;

import java.io.Serializable;
import java.util.Collection;

public interface Dao<E, K extends Serializable> {

	/**
	 * Busca a entidade pelo seu identificador.
	 * 
	 * @param identificador da entidade
	 * 
	 * @return entidade pesquisada
	 */
	E consultar(final K id);

	/**
	 * Altera a entidade.
	 * 
	 * @param endidade
	 */
	void alterar(final E endidade);

	/**
	 * Insere a entidade.
	 * 
	 * @param entidade
	 */
	void salvar(final E entidade);

	/**
	 * Remove a entidade.
	 * 
	 * @param entidade
	 */
	void remover(final E entidade);

	/**
	 * Lista todos os objetos da entidade.
	 * 
	 * @return Collection<E>
	 */
	Collection<E> listar();
}