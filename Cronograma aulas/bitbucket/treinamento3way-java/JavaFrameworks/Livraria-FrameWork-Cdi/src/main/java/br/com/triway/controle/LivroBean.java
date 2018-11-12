package br.com.triway.controle;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;

import br.com.triway.model.Livro;
import br.com.triway.service.CatalogoService;

@Named("livroBean")
@SessionScoped
public class LivroBean implements Serializable {

	private Logger LOG = Logger.getLogger(LivroBean.class.getName());
	private String titulo, autor, imagem, descricao;
	private double preco;
	private Part file;
	private Livro livro;
	private List<Livro> livros;
	private static final String RESULTADO = "Resultado";
	private static final String LIVRO = "Livro";
	private static final String SUCESSO = "TesteLivro";
	
	@Inject
	private CatalogoService service;

	@PostConstruct
	private void init() {
		//service = new CatalogoService();
		LOG.info("LivroBean.init()");
	}

	public String pesquisar() {
		livros = null;
		livros = service.consultar(titulo);
		titulo = "";
		return RESULTADO;
	}

	public String verLivro(int codigo) {
		LOG.info("LivroBean.verLivro()");
		livro = service.verLivro(codigo);

		return LIVRO;
	}

	public String cadastrar() {
		Livro livro = new Livro();

		livro.setTitulo(titulo.toUpperCase());
		livro.setAutor(autor.toUpperCase());
		livro.setPreco(preco);
		livro.setImagem("imagens/" + getFilename(file));
		livro.setDescricao(descricao);
		LOG.info("LivroBean.cadastrar()");
		service.cadastroLivro(livro);
		return SUCESSO;
	}

	public void upload() {

		try {
			// file.write para salvar a imagem na pasta desejada
			file.write("/home/fabrica-jorge/link-imagens/" + getFilename(file));
			LOG.info(getFilename(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String getFilename(Part part) {
		// filtrar nome do arquivo recebido pelo navegador
		for (String cd : part.getHeader("content-disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
				return filename.substring(filename.lastIndexOf('/') + 1);
			}
		}
		return null;
	}

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

}
