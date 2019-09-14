package com.framework.testes;

import java.util.List;

import com.framework.dao.PessoaDao;
import com.framework.model.Pessoa;

public class TestaPessoaDAO {
	static PessoaDao pessoaDao = PessoaDao.getInstance();

	
	public static void main(String[] args) {
		incluirPessoa();
		System.out.println("testando instâncias do padrão Singleton");
	}
	
	private static void listarTodasPessoas() {
		List<Pessoa> todasPessoaJPA = pessoaDao.findAll();
		for (Pessoa pessoaLaco : todasPessoaJPA) {
			//implementar toString() via suporte da ferramenta
			System.out.println(pessoaLaco);
		}
	}

	private static void incluirPessoa() {
		Pessoa pessoa = new Pessoa();
		pessoa.setCpf("456123789");
		pessoa.setNome("Outro cara 24");
		
		pessoaDao.persist(pessoa);
	}
	

//	private static void alterarPessoa() {
//		Pessoa pessoaAlterar = pessoaDao.getById(2);
//		pessoaAlterar.setNome("Outro cara alterado");
//		
//		pessoaDao.merge(pessoaAlterar);
//	}

}
