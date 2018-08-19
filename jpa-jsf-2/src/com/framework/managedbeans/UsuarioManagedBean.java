package com.framework.managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.framework.db.UsuarioDAO;
import com.framework.model.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioManagedBean {
	
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private Usuario usuario = new Usuario();
	
	public List usuarioListDb() {
		return usuarioDAO.listarUsuario();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
