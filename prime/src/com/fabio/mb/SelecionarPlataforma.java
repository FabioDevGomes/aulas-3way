package com.fabio.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class SelecionarPlataforma {
	   
    private String option;
    private List<String> images;
    
    @PostConstruct
    public void init() {
        images = new ArrayList<String>();
        //extrair para método
        for (int i = 1; i <= 5; i++) {
			images.add("jogoXbox" + i + ".jpg");
		}
        //extrair para método
        for (int i = 1; i <= 5; i++) {
			images.add("jogo" + i + ".jpeg");
		}
    }
 
    public List<String> getImages() {
        return images;
    }
     
    public String getOption() {
        return option;
    }
 
    public void setOption(String option) {
    	FacesContext context = FacesContext.getCurrentInstance();
    	String mensagem = "";
    	if(option != null && !option.equals("")) {
    		images = new ArrayList<String>();
    		if(option.equals("Xbox One")) {
    			for (int i = 1; i <= 5; i++) {
    				images.add("jogoXbox" + i + ".jpg");
    			}
    		}else if(option.equals("PS4")) {
    			for (int i = 1; i <= 5; i++) {
    				images.add("jogo" + i + ".jpeg");
    			}
    		}
    		mensagem = "Plataforma selecionada com sucesso";
    	}else {
    		mensagem = "Todas as plataformas selecionadas";
    	}
    	context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Successo",  mensagem) );
        this.option = option;
    }


}
