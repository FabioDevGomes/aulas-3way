package br.com.triway.controle;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.triway.model.Carrinho;
import br.com.triway.model.EnumTipoPagamento;
import br.com.triway.model.ItemCarrinho;
import br.com.triway.model.Usuario;
import br.com.triway.service.CompraService;

@Named("carrinhoBean")
@SessionScoped
public class CarrinhoBean implements Serializable {
	
	@Inject
	private Carrinho carrinho;
	private EnumTipoPagamento pagamento;
	private String cartao;
	private static final String CARRINHO = "Carrinho";

	@Inject
	private CompraService compraService;

	@Inject
	private LoginBean loginBean;
	
	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	@PostConstruct
	private void init(){
		//compraService = new CompraService();
	}
	
	private Carrinho getInstanciaCarrinho(){
/*		if(carrinho == null){
			carrinho = new Carrinho();
		}
*/		return carrinho;
	}
	
	public String adicionarLivroCarrinho(int codigo){
		ItemCarrinho item;
		item = compraService.novoItemCarrinho(codigo);
		getInstanciaCarrinho().adicionar(item);
		return CARRINHO;
	}
	
	public void adicionar(int codigo){
		carrinho.adicionar(codigo);
	}
	
	public void retirar(int codigo){
		carrinho.subtrair(codigo);
	}
	
	public void remover(int codigo){
		carrinho.remover(codigo);
	}
	
	public boolean finalizarCompra(){
		FacesMessage mensagem = null;
		Usuario user = loginBean.getUsuario();
		if(user == null || ! user.isAutenticacao()){
			mensagem = new FacesMessage("Faça seu login antes de concluir a compra");
			mensagem.setSeverity(FacesMessage.SEVERITY_WARN);
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
			return false;
		}
		return compraService.efetivarPedido(user.getCliente(), carrinho, pagamento , cartao);
	}
	
	
	public boolean getCarrinhoVazio(){
		if(getInstanciaCarrinho().getItens().size() == 0)
			return false;
		return true;
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public EnumTipoPagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(EnumTipoPagamento pagamento) {
		this.pagamento = pagamento;
	}

	public String getCartao() {
		return cartao;
	}

	public void setCartao(String cartao) {
		this.cartao = cartao;
	}
	
	
	
}
