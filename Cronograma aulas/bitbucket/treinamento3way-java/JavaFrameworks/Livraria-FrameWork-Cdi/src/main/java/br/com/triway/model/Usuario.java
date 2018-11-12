package br.com.triway.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="USUARIO")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COD_USER")
	private int codigo;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="COD_CLIENTE", foreignKey=@ForeignKey(name="fk_cliente_usuario"))
	private Cliente cliente;
	

	@Column(name="NOME",length=32)
	private String nome;
	
	
	@Column(name="LOGIN",length=32)
	private String login;
	
	@Column(name="SENHA",length=10)
	private String senha;
	
	@Transient
	private boolean autenticacao;

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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isAutenticacao() {
		return autenticacao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setAutenticacao(boolean autenticacao) {
		this.autenticacao = autenticacao;
	}
	
	
}
