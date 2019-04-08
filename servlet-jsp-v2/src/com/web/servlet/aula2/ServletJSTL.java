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
import javax.servlet.http.HttpSession;

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
		livro.setAutor("F�bio");
		livro.setDescricao("Livro feito pelo F�bio");
		livro.setTitulo("O Livro");
		
		Livro livro2 = new Livro();
		livro2.setAutor("F�bio 2");
		livro2.setDescricao("Livro feito pelo F�bio 2");
		livro2.setTitulo("O Livro 2");
		
		Livro livro3 = new Livro();
		livro3.setAutor("F�bio 3");
		livro3.setDescricao("Livro feito pelo F�bio 3");
		livro3.setTitulo("O Livro 3");
		
		Livro livro4 = new Livro();
		livro4.setAutor("F�bio 3");
		livro4.setDescricao("Livro feito pelo F�bio 3");
		livro4.setTitulo("O Livro 3");
		
		Livro livro5 = new Livro();
		livro5.setAutor("F�bio 3");
		livro5.setDescricao("Livro feito pelo F�bio 3");
		livro5.setTitulo("O Livro 3");
		
		listaLivros.add(livro);
		listaLivros.add(livro2);
		listaLivros.add(livro3);
		listaLivros.add(livro4);
		listaLivros.add(livro5);
		
		request.setAttribute("listaLivrosNoAtributo", listaLivros);
		
//		request.setAttribute("usuarioLogado", "F�bio Alves Gomes");
		request.setAttribute("usuarioLogado", livro.getAutor());
		
		
		HttpSession session = request.getSession();
//	    String username = (String)request.getAttribute("un");
	    session.setAttribute("userName", "username na sessão direto do servlet");
		
		
	    //Mantem informa��es "settadas" na requis��o/request
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/listagemJstl.jsp");
		rd.forward(request, response);
	    
	    //Perde informa��es "settadas" na requis��o/request
//	    response.sendRedirect("/servlet-jsp-v2/listagemJstl.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
