package util.conta;

public class ContaCorrente {
    double saldo;
    // ... outros atributos ...

    void sacar(double quantidade) {
        double novoSaldo = this.saldo - quantidade; 
        this.saldo = novoSaldo;
    }
    
    void depositar(double quantidade) {
//      this.saldo += quantidade;
//    	saldo = saldo + quantidade;
        this.saldo = this.saldo + quantidade;
    }
}