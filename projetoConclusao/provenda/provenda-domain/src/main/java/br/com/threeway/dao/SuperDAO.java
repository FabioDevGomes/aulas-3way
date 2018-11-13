package br.com.threeway.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SuperDAO {
	
EntityManager em;
	
	public SuperDAO() {
		
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("bancoDados");
		em = factory.createEntityManager();
		
	}

}
