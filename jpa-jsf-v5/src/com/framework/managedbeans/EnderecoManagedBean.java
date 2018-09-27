package com.framework.managedbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.xml.bind.ValidationException;

import com.framework.db.EnderecoDAO;
import com.framework.model.Endereco;
import com.framework.model.Usuario;
import com.framework.service.EnderecoService;
import com.framework.service.UsuarioService;

@ManagedBean
@SessionScoped
public class EnderecoManagedBean {

	private final String TELA_NOVO_ENDERECO = "/restrito/endereco/novoEnderecoT.xhtml?faces-redirect=true";
	private final String TELA_LISTAGEM_ENDERECO = "/restrito/endereco/listagemEnderecoT?faces-redirect=true";
	private final String TELA_ENDERECO = "/restrito/endereco/novoEnderecoT?faces-redirect=true&id=";

	private Endereco endereco = new Endereco();
	private EnderecoService enderecoService = new EnderecoService();

	private UsuarioService usuarioService = new UsuarioService();
	private Usuario usuario = new Usuario();

	@PostConstruct
	public void init() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Integer idUsuario = (Integer) facesContext.getExternalContext().getSessionMap().get("id");
		if (idUsuario != null) {
			this.setUsuario(usuarioService.consultarUsuario(idUsuario));
		}
	}
	
	public List enderecoListDb() {
		return enderecoService.listarEndereco();
	}

	public void exlcluirEnderecoDb(Endereco endereco) {
		 enderecoService.deletarEndereco(endereco);
	}

	public String incluirEnderecoDb(Endereco endereco) {
		try {
			endereco.setUsuario(usuario);
			enderecoService.salvarEndereco(endereco);
			return TELA_LISTAGEM_ENDERECO;
		} catch (Exception e) {
			e.printStackTrace();

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
			context.getExternalContext().getFlash().setKeepMessages(true);

			return TELA_NOVO_ENDERECO;
		}
	}

	public String editarEnderecoDb(Endereco endereco) {
		// produtoDAO.alterarEndereco();
		return "/restrito/listagemProdutoT?faces-redirect=true";
	}

	public String paginaEndereco(Usuario usuario) {
		this.usuario = usuario;
		this.endereco = new Endereco();

		return TELA_ENDERECO + usuario.getId();
	}

	public Endereco getProduto() {
		return getEndereco();
	}
	

	public void setProduto(Endereco produto) {
		this.setEndereco(produto);
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
