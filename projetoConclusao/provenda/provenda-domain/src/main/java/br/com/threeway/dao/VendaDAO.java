package br.com.threeway.dao;

import br.com.threeway.objeto.CabecalhoVenda;
import br.com.threeway.objeto.Pessoa;

public class VendaDAO extends SuperDAO {
	
	public void salvar(CabecalhoVenda cabecalhoVenda) {
		
		em.getTransaction().begin();
		em.persist(cabecalhoVenda);
		em.getTransaction().commit();
		
	}
	


}
