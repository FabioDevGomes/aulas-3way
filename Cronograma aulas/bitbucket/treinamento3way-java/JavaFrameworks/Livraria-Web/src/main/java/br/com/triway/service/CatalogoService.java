package br.com.triway.service;

import java.util.List;

import br.com.triway.dao.LivroDao;
import br.com.triway.model.Livro;

public class CatalogoService {

	public List<Livro> consultar(String titulo) {
		if (titulo == null) {
			titulo = "";
		}

		LivroDao dao = new LivroDao();
		List<Livro> livros = dao.consultar(titulo);

		if (livros.size() <= 0) {
			System.out.println("Livro não localizado");
		}
		return livros;
	}

	public Livro verLivro(Integer codigo) {
		LivroDao dao = new LivroDao();
		Livro livro = dao.consultar(codigo);
		return livro;
	}

	public void cadastroLivro(Livro livro) {
		LivroDao dao = new LivroDao();
		dao.salvar(livro);
	}
}
