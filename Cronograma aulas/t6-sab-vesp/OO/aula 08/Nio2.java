package nio;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Nio2 {

	public static void main(String[] args) {
		
		//escrita usando Files.write()
		String fileStr = "aquivo.txt";
		Path path = Paths.get(fileStr);
		
		List<String> linhas = new ArrayList<String>();
		linhas.add("Texto que será gravado no arquivo");
		linhas.add("Texto que será gravado na segunda linha do arquivo");
		linhas.add("Texto que será gravado na tercecira linha do arquivo");
		
		try {
			Files.write(path, linhas, Charset.forName("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Leitura linha a linha
		List<String> inLines;
		try {
			inLines = Files.readAllLines(path, Charset.forName("UTF-8"));
			for (String linha : inLines) {
				System.out.println(linha);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
