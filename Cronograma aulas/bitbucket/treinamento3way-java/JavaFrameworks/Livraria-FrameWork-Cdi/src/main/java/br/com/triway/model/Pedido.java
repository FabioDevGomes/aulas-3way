package br.com.triway.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="PEDIDO")
public class Pedido {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="COD_PEDIDO")
	private int codigo;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="COD_PEDIDO",foreignKey=@ForeignKey(name="fk_pedido_itens"))
	private List<ItemCarrinho> itens;
	
	@ManyToOne(cascade={CascadeType.REFRESH})
	@JoinColumn(name="COD_CLIENTE",foreignKey=@ForeignKey(name="fk_pedido_cliente"))
	private Cliente cliente;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATA_PEDIDO")
	private Date dataPedido = new Date();
	
	@Column(name="PAGAMENTO")
	@Enumerated(EnumType.STRING)
	private EnumTipoPagamento pagamento;
	
	@Column(name="CARTAO")
	private String tipoCartao;
	
	@Column(name="TOTAL")
	private Double valorTotal;
	
	@Column(name="STATUS", length=50)
	private String status;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public List<ItemCarrinho> getItens() {
		return itens;
	}

	public void setItens(List<ItemCarrinho> itens) {
		this.itens = itens;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public EnumTipoPagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(EnumTipoPagamento pagamento) {
		this.pagamento = pagamento;
	}


	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getStatus() {
		return status;
	}
	
	public String getTipoCartao() {
		return tipoCartao;
	}

	public void setTipoCartao(String tipoCartao) {
		this.tipoCartao = tipoCartao;
	}

	public void setStatus(String string) {
		this.status = string;
	}
	
	
}
