package com.framework.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.framework.db.UsuarioDAO;
import com.framework.model.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioManagedBean {

	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private Usuario usuario = new Usuario();
	private List<Usuario> usuarioListDb = new ArrayList<>();


	@PostConstruct
	public void init() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		String idUsuario = facesContext.getExternalContext().getRequestParameterMap().get("id");
		if(idUsuario != null) {
			this.usuario = usuarioDAO.consultarUsuario(Integer.parseInt(idUsuario));
		}
	}

	public List getUsuarioListDb() {
		return usuarioDAO.listarUsuario();
	}

	public void exlcluirUsuarioDb(Usuario usuario) {
		usuarioDAO.deletarUsuario(usuario);
	}

	public String incluirUsuarioDb(Usuario usuario) {
		if (!usuarioDAO.inserirUsuario(usuario)) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro: Usuário já existe!", null));
			context.getExternalContext().getFlash().setKeepMessages(true);
			
			return "/restrito/novoUsuario.xhtml?faces-redirect=true";
		}
		return "/restrito/main?faces-redirect=true";
	}

	public String paginaEditar(Usuario usuario) {
		return "/restrito/editarUsuario?faces-redirect=true&id="+usuario.getId();
	}

	public String editarUsuarioDb(Usuario usuario) {
		usuarioDAO.alterarUsuario(usuario);
		return "/restrito/main?faces-redirect=true";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setUsuarioListDb(List<Usuario> usuarioListDb) {
		this.usuarioListDb = usuarioListDb;
	}

}
