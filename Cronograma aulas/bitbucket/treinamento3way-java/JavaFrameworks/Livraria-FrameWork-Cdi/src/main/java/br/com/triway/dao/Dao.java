package br.com.triway.dao;

import java.io.Serializable;
import java.util.Collection;

public interface Dao<E, K extends Serializable> extends Serializable {
	
	E consultar(final K id);
	
	void alterar(final E Serializable);
	
	void salvar(final E Serializable);
	
	void remover (final E Serializable);
	
	Collection<E> listar();

}
