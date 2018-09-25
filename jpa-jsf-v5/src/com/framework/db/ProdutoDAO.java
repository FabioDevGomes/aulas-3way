package com.framework.db;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.framework.model.Produto;

@Named
@ApplicationScoped
public class ProdutoDAO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("usuarios");
	private EntityManager em = factory.createEntityManager();
	private EntityTransaction transaction = em.getTransaction();

	@SuppressWarnings("unchecked")
	public List<Produto> listarProdutosDescricao(String descricaoProduto) {

		List<Produto> produtos = new ArrayList<>();
		try {
			produtos = (List<Produto>) em
					.createQuery("SELECT u from Produto u where u.descricao = LIKE CONCAT('%',:descricao,'%') ")
					.setParameter("descricao", descricaoProduto).getResultList();

			return produtos;
		} catch (NoResultException e) {
			return null;
		}
	}

	public Produto getProduto(int id) {
		try {
			return em.find(Produto.class, id);
		} catch (NoResultException e) {
			return null;
		}
	}

	public void alterarProduto() {
		transaction.begin();
		transaction.commit();
	}

	public boolean inserirProduto(Produto usuario) {
		if (!transaction.isActive()) {
			transaction.begin();
		}

		try {
			em.persist(usuario);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deletarProduto(Produto usuario) {
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

	public List listarProduto() {

		Query queryObj = em.createQuery("SELECT u FROM Produto u");
		List usuariosList = queryObj.getResultList();
		if (usuariosList != null && usuariosList.size() > 0) {
			return usuariosList;
		} else {
			return null;
		}

	}

}
