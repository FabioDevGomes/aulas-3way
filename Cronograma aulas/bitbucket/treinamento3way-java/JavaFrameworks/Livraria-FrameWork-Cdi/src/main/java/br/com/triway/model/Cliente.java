package br.com.triway.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="CLIENTE")
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COD_CLIENTE")
	private int codigo;
	
	@Column(name="NOME",length=32)
	private String nome;
	
	@Column(name="ENDERECO",length=25)
	private String endereco;
	
	@Column(name="CIDADE",length=25)
	private String cidade;
	
	@Column(name="BAIRRO",length=25)
	private String bairro;
	
	@Column(name="ESTADO",length=32)
	private String estado;
	
	@Column(name="CEP",length=10)
	private String cep;
	
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}


	
}
