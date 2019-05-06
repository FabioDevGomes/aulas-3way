package com.fabio.mb;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean(name = "helloMapeamento")
public class Hello  {
	
	private String message;
	private String message2;
	private String nomeCompleto;
	
    @PostConstruct
    public void init(){
        System.out.println(" Método init() executado na inicialização devido a anotação  @PostConstruct ");
        nomeCompleto = "Fábio Alves Gomes";
        message = "Primeira mensagem no atributo do Managed Bean";
        message2 = "Segunda mensagem no atributo do Managed Bean";
    }
     
    public String getMessage(){
        return message;
    }
    
    public String getMessage2(){
        return message2;
    }

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
 
}
