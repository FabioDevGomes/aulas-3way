package br.com.threeway.controladoras;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.com.threeway.objeto.Pessoa;
import br.com.threeway.service.PessoaService;

@ManagedBean(name = "pessoaControladora")
@SessionScoped
public class PessoaControladora {
		
	private Pessoa pessoa = new Pessoa();
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	
	private PessoaService pessoaService = new PessoaService();
	
	ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

	
	public void salvar() {
		try {
			pessoaService.salvar(pessoa);
			pessoa = new Pessoa();
			
			pessoas = pessoaService.consultarTodos();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Pessoa Salva Com Sucesso", "Ok"));
		}catch (Exception e) {
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erro ao salvar pessoa", e.getMessage()));
			
		}
	}
	
	public void consultarTodos() {
		pessoas = pessoaService.consultarTodos();
	}
	
	public void editar(Pessoa pessoaEditar) {
		
		try {
		pessoa = pessoaEditar;
			externalContext.redirect(externalContext.getRequestContextPath() + 
					"/paginas/pessoaCadastro.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void excluir (Pessoa pessoaExcluir) {
		
		pessoaService.excluir(pessoaExcluir);
		
		pessoas = pessoaService.consultarTodos();
		
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
	

}
