package br.com.threeway.service;

import java.util.List;

import br.com.threeway.dao.ProdutoDAO;
import br.com.threeway.objeto.Produto;

public class ProdutoService {
	
	private ProdutoDAO produtoDAO = new ProdutoDAO();
	
	public void salvar(Produto produto) {
		produtoDAO.salvar(produto);
	}
	
	public List<Produto> consultarTodos(){
		return produtoDAO.consultarTodos();
	}

}
