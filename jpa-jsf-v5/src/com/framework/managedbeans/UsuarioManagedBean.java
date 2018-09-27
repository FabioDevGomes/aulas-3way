package com.framework.managedbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.xml.bind.ValidationException;

import com.framework.db.UsuarioDAO;
import com.framework.model.Usuario;
import com.framework.service.UsuarioService;

@ManagedBean
@ViewScoped
public class UsuarioManagedBean {

	private final String TELA_NOVO_USUARIO = "/restrito/novoUsuario.xhtml?faces-redirect=true";
	private final String TELA_LISTAGEM_USUARIO = "/restrito/listagemUsuarioT?faces-redirect=true";
	private final String TELA_EDITAR_USUARIO = "/restrito/editarUsuarioT?faces-redirect=true&id=";
	
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private Usuario usuario = new Usuario();
	private UsuarioService usuarioService = new UsuarioService();

	@PostConstruct
	public void init() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		String id = facesContext.getExternalContext().getRequestParameterMap().get("id");
		if(id != null) {
			Integer idUsuario = Integer.parseInt(facesContext.getExternalContext().getRequestParameterMap().get("id"));
			this.usuario = usuarioDAO.getUsuario(idUsuario);
		}
	}

	public List usuarioListDb() {
		return usuarioDAO.listarUsuario();
	}

	public void exlcluirUsuarioDb(Usuario usuario) {
		usuarioDAO.deletarUsuario(usuario);
	}

	public String incluirUsuarioDb(Usuario usuario) {
		try {
			usuarioService.salvarUsuario(usuario);
			return TELA_LISTAGEM_USUARIO;
		} catch (Exception e) {
			e.printStackTrace();

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "--"));
			context.getExternalContext().getFlash().setKeepMessages(true);
			
			return TELA_NOVO_USUARIO;
		}
	}

	public String paginaEditar(Usuario usuario) {
		try {
			usuarioService.telaEdicao(this.usuario);
			this.usuario = usuario;
			
		} catch (ValidationException e) {
			e.printStackTrace();

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "--"));
			context.getExternalContext().getFlash().setKeepMessages(true);
			
			return TELA_LISTAGEM_USUARIO;
		}
		
		return TELA_EDITAR_USUARIO+usuario.getId();
	}

	public String editarUsuarioDb(Usuario usuario) {
		usuarioDAO.alterarUsuario();
		return "/restrito/listagemUsuarioT?faces-redirect=true";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
