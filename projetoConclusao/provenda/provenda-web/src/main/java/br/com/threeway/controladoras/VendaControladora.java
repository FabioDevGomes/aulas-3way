package br.com.threeway.controladoras;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.threeway.objeto.CabecalhoVenda;
import br.com.threeway.objeto.ItemVenda;
import br.com.threeway.objeto.Pessoa;
import br.com.threeway.objeto.Produto;
import br.com.threeway.service.PessoaService;
import br.com.threeway.service.ProdutoService;
import br.com.threeway.service.VendaService;

@ManagedBean(name = "vendaControladora")
@SessionScoped
public class VendaControladora {
		
		private List<Pessoa> pessoas = new ArrayList<>();
		private List<Produto> produtos = new ArrayList<>();
		
		private PessoaService pessoaService = new PessoaService();
		private ProdutoService produtoService = new ProdutoService();
		private VendaService vendaService = new VendaService();
		
		private Pessoa pessoaSelecionada = new Pessoa();
		
		private CabecalhoVenda cabecalho = new CabecalhoVenda();
		
		public void inicializarTela() {
			pessoas = pessoaService.consultarTodos();
			produtos = produtoService.consultarTodos();
		}
		
		public void selecionarPessoa(Pessoa pessoa) {
			this.pessoaSelecionada = pessoa;
		}
		
		public void finalizarVenda() {
			
			List<ItemVenda> itens = new ArrayList<>();
			
			cabecalho.setCliente(pessoaSelecionada);
			
			for (Produto produto : produtos) {
				
				if(produto.isSelecionado()) {
					ItemVenda item = new ItemVenda();
					item.setProduto(produto);
					//apresentei o pai ao filho
					item.setCabecalho(cabecalho);
					
					itens.add(item);
				}
				
			}
			
			//apresentei os filhos ao pai
			cabecalho.setItens(itens);
			
			
			vendaService.salvar(cabecalho);
			
		}


		public List<Pessoa> getPessoas() {
			return pessoas;
		}
		public void setPessoas(List<Pessoa> pessoas) {
			this.pessoas = pessoas;
		}
		public List<Produto> getProdutos() {
			return produtos;
		}
		public void setProdutos(List<Produto> produtos) {
			this.produtos = produtos;
		}
		public Pessoa getPessoaSelecionada() {
			return pessoaSelecionada;
		}
		public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
			this.pessoaSelecionada = pessoaSelecionada;
		}

		public CabecalhoVenda getCabecalho() {
			return cabecalho;
		}

		public void setCabecalho(CabecalhoVenda cabecalho) {
			this.cabecalho = cabecalho;
		}
		
		
		
		
}
