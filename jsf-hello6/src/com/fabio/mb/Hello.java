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
	
    @PostConstruct
    public void init(){
        System.out.println(" M�todo init() executado na inicializa��o devido a anota��o  @PostConstruct ");
    }
     
    public String getMessage(){
        return "Hello World JSF! 444";
    }
    
    public String getMessage2(){
        return "Hello World JSF! 555";
    }
 
}
