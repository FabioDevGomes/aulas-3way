package br.com.triway.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.triway.model.Cliente;

public class ClienteDao implements Dao<Cliente, String> {
	@Inject
	EntityManager em;
	
	/*public ClienteDao() throws SQLException{
		this.em = PersistenceManager.INSTANCE.getEntityManager();
	}*/

	@Override
	public void salvar(Cliente cliente) {

	}
	
	@Override
	public Cliente consultar(String nome) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Cliente> q = cb.createQuery(Cliente.class);
		Root<Cliente> root = q.from(Cliente.class);
		q.select(root).where(cb.like(root.get("nome"),"%"+nome+"%"));
		TypedQuery<Cliente> query = em.createQuery(q);
		return query.getSingleResult();
	}

	@Override
	public void alterar(Cliente cliente) {
		try{
			em.getTransaction().begin();
			em.merge(cliente);
			em.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}
		

	@Override
	public void remover(Cliente cliente) {
		
	}

	@Override
	public List<Cliente> listar() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Cliente> q = cb.createQuery(Cliente.class);
		Root<Cliente> root = q.from(Cliente.class);
		q.select(root);
		TypedQuery<Cliente> query = em.createQuery(q);
		return query.getResultList();
	}

}
