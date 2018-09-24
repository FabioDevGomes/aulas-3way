package nio;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class NioLendoEscrevendoEmOutro {

	public static void main(String[] args) {
		
		String fileStr = "aquivo.txt";
		Path path = Paths.get(fileStr);
		
		// Leitura linha a linha
		List<String> inLines;
		
		try {
			inLines = Files.readAllLines(path, Charset.forName("UTF-8"));
			
			List<String> linhas = new ArrayList<String>();
			for (String linha : inLines) {
				linhas.add(linha);
				System.out.println(linha);
				
				//ler caractere a caractere dentro de UMA linha por vez
				for (int i = 0; i < linha.length(); i++) {
					char charOut = linha.charAt(i);
					System.out.println();
					System.out.printf("[%d] '%c'", (i+1), charOut);
				}
			}
			
			String nomeArquivo = "aquivo2.txt";
			Path path2 = Paths.get(nomeArquivo);
			
			Files.write(path2, linhas, Charset.forName("UTF-8"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
