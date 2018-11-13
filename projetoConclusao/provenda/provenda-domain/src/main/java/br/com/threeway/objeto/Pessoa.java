package br.com.threeway.objeto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Pessoa {
	
	@Id
	@GeneratedValue(generator="pessoa_gerador")
	@SequenceGenerator(name="pessoa_gerador", sequenceName="sequence_pessoa", 
		allocationSize = 1)
	private long codigo;
	private String nome;
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
