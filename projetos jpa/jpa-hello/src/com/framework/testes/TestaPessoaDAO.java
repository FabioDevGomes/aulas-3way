package com.framework.testes;

import java.util.List;

import com.framework.dao.PessoaDao;
import com.framework.model.Pessoa;

public class TestaPessoaDAO {
	static PessoaDao pessoaDao = PessoaDao.getInstance();

	
	public static void main(String[] args) {
		incluirPessoa();
	}
		
	
	private static void incluirPessoa() {
		//Criar objeto Pessoa
		//setar CPF
		//setar Nome
		//chamar o método persist() passando o objeto pessoa como parâmetro

		Pessoa pessoa = new Pessoa();
		pessoa.setCpf("456.123.789-88");
		pessoa.setNome("Jhon Connor");
		
		pessoaDao.persist(pessoa);
	}
	
	private static void buscarPessoaPorId() {
		//chamar getById() e atribuir resultado para uma variável
		//do tipo Pessoa >> Pessoa p = pessoaDao.getById(8888);
		
		//imprimir variável
	}
	
	
	
	
	

	
	private static void listarTodasPessoas() {
		List<Pessoa> todasPessoaJPA = pessoaDao.findAll();
		for (Pessoa pessoaLaco : todasPessoaJPA) {
			System.out.println(pessoaLaco);
		}
	}
	
	private static void alterarPessoa() {
		Pessoa pessoaAlterar = new Pessoa();
		pessoaAlterar.setId(1);
		pessoaAlterar.setCpf("NOVO CPF");
		pessoaAlterar.setNome("NOVO NOME");
		
		pessoaDao.merge(pessoaAlterar);
	}

}
