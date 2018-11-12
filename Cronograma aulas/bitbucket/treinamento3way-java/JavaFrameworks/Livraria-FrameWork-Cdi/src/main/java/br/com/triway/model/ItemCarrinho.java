package br.com.triway.model;

import javax.persistence.*;

@Entity
@Table(name="ITEM_PEDIDO")
public class ItemCarrinho {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COD_ITEM")
	private int codigo;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="COD_LIVRO", foreignKey=@ForeignKey(name="fk_item_pedido_livro"))
	private Livro livro;
	
	@Transient
	private double valor;
	
	private int qtd=1;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public double getValor() {
		return livro != null ? livro.getPreco()*qtd:0.0;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	@Override
	public int hashCode() {
		final int prime=31;
		int result = 1;
		result = prime*result+((livro==null)?0:livro.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		ItemCarrinho other = (ItemCarrinho) obj;
		if(livro == null){
			if(other.livro != null)
				return false;
		}else if(!livro.equals(other.livro))
			return false;
		return true;
	}
}
