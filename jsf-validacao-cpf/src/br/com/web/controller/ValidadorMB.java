package br.com.web.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "validadorMB")
@RequestScoped
public class ValidadorMB {

	private String cpf;

	public void validar() {
		if (cpf == null || "".equals(cpf)) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("CPF Vazio"));
		} else if (cpf.length() != 11) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("CPF deve ter 11 dígitos"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("CPF Validado com sucesso !!"));
		}
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}