package br.com.triway.controle;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;

import br.com.triway.model.Livro;
import br.com.triway.service.CatalogoService;

@ManagedBean(name = "livroBean")
@SessionScoped
public class LivroBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String RESULTADO = "Resultado";
	private static final String LIVRO = "Livro";
	private static final String SUCESSO = "Sucesso";
	
	private static final String DIRETORIO_UPLOAD = "/home/fabrica/workspaces/Livraria-Web/src/main/webapp/imagens/";
	
	private CatalogoService service;
	private Part file;
	private Livro livro;
	private List<Livro> livros;
	private String titulo;
	private String autor;
	private Double preco;
	private String imagem;
	private String descricao;

	@PostConstruct
	private void init() {
		service = new CatalogoService();
	}

	public String pesquisar() {

		livros = service.consultar(titulo);

		return RESULTADO;
	}

	public String verLivro(int codigo) {

		livro = service.verLivro(codigo);

		return LIVRO;
	}

	public String cadastrar() {
		Livro livro = new Livro();
		livro.setTitulo(titulo.toUpperCase());
		livro.setAutor(autor.toUpperCase());
		livro.setPreco(preco);
		livro.setImagem("imagens/"+getFilename(file));		
		livro.setDescricao(descricao);
		System.out.println("LivroBean.cadastrar()");
		service.cadastroLivro(livro);
		
		return SUCESSO ;
	}

	private static String getFilename(Part part) {
		for (String cd : part.getHeader("content-disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
				return filename.substring(filename.lastIndexOf('/') + 1);
			}
		}
		return null;
	}

	public void upload() {
		try {
			
			file.write(DIRETORIO_UPLOAD + getFilename(file));
			System.out.println(getFilename(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public CatalogoService getService() {
		return service;
	}

	public void setService(CatalogoService service) {
		this.service = service;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
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

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

}