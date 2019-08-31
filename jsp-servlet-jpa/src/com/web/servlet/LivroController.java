package com.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.dao.LivroDao;
import com.web.model.Livro;

@WebServlet("/livroController")
public class LivroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String INSERIR_OU_EDITAR = "/livro.jsp";
	private static final String LISTAGEM_LIVROS = "/listagemLivros.jsp";

	private LivroDao dao = new LivroDao();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pagina = "";
		String action = request.getParameter("action");
		String livroFiltro = request.getParameter("livroFiltro");

		if (action != null && action.equalsIgnoreCase("deletar")) {
			int livroId = Integer.parseInt(request.getParameter("livroId"));
			dao.removeById(livroId);
			pagina = LISTAGEM_LIVROS;
			request.setAttribute("livros", dao.listarTodos());
		} else if (action != null && action.equalsIgnoreCase("editar")) {
			pagina = INSERIR_OU_EDITAR;
			int codigoLivro = Integer.parseInt(request.getParameter("livroId"));
			Livro livro = dao.consultar(codigoLivro);
			request.setAttribute("livro", livro);
		} else if (action != null && action.equalsIgnoreCase("listarLivros")) {
			pagina = LISTAGEM_LIVROS;
			request.setAttribute("livros", dao.listarTodos());
		} else if (livroFiltro != null) {
			List<Livro> livros = dao.consultar(livroFiltro);
			request.setAttribute("livros", livros);
			pagina = LISTAGEM_LIVROS;
		} else {
			pagina = INSERIR_OU_EDITAR;
		} 

		RequestDispatcher view = request.getRequestDispatcher(pagina);
		view.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Livro livro = new Livro();
		livro.setTitulo(request.getParameter("titulo"));
		livro.setAutor(request.getParameter("autor"));
		livro.setDescricao(request.getParameter("descricao"));
		livro.setPreco(request.getParameter("preco") != null ? Double.parseDouble(request.getParameter("preco")) : 0);
		String codigoLivro = request.getParameter("livroCodigo");
		

		if ((codigoLivro == null || codigoLivro.isEmpty())) {
			dao.save(livro);
			request.setAttribute("livros", dao.listarTodos());
		} else {
			livro.setCodigo(Integer.parseInt(codigoLivro));
			dao.updateTitulo(livro);
			request.setAttribute("livros", dao.listarTodos());
		}
		RequestDispatcher view = request.getRequestDispatcher(LISTAGEM_LIVROS);
		view.forward(request, response);
	}

}
