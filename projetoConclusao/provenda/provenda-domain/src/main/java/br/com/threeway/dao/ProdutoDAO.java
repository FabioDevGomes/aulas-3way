package br.com.threeway.dao;

import java.util.List;

import br.com.threeway.objeto.Pessoa;
import br.com.threeway.objeto.Produto;

public class ProdutoDAO extends SuperDAO {
	
	public void salvar(Produto produto) {
		
		em.getTransaction().begin();
		em.persist(produto);
		em.getTransaction().commit();
		
	}
	
	public List<Produto> consultarTodos(){
		
		return em.createQuery("from Produto").getResultList();
		
	}
	
	public void deletar(Produto produto) {
		
		em.getTransaction().begin();
		em.remove(produto);
		em.getTransaction().commit();
		
	}
	
	public void alterar(Produto produto) {
		
		em.getTransaction().begin();
		em.merge(produto);
		em.getTransaction().commit();
		
	}

}
