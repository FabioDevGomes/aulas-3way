package com.web.servlet.aula2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.model.Livro;

/**
 * Servlet implementation class ServletJSTL
 */
@WebServlet("/ServletJSTL")
public class ServletJSTL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Livro> listaLivros = new ArrayList<>();
		
		Livro livro = new Livro();
		livro.setAutor("Fábio");
		livro.setDescricao("Livro feito pelo Fábio");
		livro.setTitulo("O Livro");
		
		Livro livro2 = new Livro();
		livro2.setAutor("Fábio 2");
		livro2.setDescricao("Livro feito pelo Fábio 2");
		livro2.setTitulo("O Livro 2");
		
		Livro livro3 = new Livro();
		livro3.setAutor("Fábio 3");
		livro3.setDescricao("Livro feito pelo Fábio 3");
		livro3.setTitulo("O Livro 3");
		
		listaLivros.add(livro);
		listaLivros.add(livro2);
		listaLivros.add(livro3);
		
		request.setAttribute("listaLivrosNoAtributo", listaLivros);
		
		
		
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/listagemJstl.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
