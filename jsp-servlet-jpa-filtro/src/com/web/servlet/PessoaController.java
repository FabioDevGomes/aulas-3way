package com.web.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.dao.PessoaDAO;
import com.web.model.Pessoa;

@WebServlet("/pessoaController")
public class PessoaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String INSERIR_OU_EDITAR = "/pessoa.jsp";
	private static final String LISTAGEM_PESSOAS = "/listagemPessoas.jsp";

	private PessoaDAO dao = new PessoaDAO();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pagina = "";
		String action = request.getParameter("action");
		String livroFiltro = request.getParameter("livroFiltro");

		if (action != null && action.equalsIgnoreCase("deletar")) {
			int livroId = Integer.parseInt(request.getParameter("livroId"));
//			dao.removeById(livroId);
			pagina = LISTAGEM_PESSOAS;
//			request.setAttribute("livros", dao.listarTodos());
		} else if (action != null && action.equalsIgnoreCase("editar")) {
			pagina = INSERIR_OU_EDITAR;
			int codigoLivro = Integer.parseInt(request.getParameter("livroId"));
//			Livro livro = dao.consultar(codigoLivro);
//			request.setAttribute("livro", livro);
		} else if (action != null && action.equalsIgnoreCase("listarLivros")) {
			pagina = LISTAGEM_PESSOAS;
//			request.setAttribute("livros", dao.listarTodos());
		} else if (livroFiltro != null) {
//			List<Livro> livros = dao.consultar(livroFiltro);
//			request.setAttribute("livros", livros);
			pagina = LISTAGEM_PESSOAS;
		} else {
			pagina = INSERIR_OU_EDITAR;
		} 

		RequestDispatcher view = request.getRequestDispatcher(pagina);
		view.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(request.getParameter("nome"));
		pessoa.setDataNascimento(new Date());
		
		String codigoLivro = request.getParameter("pessoaId");
		

		if ((codigoLivro == null || codigoLivro.isEmpty())) {
			dao.salvar(pessoa);
			request.setAttribute("pessoas", dao.listarTodos());
		} else {
//			livro.setCodigo(Integer.parseInt(codigoLivro));
//			dao.updateTitulo(livro);
//			request.setAttribute("livros", dao.listarTodos());
		}
		RequestDispatcher view = request.getRequestDispatcher(LISTAGEM_PESSOAS);
		view.forward(request, response);
	}

}
