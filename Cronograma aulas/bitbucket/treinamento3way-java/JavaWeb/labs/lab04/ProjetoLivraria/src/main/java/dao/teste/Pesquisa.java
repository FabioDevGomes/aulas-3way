package dao.teste;
import java.util.Optional;
import dao.LivroDao;

public class Pesquisa {

	public static void main(String[] args) {
	
		String titulo = "O Senhor dos Aneis";
		LivroDao dao = new LivroDao();
		dao.consultar(titulo).forEach(p -> System.out.println("Desc: "+ p.getDescricao() +"Preço:" + p.getPreco()));
	}
}
