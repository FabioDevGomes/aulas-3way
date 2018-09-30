package com.framework.service;

import javax.xml.bind.ValidationException;

import com.framework.db.UsuarioDAO;
import com.framework.model.Usuario;

public class UsuarioService {
	
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	public void telaEdicao(Usuario usuario) throws ValidationException {
		if(!usuario.getMatricula().startsWith("ADM")) {
			throw new ValidationException("Somente usu�rio com perfil ADM podem acessar a p�gina de edi��o");
		}
	}

	public void salvarUsuario(Usuario usuario) throws ValidationException {
		this.validarMatricula(usuario);
		if(!usuarioDAO.inserirUsuario(usuario)) {
			throw new ValidationException("Usuario j� existe");
		}
	}
	
	public Usuario consultarUsuario(Integer idUsuario) {
		return usuarioDAO.getUsuario(idUsuario);
	}
	
	public void mergeUsuario(Usuario usuario) {
		usuarioDAO.mergeUsuario(usuario);
	}
	
	private void validarMatricula(Usuario usuario) throws ValidationException {
		if(!usuario.getMatricula().startsWith("M") && !usuario.getMatricula().startsWith("ADM")) {
			throw new ValidationException("A matr�cula do usu�rio de iniciar com M ou ADM!");
		}
	}

	public void deletarUsuario(Usuario usuario) {
		usuarioDAO.deletarUsuario(usuario);
	}
	

}
