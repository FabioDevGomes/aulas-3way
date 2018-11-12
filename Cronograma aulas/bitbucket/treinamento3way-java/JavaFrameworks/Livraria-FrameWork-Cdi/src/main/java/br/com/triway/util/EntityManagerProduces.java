package br.com.triway.util;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProduces {

	EntityManager entityManager;

	@Produces
	private EntityManager createEntityManager() {
		entityManager = Persistence
				.createEntityManagerFactory("pu-livraria-cdi")
				.createEntityManager();
		return entityManager;
	}

	public void close(@Disposes EntityManager entityManager) {
		entityManager.close();
	}
}
