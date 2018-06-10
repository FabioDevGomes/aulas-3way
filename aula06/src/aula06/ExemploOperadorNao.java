package aula06;

public class ExemploOperadorNao {

	static boolean tampada = false;
	
	public static void main(String[] args) {
		//essa lógica é por parte da turma
		if(!tampada){
			escrever();
		}
	}
	
	public static void escrever(){
		System.out.println("Escrevendo");
	}

}
