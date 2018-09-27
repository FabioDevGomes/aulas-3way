package com.framework.service;

import java.util.List;

import javax.xml.bind.ValidationException;

import com.framework.db.EnderecoDAO;
import com.framework.model.Endereco;
import com.framework.model.Usuario;

public class EnderecoService {
	
	private EnderecoDAO produtoDAO = new EnderecoDAO();
	
	public void telaEdicao(Usuario usuario) throws ValidationException {
		if(!usuario.getMatricula().startsWith("ADM")) {
			throw new ValidationException("Somente usuário com perfil ADM podem acessar a página de edição");
		}
	}

	public void salvarEndereco(Endereco produto) throws ValidationException {
		this.validarMatricula(produto);
		produtoDAO.inserirEndereco(produto);
	}
	
	private void validarMatricula(Endereco produto) throws ValidationException {
//		if(produto.getQuantidade() < 10) {
//			throw new ValidationException("A quantidade mínima de produtos deve ser 10!");
//		}
	}

	public List listarEndereco() {
		return produtoDAO.listarEndereco();
	}

	public void deletarEndereco(Endereco endereco) {
		produtoDAO.deletarEndereco(endereco);
	}
	

}
