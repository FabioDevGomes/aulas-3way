package dao.teste;

import dao.LivroDao;
import model.Livro;

public class Pesquisa {
	static LivroDao dao = new LivroDao();

	public static void main(String[] args) {
		testarConsulta();
		testarUpdate();
//		excecutarDelete(9);
		System.out.println("---");
		testarConsulta();


	}
	
	public static void testarUpdate() {
		Livro livro = new Livro();
		livro.setCodigo(1);
		livro.setTitulo("Alterado");
		livro.setAutor("Fábio Alves");
		
		dao.updateTitulo(livro);
	}
	
	public static void testarConsulta() {
		String titulo = "a";
//		LivroDao dao = new LivroDao();
//		dao.consultar(titulo).forEach(p -> System.out.println("Desc: \t" + p.getTitulo() + " \t\t\tPreço:" + p.getPreco()));
		
		for (Livro  livro : dao.consultar(titulo)) {
//			System.out.println(livro.getTitulo());
			System.out.println("Cod: " + livro.getCodigo() + " \t\tDesc: \t" + livro.getTitulo() + " \t -Preço:" + livro.getPreco());
		}
		
		// deixar usar essa implementação e corrigir o erro
		// dao.consultar(titulo).forEach(p -> System.out.println("Desc: " +
		// p.getDescricao() + "Preço:" + p.getPreco()));
		
		// implementar usando o for each
		// dao.consultar(titulo).forEach(p -> System.out.println("Desc: " +
		// p.getDescricao() + "Preço:" + p.getPreco()));
		
	}
	
	public static void excecutarDelete(int codigo) {
		dao.removeById(codigo);
	}

}
