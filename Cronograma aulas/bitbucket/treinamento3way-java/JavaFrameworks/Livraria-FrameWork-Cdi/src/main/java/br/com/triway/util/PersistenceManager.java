package br.com.triway.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public enum PersistenceManager {
	INSTANCE;
	private EntityManagerFactory emFactory;

	private PersistenceManager() {
		emFactory = Persistence.createEntityManagerFactory("pu-livraria3way2");
	}

	public EntityManager getEntityManager() {
		return emFactory.createEntityManager();
	}

	public void close() {
		emFactory.close();
	}
}
