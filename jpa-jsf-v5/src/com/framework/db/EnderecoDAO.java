package com.framework.db;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.CacheStoreMode;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.framework.model.Endereco;
import com.framework.model.Usuario;


public class EnderecoDAO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("usuarios");
	private EntityManager em = factory.createEntityManager();
	private EntityTransaction transaction = em.getTransaction();

	@SuppressWarnings("unchecked")
	public List<Endereco> listarEnderecoDescricao(String descricaoEndereco) {

		List<Endereco> enderecos = new ArrayList<>();
		try {
			enderecos = (List<Endereco>) em
					.createQuery("SELECT u from Endereco u where u.descricao = LIKE CONCAT('%',:descricao,'%') ")
					.setParameter("descricao", descricaoEndereco).getResultList();

			return enderecos;
		} catch (NoResultException e) {
			return null;
		}
	}

	public Endereco getEndereco(int id) {
		try {
			return em.find(Endereco.class, id);
		} catch (NoResultException e) {
			return null;
		}
	}

	public void alterarEndereco() {
		transaction.begin();
		transaction.commit();
	}

	public boolean inserirEndereco(Endereco endereco) {
		if (!transaction.isActive()) {
			transaction.begin();
		}

		try {
			Usuario usuario = em.find(Usuario.class, endereco.getUsuario().getId());
			endereco.setUsuario(usuario);
			usuario.setEndereco(endereco);
			em.persist(endereco);
			em.flush();
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deletarEndereco(Endereco usuario) {
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

	@SuppressWarnings("rawtypes")
	public List listarEndereco() {

		Query queryObj = em.createQuery("SELECT u FROM Endereco u");
		List enderecoList = queryObj.getResultList();
		if (enderecoList != null && enderecoList.size() > 0) {
			return enderecoList;
		} else {
			return null;
		}

	}

}
