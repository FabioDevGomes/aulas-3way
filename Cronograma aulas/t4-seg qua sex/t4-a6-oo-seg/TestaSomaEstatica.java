package exemplo.estatico;

import java.util.Arrays;

class Soma{
    
    public static int resultado(int num1, int num2){
        return (num1 + num2);
    }
    
    //crie o método não estático e teste-o
    //sobrecarregando o método resultado para rceber 3 parâmetros 
}
 
public class TestaSomaEstatica {
 
    public static void main(String[] args) {
        System.out.println(Soma.resultado(10,50));
        
    }
}