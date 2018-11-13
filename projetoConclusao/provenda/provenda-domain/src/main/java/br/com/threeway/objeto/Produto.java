package br.com.threeway.objeto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue(generator="produto_gerador")
	@SequenceGenerator(name="produto_gerador", sequenceName="sequence_produto", 
		allocationSize = 1)
	private long codigo;
	private String descricao;
	
	@Transient
	private boolean selecionado = false ;
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isSelecionado() {
		return selecionado;
	}
	public void setSelecionado(boolean selecionado) {
		this.selecionado = selecionado;
	}
	
	
	
	

}
