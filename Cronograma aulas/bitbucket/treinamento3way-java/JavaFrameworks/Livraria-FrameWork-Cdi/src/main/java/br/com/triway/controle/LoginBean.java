package br.com.triway.controle;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.triway.model.Usuario;
import br.com.triway.service.LoginService;

@Named("loginBean")
@SessionScoped
public class LoginBean implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	private static final Logger LOGGER = Logger.getLogger(LoginBean.class.getName());
	private static final String HOME = "Home";
	private static final String LOGIN = "Login";
	
	private String login, senha;
	private boolean isAutenticado;
	private Usuario usuario;
	
	@Inject
	private LoginService loginService;
	
	@PostConstruct
	private void init(){
		//loginService = new LoginService();
	}
	
	public String autenticar(){
		
		FacesMessage msg = null;

		usuario = loginService.autenticar(login,senha,true);
		isAutenticado = usuario != null && usuario.isAutenticacao();
		
		if(! isAutenticado){
			msg = new FacesMessage("Login incorreto");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			LOGGER.info("Senha ou Usuario incorretos");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return LOGIN;
		}else{

			LOGGER.info("Cliente "+usuario.getNome()+ " Autenticado!");
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", usuario);
			return HOME;
		}

	}
	
	public String sair(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		 
		usuario = loginService.autenticar(login,senha,false);
		isAutenticado = usuario != null && usuario.isAutenticacao();
		
		if(isAutenticado){
			FacesMessage msg = new FacesMessage("Login incorreto");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			LOGGER.info("Senha ou Usuario incorretos");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return LOGIN;
		}
		LOGGER.info("Cliente "+usuario.getNome()+" saiu da sessão!");
		return HOME;		
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isAutenticado() {
		return isAutenticado;
	}

	public void setAutenticado(boolean isAutenticado) {
		this.isAutenticado = isAutenticado;
	}
	
	



}
