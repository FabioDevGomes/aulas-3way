package arquivo;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Nio2 {
	public static void main(String[] args) {
		String fileStr = "aquivo.txt";
		
		Path path = Paths.get(fileStr);
		
		List<String> linhas = new ArrayList<String>();
		linhas.add("Olá alguma coisa");
		linhas.add("Olá alguma coisa");
		
		try {
			Files.write(path, linhas, Charset.forName("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			//lê todas as linhas e atribui para uma lista
			List<String> inLines = Files.readAllLines(path, Charset.forName("UTF-8"));
			
			//pega linha por linha...
			for (String linha : inLines) {
				System.out.println(linha);
				//percorre os carcteres da linha até o fim -linha.length()-
				for (int i = 0; i < linha.length(); i++) {
					
					//...e lê caractere por caractere
					char charOut = linha.charAt(i);
					System.out.println();
					System.out.printf("[%d] '%c' ", (i+1), charOut);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}