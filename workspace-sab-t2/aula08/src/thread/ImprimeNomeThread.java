package thread;

public class ImprimeNomeThread extends Thread {
	public ImprimeNomeThread(String nome) {
		super(nome);
		start();
	}

	// Sobrescreve metodo run() da classe Thread.
	// Este metodo toma a execucao metodo start() for invocado
	public void run() {
		System.out.println("metodo run() da thread " + this.getName() + " e chamado");

		for (int i = 0; i < 10; i++) {
			try {
				sleep(1000);
				System.out.println(i + " : " + this.getName());

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// Cria instancia de uma classe que e
		// subclasse da classe Thread
		System.out.println("Criando instancia de ImprimeNomeThread...");
		ImprimeNomeThread pnt1 = new ImprimeNomeThread("Executando processo A");
		ImprimeNomeThread pnt2 = new ImprimeNomeThread("Executando processo B");
		ImprimeNomeThread pnt3 = new ImprimeNomeThread("Executando processo C");
		
		
//		System.out.println("Criando instancia de ImprimeNomeThread...");
//
//		ImprimeNomeThread minhaThread = new ImprimeNomeThread("A");
//
////		 Inicia thread pela invocacao do metodo start()
//		System.out.println("Chamando metodo start() da thread " + minhaThread.getName());
//
//		minhaThread.start();

	}

}
