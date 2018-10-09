package com.fabio.mb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean(name = "helloMapeamento")
public class Hello implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String message;
	private String message2;
	private String nomeCompleto;
	
    @PostConstruct
    public void init(){
        System.out.println(" Método init() executado na inicialização devido a anotação  @PostConstruct ");
        nomeCompleto = "Fábio Alves Gomes";
    }
     
    public String getMessage(){
        return "Hello World JSF! 444";
    }
    
    public String getMessage2(){
        return "Hello World JSF! 555";
    }

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
 
}
