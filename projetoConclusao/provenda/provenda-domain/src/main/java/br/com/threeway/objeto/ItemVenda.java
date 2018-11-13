package br.com.threeway.objeto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class ItemVenda {
	
	@Id
	@GeneratedValue(generator="item_venda_gerador")
	@SequenceGenerator(name="item_venda_gerador", sequenceName="sequence_item_venda", 
		allocationSize = 1)
	private long codigo;
	
	@ManyToOne
	@JoinColumn(name="id_cabecalho")
	private CabecalhoVenda cabecalho = new CabecalhoVenda();
	
	@OneToOne
	private Produto produto = new Produto();

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public CabecalhoVenda getCabecalho() {
		return cabecalho;
	}

	public void setCabecalho(CabecalhoVenda cabecalho) {
		this.cabecalho = cabecalho;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
	

}
