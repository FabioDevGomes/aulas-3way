package com.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.dao.LivroDao;
import com.web.model.Livro;

@WebServlet("/LivroController")
public class LivroController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String INSERIR_OU_EDITAR = "/livro.jsp";
	private static final String LISTAR_LIVROS = "/listarLivros.jsp";

	private LivroDao dao = new LivroDao();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("deletar")) {
			int livroId = Integer.parseInt(request.getParameter("livroId"));
			dao.removeById(livroId);
			forward = LISTAR_LIVROS;
			request.setAttribute("livros", dao.listarTodos());
		} else if (action.equalsIgnoreCase("editar")) {
			forward = INSERIR_OU_EDITAR;
			int codigoLivro = Integer.parseInt(request.getParameter("livroId"));
			Livro livro = dao.consultar(codigoLivro);
			request.setAttribute("livro", livro);
		} else if (action.equalsIgnoreCase("listarLivros")) {
			forward = LISTAR_LIVROS;
			request.setAttribute("livros", dao.listarTodos());
		} else {
			forward = INSERIR_OU_EDITAR;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Livro livro = new Livro();
		livro.setTitulo(request.getParameter("titulo"));
		livro.setAutor(request.getParameter("autor"));
		livro.setPreco(Double.parseDouble(request.getParameter("preco")));
		String userid = request.getParameter("livroCodigo");

		if (userid == null || userid.isEmpty()) {
			// dao.addLivro(user);
		} else {
			livro.setCodigo(Integer.parseInt(userid));
			 dao.updateTitulo(livro);
		}
		RequestDispatcher view = request.getRequestDispatcher(LISTAR_LIVROS);
		request.setAttribute("livros", dao.listarTodos());
		view.forward(request, response);
	}

}
