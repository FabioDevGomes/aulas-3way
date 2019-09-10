

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CapturaInformacoes
 */
@WebServlet("/CapturaInformacoes")
public class CapturaInformacoes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CapturaInformacoes() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	response.setContentType("application/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Informação de Requerimento</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>Informação de Requerimento</h3>");
		out.println("Method: " + request.getMethod() + "<br>");
		out.println("Request URI: " + request.getRequestURI() + "<br>");
		out.println("Protocol: " + request.getProtocol() + "<br>");
		out.println("PathInfo: " + request.getPathInfo() + "<br>");
		out.println("Remote Address: " + request.getRemoteAddr() + "<br>");
		
		// Exibir tipo de autenticação
		out.println("<h3> AuthType </h3>");
		out.println("AuthType = " + request.getAuthType() + "<br>");
		// Exibir método HTTP
		out.println("<h3> HTTP Method </h3>");

		out.println("HTTP Method = " + request.getMethod() + "<br>");
		out.println("</body>");
		out.println("</html>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doGet(request, response);
	}
	

}
