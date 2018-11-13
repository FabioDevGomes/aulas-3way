package br.com.threeway.controladoras;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.threeway.objeto.Pessoa;
import br.com.threeway.objeto.Produto;
import br.com.threeway.service.PessoaService;
import br.com.threeway.service.ProdutoService;

@ManagedBean(name = "produtoControladora")
@SessionScoped
public class ProdutoControladora {
		
	private Produto produto = new Produto();
	private List<Produto> produtos = new ArrayList<Produto>();
	
	private ProdutoService produtoService = new ProdutoService();
	
	public void salvar() {
		try {
			produtoService.salvar(produto);
			produto = new Produto();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Produto Salvo Com Sucesso", "Ok"));
		}catch (Exception e) {
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erro ao salvar Produto", e.getMessage()));
			
		}
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	

}
