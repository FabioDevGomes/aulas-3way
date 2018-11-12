package lab10;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Conta {
	private int numero;
	private String titular;
	private Date dataAbertura;
	private double saldo;
	private ArrayList movimento;
	
	// construtor padrão da classe Conta que define a data de criação da conta e inicializa o array de transacao
	
	public Conta() {
		dataAbertura = UtilData.data();
		movimento = new ArrayList();
	}
	
	// construtor com dois parametros
	public Conta( String nome, int nconta ) {
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
}