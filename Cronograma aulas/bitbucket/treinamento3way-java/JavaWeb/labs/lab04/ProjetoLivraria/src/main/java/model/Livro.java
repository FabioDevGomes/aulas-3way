package model;

public class Livro {

	private int codigo;
	private String titulo;
	private String autor;
	private double preco;
	private String imagem;
	private String descricao;
	
	public void setCodigo(int cod){
		codigo = cod;
	}
	public void setTitulo(String tit){
		titulo = tit;
	}
	public void setAutor(String aut){
		autor = aut;
	}
	public void setPreco(double pre){
		preco = pre;
	}
	public void setImagem(String img){
		imagem = img;
	}
	public void setDescricao(String desc){
		descricao = desc;
	}
	public double getPreco() {
		return preco;
	}
	public String getDescricao() {
		return descricao;
	}
}
