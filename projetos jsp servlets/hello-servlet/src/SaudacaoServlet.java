import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaudacaoServlet")
public class SaudacaoServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	
	// then write the data of the response
	out.println("<html>" + "<head><title>Hello</title></head>");
	
	// then write the data of the response
	out.println("<body bgcolor=\"#ffffff\">" +
			"<h2>Olá, meu nome é Servlet.Meu hobby é futebol. Qual é o seu nome e hobby?</h2>" +
			"<form method=\"get\">" +
			"<input type=\"text\" name=\"nome\" size=\"25\">" + "<p></p>" +
			"<input type=\"text\" name=\"hobby\" size=\"25\">" + "<p></p>" +
			"<input type=\"submit\" value=\"Enviar\">" +
			"<input type=\"reset\" value=\"Resetar\">" + "</form>");
	
	String nome = request.getParameter("nome");
	String hobby = request.getParameter("hobby");
	if ((nome != null) && (nome.length() > 0) && (hobby != null) && (hobby.length() > 0)) {
		out.println("<h2>Olá, " + nome + "! ");
		out.println("<h2>Seu hobby é " + hobby + "! ");
	}
	out.println("</body></html>");
	out.close();
	}
}
