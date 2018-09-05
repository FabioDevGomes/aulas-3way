package aula10;

public class TestaAbreviacao {
	public static void main(String[] args) {
		 
		String nome = "Fábio Alves Gomes";
		
		String[] nomesSeparados = nome.split(" ");
		
		String abreviacao = "";
		for (String string : nomesSeparados) {
			System.out.println(string);
			abreviacao =  abreviacao + String.valueOf(string.charAt(0)) + ". ";
		}
		
		System.out.println("Abreviatura: "+ abreviacao);
	}

}
