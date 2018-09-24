package comparable;


public class Conta implements Comparable<Conta> {
        
    private int numero;
    private String titular;
    // outros metodos e atributos

	public Conta(int numero, String titular) {
		super();
		this.numero = numero;
		this.titular = titular;
	}

	@Override
	public int compareTo(Conta outraConta) {
		if (this.getNumero() < outraConta.getNumero()) {
			return -1;
		}
		if (this.getNumero() > outraConta.getNumero()) {
			return 1;
		}
		return 0;
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

}
