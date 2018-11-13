package br.com.threeway.service;

import br.com.threeway.dao.VendaDAO;
import br.com.threeway.objeto.CabecalhoVenda;

public class VendaService {
	
	private VendaDAO vendaDAO = new VendaDAO();
	
	public void salvar(CabecalhoVenda cabecalhoVenda) {
			vendaDAO.salvar(cabecalhoVenda);
	}
	
}
