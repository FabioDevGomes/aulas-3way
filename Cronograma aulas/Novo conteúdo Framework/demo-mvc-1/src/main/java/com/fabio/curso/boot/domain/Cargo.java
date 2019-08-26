package com.fabio.curso.boot.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//transforma essa classe em uma entidade gerenciada pela JPA 
@SuppressWarnings("serial")
@Entity
@Table(name="CARGOS")
public class Cargo extends AbstractEntity<Long>{

	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "id_departamento_fk") //nome da chave estrangeira que teremos na tabela CARGOS
	private Departamento departamento;
	
	//Informa o lado forte (Funcinario) e fraco (Cargo) do relacionamento
	@OneToMany(mappedBy = "cargo")
	private List<Funcionario> funcinarios;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Funcionario> getFuncinarios() {
		return funcinarios;
	}

	public void setFuncinarios(List<Funcionario> funcinarios) {
		this.funcinarios = funcinarios;
	}
	
}
