package br.com.triway.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.triway.model.ItemCarrinho;
import br.com.triway.model.Pedido;

public class PedidoDao implements Dao<Pedido, Integer> {
	
	@Inject
	private EntityManager em;
	
/*	public PedidoDao() throws SQLException{
		this.em = PersistenceManager.INSTANCE.getEntityManager();
	}
*/	
	@Override
	public Pedido consultar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alterar(Pedido Serializable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void salvar(Pedido pedido) {
		em.getTransaction().begin();
		pedido.setCliente(em.merge(pedido.getCliente()));
		pedido.getItens().forEach(e->{e.setLivro(em.merge(e.getLivro()));});
		em.persist(pedido);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void remover(Pedido Serializable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Pedido> listar() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Pedido> listar(int codCliente) {
		CriteriaBuilder builder =  em.getCriteriaBuilder();
		CriteriaQuery<Pedido> q = builder.createQuery(Pedido.class);
		Root<Pedido> root = q.from(Pedido.class);
        Predicate predicate = builder.equal(root.get("cliente").get("codigo"), codCliente);
		q.where(predicate);
		TypedQuery<Pedido> pedidos = em.createQuery(q);
		return pedidos.getResultList();
		
	}
	
	public List<ItemCarrinho> listarItem(int codPedido){
		CriteriaBuilder builder =  em.getCriteriaBuilder();
		CriteriaQuery<Pedido> q = builder.createQuery(Pedido.class);	
		Root<Pedido> fromPedido = q.from(Pedido.class);
		q.select(fromPedido);
		q.where(builder.equal(fromPedido.get("codigo"), codPedido));
		
		TypedQuery<Pedido> itens = em.createQuery(q);
		
		return itens.getSingleResult().getItens();
	}

}
