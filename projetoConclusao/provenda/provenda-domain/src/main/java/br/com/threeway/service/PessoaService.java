package br.com.threeway.service;

import java.util.List;

import br.com.threeway.dao.PessoaDAO;
import br.com.threeway.objeto.Pessoa;

public class PessoaService {
	
	private PessoaDAO pessoaDAO = new PessoaDAO();
	
	public void salvar(Pessoa pessoa) {
			pessoaDAO.salvar(pessoa);
	}
	
	public List<Pessoa> consultarTodos(){
		return pessoaDAO.consultarTodos();
	}

	public void excluir(Pessoa pessoa) {
		pessoaDAO.deletar(pessoa);
}
}
