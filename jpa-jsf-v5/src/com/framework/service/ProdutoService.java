package com.framework.service;

import javax.xml.bind.ValidationException;

import com.framework.db.ProdutoDAO;
import com.framework.model.Produto;
import com.framework.model.Usuario;

public class ProdutoService {
	
	private ProdutoDAO produtoDAO = new ProdutoDAO();
	
	public void telaEdicao(Usuario usuario) throws ValidationException {
		if(!usuario.getMatricula().startsWith("ADM")) {
			throw new ValidationException("Somente usuário com perfil ADM podem acessar a página de edição");
		}
	}

	public void salvarProduto(Produto produto) throws ValidationException {
		this.validarMatricula(produto);
		if(!produtoDAO.inserirProduto(produto)) {
			throw new ValidationException("produto já cadastrado");
		}
	}
	
	private void validarMatricula(Produto produto) throws ValidationException {
		if(produto.getQuantidade() < 10) {
			throw new ValidationException("A quantidade mínima de produtos deve ser 10!");
		}
	}
	

}
