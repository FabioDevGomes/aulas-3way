package com.framework.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Usuario {
       
      @Id
      @GeneratedValue(strategy=GenerationType.IDENTITY)
      @Column(name="id", nullable=false, unique=true)
      private int id;
       
      @Column(name="userName", nullable=false, unique=true)
      private String nomeUsuario;
      
      @Column(name="matricula")
      private String matricula;
       
      @Column(name="password", nullable=false, unique=false)
      private String senha;
  
      @Column(name="lastAccess")
      @Temporal(TemporalType.DATE)
      private Date ultimoAcesso;
       
      public String getNomeUsuario() {
            return nomeUsuario;
      }
       
      public void setNomeUsuario(String nomeUsuario) {
            this.nomeUsuario = nomeUsuario;
      }
       
      public String getSenha() {
            return senha;
      }
       
      public void setSenha(String senha) {
            this.senha = senha;
      }
       
      public Date getUltimoAcesso() {
            return ultimoAcesso;
      }
       
      public void setUltimoAcesso(Date ultimoAcesso) {
            this.ultimoAcesso = ultimoAcesso;
      }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
 }
