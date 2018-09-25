package com.framework.managedbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.xml.bind.ValidationException;

import com.framework.db.ProdutoDAO;
import com.framework.model.Produto;
import com.framework.service.ProdutoService;

@ManagedBean
@SessionScoped
public class ProdutoManagedBean {

	private final String TELA_NOVO_PRODUTO = "/restrito/produto/novoProduto.xhtml?faces-redirect=true";
	private final String TELA_LISTAGEM_PRODUTO = "/restrito/produto/listagemProdutoT?faces-redirect=true";
	private final String TELA_EDITAR_PRODUTO = "/restrito/produto/editarProdutoT?faces-redirect=true&id=";
	
	private ProdutoDAO produtoDAO = new ProdutoDAO();
	private Produto produto = new Produto();
	private ProdutoService produtoService = new ProdutoService();


	public List produtoListDb() {
		return produtoDAO.listarProduto();
	}

	public void exlcluirProdutoDb(Produto produto) {
		produtoDAO.deletarProduto(produto);
	}

	public String incluirProdutoDb(Produto produto) {
		try {
			produtoService.salvarProduto(produto);
			return TELA_LISTAGEM_PRODUTO;
		} catch (Exception e) {
			e.printStackTrace();

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
			context.getExternalContext().getFlash().setKeepMessages(true);
			
			return TELA_NOVO_PRODUTO;
		}
	}

//	public String paginaEditar(Produto produto) {
//		try {
//			produtoService.telaEdicao(this.produto);
//			this.produto = produto;
//			
//		} catch (ValidationException e) {
//			e.printStackTrace();
//
//			FacesContext context = FacesContext.getCurrentInstance();
//			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "--"));
//			context.getExternalContext().getFlash().setKeepMessages(true);
//			
//			return TELA_LISTAGEM_USUARIO;
//		}
//		
//		return TELA_EDITAR_USUARIO+produto.getCodigo();
//	}

	public String editarProdutoDb(Produto produto) {
		produtoDAO.alterarProduto();
		return "/restrito/listagemProdutoT?faces-redirect=true";
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
