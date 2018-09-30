package com.framework.service;

import java.util.List;

import javax.xml.bind.ValidationException;

import com.framework.db.EnderecoDAO;
import com.framework.model.Endereco;
import com.framework.model.Usuario;

public class EnderecoService {
	
	private EnderecoDAO enderecoDAO = new EnderecoDAO();
	
	public void telaEdicao(Usuario usuario) throws ValidationException {
		if(!usuario.getMatricula().startsWith("ADM")) {
			throw new ValidationException("Somente usu�rio com perfil ADM podem acessar a p�gina de edi��o");
		}
	}

	public void salvarEndereco(Endereco endereco) throws ValidationException {
		enderecoDAO.inserirEndereco(endereco);
	}
	
	public List listarEndereco() {
		return enderecoDAO.listarEndereco();
	}

	public void deletarEndereco(Endereco endereco) {
		enderecoDAO.deletarEndereco(endereco);
	}
	

}
