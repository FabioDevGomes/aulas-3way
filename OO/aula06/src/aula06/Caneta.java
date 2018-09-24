package aula06;

public class Caneta {

	String cor;
	boolean tmpadaa;
	String modelo;
	
	public void escrever (){
		if(!tmpadaa){
			System.out.println("escrevendo");
		}else{
			System.out.println("não pode escrever");
		}
	}
	
	public void status(){
		System.out.println(cor);
		System.out.println(modelo);
		System.out.println(tmpadaa);
	}
	
	//criar caneta e instaciar duas diferentes
	//Exercício: Criar dois objetos (classe) depois instanciar
	//Objeto abstrato - Aula : professor; alunos; começar() terminar() 
}
