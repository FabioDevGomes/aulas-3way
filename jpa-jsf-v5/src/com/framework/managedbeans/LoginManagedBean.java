package com.framework.managedbeans;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.framework.db.UsuarioDAO;
import com.framework.model.Usuario;
import com.framework.service.UsuarioService;

@ManagedBean(name="loginMB")
@ViewScoped
public class LoginManagedBean {

	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private Usuario usuario = new Usuario();
	
	@ManagedProperty("#{usuarioService}")
	private UsuarioService usuarioService;

	public String enviar() {
//		usuario = usuarioDAO.getUsuario(usuario.getNomeUsuario(), getUsuarioService().encriptarSenha(usuario.getSenha()));
		usuario = usuarioDAO.getUsuario(usuario.getNomeUsuario(), usuario.getSenha());
		FacesContext context = FacesContext.getCurrentInstance();
		if (usuario == null) {
			usuario = new Usuario();
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!", "Erro no Login!"));
			context.validationFailed();
			
			return null;
		} else {
			
			ExternalContext externalContext = context.getExternalContext();
			Map<String, Object> sessionMap = externalContext.getSessionMap();
			sessionMap.put("id", usuario.getId());
			
			externalContext.getSessionMap().put("logado", true);
			
			return "/restrito/listagemUsuarioT.xhtml?faces-redirect=true";
		}
	}

	// Realiza o logout do usuário logado
	public String logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().remove("logado");
		return "/login/login.xhtml?faces-redirect=true";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

}