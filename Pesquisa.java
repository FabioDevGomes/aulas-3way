package dao.teste;

import dao.LivroDao;

public class Pesquisa {

	public static void main(String[] args) {

		String titulo = "GRANDE SERTAO - VEREDAS";
		LivroDao dao = new LivroDao();
		dao.consultar(titulo).forEach(p -> System.out.println("Desc: " + p.getTitulo() + " Preço:" + p.getPreco()));
		
		// deixar usar essa implementação e corrigir o erro
		// dao.consultar(titulo).forEach(p -> System.out.println("Desc: " + p.getDescricao() + "Preço:" + p.getPreco()));

		// implementar usando o for each
		// dao.consultar(titulo).forEach(p -> System.out.println("Desc: " + p.getDescricao() + "Preço:" + p.getPreco()));
	}

}
