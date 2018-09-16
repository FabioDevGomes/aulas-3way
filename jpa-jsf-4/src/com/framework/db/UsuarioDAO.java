package com.framework.db;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.framework.model.Usuario;

@Named
@ApplicationScoped
public class UsuarioDAO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("usuarios");
	private EntityManager em = factory.createEntityManager();
	private EntityTransaction transaction = em.getTransaction();

	public Usuario getUsuario(String nomeUsuario, String senha) {

		try {
			Usuario usuario = (Usuario) em
					.createQuery("SELECT u from Usuario u where u.nomeUsuario = :name and u.senha = :senha")
					.setParameter("name", nomeUsuario).setParameter("senha", senha).getSingleResult();

			return usuario;
		} catch (NoResultException e) {
			return null;
		}
	}

	public Usuario getUsuario(int id) {
		try {
			return em.find(Usuario.class, id);
		} catch (NoResultException e) {
			return null;
		}
	}

	public void alterarUsuario() {
		transaction.begin();
		transaction.commit();
	}

	public Usuario getUsuarioCard(String nomeUsuario, String matricula) {

		try {
			Usuario usuario = (Usuario) em
					.createQuery("SELECT u from Usuario u where u.nomeUsuario = :name and u.matricula = :matricula")
					.setParameter("name", nomeUsuario).setParameter("matricula", matricula).getSingleResult();

			return usuario;
		} catch (NoResultException e) {
			return null;
		}
	}

	public boolean inserirUsuario(Usuario usuario) {
		if (!transaction.isActive()) {
			transaction.begin();
		}

		try {
			em.persist(usuario);
			transaction.commit();
			return true;
		} catch (Exception e) {
			// essa exception não é necessariamente um erro
			e.printStackTrace();
			return false;
		}
	}

	public boolean deletarUsuario(Usuario usuario) {
		if (!transaction.isActive()) {
			transaction.begin();
		}

		try {
			em.merge(usuario);
			em.remove(usuario);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List listarUsuario() {

		Query queryObj = em.createQuery("SELECT u FROM Usuario u");
		List usuariosList = queryObj.getResultList();
		if (usuariosList != null && usuariosList.size() > 0) {
			return usuariosList;
		} else {
			return null;
		}

	}

}
