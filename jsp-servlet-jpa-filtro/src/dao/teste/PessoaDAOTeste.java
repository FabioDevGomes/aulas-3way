package dao.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.web.dao.PessoaDAO;
import com.web.model.Pessoa;

public class PessoaDAOTeste {

	public static void main(String[] args) throws Exception {
		System.out.println("===========");
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Rafael Sakurai");
		Calendar data = new GregorianCalendar();
		data.set(Calendar.YEAR, 1983);
		data.set(Calendar.MONTH, 11);
		data.set(Calendar.DAY_OF_MONTH, 26);
		pessoa.setDataNascimento(data.getTime());
		pessoa.setEmail("rafael.sakurai@metodista.br");

		PessoaDAO dao = new PessoaDAO();
		System.out.println("Salvando a pessoa: " + pessoa.getNome());
		pessoa = dao.salvar(pessoa);

		pessoa.setNome("Rafael Guimarães Sakurai");
		pessoa = dao.salvar(pessoa);
		System.out.println("Alterando a pessoa: " + pessoa.getNome());

		Pessoa pessoa2 = dao.consultarPorId(pessoa.getId());
		System.out.println("Consultando: " + pessoa2.getNome());

		System.out.println("Removendo a pessoa: " + pessoa.getId());
		dao.excluir(pessoa.getId());
		System.out.println("===========");
	}

}
