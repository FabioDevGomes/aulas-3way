package com.framework.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.framework.model.Pessoa;

public class PessoaDao {
	//	Nossa classe PessoaDao segue o padr�o de projeto 
	//	Singleton que garante que apenas uma inst�ncia dessa 
	//	classe ser� criada durante toda a aplica��o
	private static PessoaDao instance;
	EntityManager entityManager;

	private PessoaDao() {
		entityManager = getEntityManager();
	}
	
	public static PessoaDao getInstance() {
		if (instance == null) {
			instance = new PessoaDao();
		}
		return instance;
	}

	private EntityManager getEntityManager() {
		if (entityManager == null) {
			EntityManagerFactory factory = 
					Persistence.createEntityManagerFactory("jpa-hello");
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}
	
	
	
	

	public void persist(Pessoa pessoa) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(pessoa);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {	
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public Pessoa getById(final int id) {
		return entityManager.find(Pessoa.class, id);
	}
	
	
	
	
	
	
	
	//	utiliza o createQuery que recebe um JPQL 
	//	(Java Persistence Query Language) que � uma alternativa ao SQL 
	@SuppressWarnings("unchecked")
	public List<Pessoa> findAll() {
		return entityManager.createQuery("FROM " + Pessoa.class.getName()).getResultList();
	}
	
	//	O m�todo merge segue o mesmo princ�pio do m�todo persist(), 
	//	a �nica diferen�a � que o merge atualiza o registro e n�o 
	//	apenas insere ele no banco
	public void merge(Pessoa pessoa) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(pessoa);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
	
	
	
	
	
	
	
	

	public void remove(Pessoa pessoa) {
		try {
			entityManager.getTransaction().begin();
			pessoa = entityManager.find(Pessoa.class, pessoa.getId());
			entityManager.remove(pessoa);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void removeById(final int id) {
		try {
			Pessoa pessoa = new Pessoa();
			pessoa.setId(id);
			remove(pessoa);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
