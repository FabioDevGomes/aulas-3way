package com.fabio.mb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean(name = "hello")
public class Hello implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//atributo opcional
	private String message;
	
    @PostConstruct
    public void init(){
        System.out.println(" Método init() executado na inicialização devido a anotação  @PostConstruct ");
    }
     
    public String getMessage(){
        return "Hello World JSF!, retornado pelo método getMessage()";
    }
 
}
