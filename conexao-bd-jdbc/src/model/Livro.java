package model;

public class Livro {
	private int codigo;
	private String titulo;
	private String autor;
	private double preco;
	private String imagem;
	private String descricao;


	public void setPreco(double pre) {
		preco = pre;
	}

	public void setImagem(String img) {
		imagem = img;
	}

	public void setDescricao(String desc) {
		descricao = desc;
	}

	public double getPreco() {
		return preco;
	}

	public String getDescricao() {
		return descricao;
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

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
}
