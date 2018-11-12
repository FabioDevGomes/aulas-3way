package br.com.triway.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.triway.dao.UsuarioDao;
import br.com.triway.model.Usuario;

public class LoginService implements Serializable {

	@Inject
	private UsuarioDao dao;

	public Usuario autenticar(String login, String senha, boolean autenticar) {
		Usuario user = new Usuario();
		user.setLogin(login);
		user.setSenha(senha);
		user = dao.autenticar(user);
		if (user != null) {
			user.setAutenticacao(autenticar);
		}

		return user;
	}
}
