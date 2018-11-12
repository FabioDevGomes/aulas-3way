package lab11;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Conta {
	private int numero;
	private Cliente titular;
	private Date dataAbertura;
	private double saldo;
	private ArrayList movimento;
	
	// construtor padrão da classe Conta que define a data de criação da conta e inicializa o array de transacao
	
	public Conta() {
		dataAbertura = UtilData.data();
		movimento = new ArrayList();
	}
	
	// construtor com dois parametros
	public Conta( Cliente nome, int nconta ) {
		this();
		numero = nconta;
		titular = nome;
		saldo = 0.0; // Conta em reais e zerada
	}
	
	// INSIRA OS MÉTODOS GETTERS E SETTERS
	public Date getDataAbertura(){
		return dataAbertura;
	}
	
	public ArrayList getMovimento(){
		return movimento;
	}
	
	public Cliente getTitular(){
		return titular;
	}
	
	public double getSaldo(){
		return saldo;
	}
	public void setSaldo(double value){
		this.saldo = value;
	}
	
	public int getNumero(){
		return numero;
	}
	public void setNumero(int value){
		this.numero = value;
	}
	
	/**
	* Testa a igualdade de um objeto com este
	*/

	@Override
	public boolean equals(Object objeto) {
		boolean resultado = false;
		if (( objeto != null ) && ( objeto instanceof Conta )) {
			Conta c = (Conta) objeto;
			if (getNumero() == c.getNumero()) {
				resultado = true;
			}
		}
		return resultado;
	}

	/**
	* Gera c�digo hash para tabelas de epalhamento
	*/

	@Override
	public int hashCode() {
		return getNumero();
	}

	@Override
	public String toString() {
		return getNumero() + "-" + getTitular().getNome();
	}
}