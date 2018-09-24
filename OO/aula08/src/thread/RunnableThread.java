package thread;

public class RunnableThread implements Runnable{

	@Override
	public void run() {
		System.out.println("=implements Runnable=");
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}
	}
}
