package lab13;

public class DuasStrings {

	// este m�todo n�o est� synchronized
	synchronized static void print(String str1, String str2) {
		System.out.print(str1);
	try {
		// interrompe a thread
		Thread.sleep(500);
	} catch (InterruptedException ie) {
	}
		System.out.println(str2);
	}

}