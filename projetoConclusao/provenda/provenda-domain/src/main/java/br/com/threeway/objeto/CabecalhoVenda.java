package br.com.threeway.objeto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class CabecalhoVenda {
	
	@Id
	@GeneratedValue(generator="cabecalho_venda_gerador")
	@SequenceGenerator(name="cabecalho_venda_gerador", sequenceName="sequence_cabecalho_venda", 
		allocationSize = 1)

	private long codigo;
	@OneToOne
	private Pessoa cliente = new Pessoa();
	@OneToMany(mappedBy="cabecalho", cascade = CascadeType.ALL)
	private List<ItemVenda> itens = new ArrayList<>();
	
	private Date dataVenda = new Date();
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public List<ItemVenda> getItens() {
		return itens;
	}
	public void setItens(List<ItemVenda> itens) {
		this.itens = itens;
	}
	public Pessoa getCliente() {
		return cliente;
	}
	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}
	public Date getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}
	
	public String getDataVendaApresentar() {
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		return formatador.format(dataVenda);
	}
	
	
	
	

}
