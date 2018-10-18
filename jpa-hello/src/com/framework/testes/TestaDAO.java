package com.framework.testes;

import java.util.List;

import com.framework.dao.PessoaDao;
import com.framework.model.Pessoa;

public class TestaDAO {
	static PessoaDao pessoaDao = PessoaDao.getInstance();

	public static void main(String[] args) {
//		implementar depois extrair para métodos
		
		incluirPessoa();
		alterarPessoa();
		
		pessoaDao.removeById(1);
		
		listarTodasPessoas();
		
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
		pessoa.setNome("Outro cara");
		
		pessoaDao.persist(pessoa);
	}

	private static void alterarPessoa() {
		Pessoa pessoaAlterar = pessoaDao.getById(2);
		pessoaAlterar.setNome("Outro cara alterado");
		
		pessoaDao.merge(pessoaAlterar);
	}

}
