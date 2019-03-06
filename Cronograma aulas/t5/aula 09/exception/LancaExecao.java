package execao;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class LancaExecao {

	public static void main(String[] args) {
		PrintStream ps = System.out;
		InputStreamReader stream = new InputStreamReader(System.in);

		int[] array = { 1, 2, 3, 4 };
		Character ch;
		try {
			ch = (char) stream.read();

			int i = Integer.parseInt(ch.toString());
			System.out.println(array[i]);

		} catch (IOException e) {
			System.out.println("IOException lançada");
			//e.printStackTrace();
		}catch (NumberFormatException e) {
			System.out.println("NumberFormatException lançada");
			ps.print("Erro de conversão ");
			//e.printStackTrace();
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException lançada");
			//e.printStackTrace();
		}

		// int i = Integer.parseInt(ch.toString());

	}
	
//	public void teste(){
//		throw new Exception("teste");
//	}

}
