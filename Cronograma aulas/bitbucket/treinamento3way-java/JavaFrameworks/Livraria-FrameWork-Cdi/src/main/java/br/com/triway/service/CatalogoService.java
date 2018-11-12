package br.com.triway.service;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;

import br.com.triway.dao.LivroDao;
import br.com.triway.model.Livro;

public class CatalogoService implements Serializable {
	private static final long serialVersionUID = 1L;

	private Logger LOG = Logger.getLogger(CatalogoService.class.getName());
	private Livro livro;
	private List<Livro> livros = new ArrayList<Livro>();

	@Inject
	private LivroDao dao;

	public List<Livro> consultar(String titulo) {

		if (titulo == null) {
			titulo = "";
		}
		LOG.info("Pesquisa: " + titulo);
		livros = dao.consultar(titulo);

		if (livros.size() <= 0) {
			System.out.println("Livro não localizado");
		}
		return livros;
	}

	public Livro verLivro(Integer codigo) {
		livro = dao.consultar(codigo);
		return livro;
	}

	public void cadastroLivro(Livro livro) {
		dao.salvar(livro);
	}

}
