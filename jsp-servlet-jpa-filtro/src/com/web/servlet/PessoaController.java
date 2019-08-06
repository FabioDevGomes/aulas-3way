package com.web.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

		if (action != null && action.equalsIgnoreCase("deletar")) {
			long livroId = Long.parseLong(request.getParameter("pessoaId"));
			dao.excluir(livroId);
			request.setAttribute("pessoas", dao.listarTodos());
			pagina = LISTAGEM_PESSOAS;
		} else if (action != null && action.equalsIgnoreCase("editar")) {
			long livroId = Long.parseLong(request.getParameter("pessoaId"));
			Pessoa pessoaEditar = dao.consultarPorId(livroId);
			request.setAttribute("pessoa", pessoaEditar);
			pagina = INSERIR_OU_EDITAR;
		} else if (action != null && action.equalsIgnoreCase("listarPessoas")) {
			request.setAttribute("pessoas", dao.listarTodos());
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
		pessoa.setEmail(request.getParameter("email"));
		
		String mydate= request.getParameter("dataNascimento");
		try {
			Date dataNascimento = new SimpleDateFormat("yyyy-MM-dd").parse(mydate);
			pessoa.setDataNascimento(dataNascimento);
		} catch (ParseException e) {
			e.printStackTrace();
		}  

		dao.salvar(pessoa);
		request.setAttribute("pessoas", dao.listarTodos());

		RequestDispatcher view = request.getRequestDispatcher(LISTAGEM_PESSOAS);
		view.forward(request, response);
	}

}
