package br.com.threeway.dao;

import java.util.List;

import br.com.threeway.objeto.Pessoa;

public class PessoaDAO extends SuperDAO {
	
	public void salvar(Pessoa pessoa) {
		
		em.getTransaction().begin();
		em.persist(pessoa);
		em.getTransaction().commit();
		
	}
	
	public List<Pessoa> consultarTodos(){
		
		return em.createQuery("from Pessoa").getResultList();
		
	}
	
	public void deletar(Pessoa pessoa) {
		
		em.getTransaction().begin();
		em.remove(pessoa);
		em.getTransaction().commit();
		
	}
	
	public void alterar(Pessoa pessoa) {
		
		em.getTransaction().begin();
		em.merge(pessoa);
		em.getTransaction().commit();
		
	}

}
