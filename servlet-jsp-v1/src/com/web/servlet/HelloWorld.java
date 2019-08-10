package com.web.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/helloServlet")
public class HelloWorld extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    // reading the user input
		    String color= request.getParameter("color");    
		    PrintWriter out = response.getWriter();
		    out.println (
		      "<html> \n" +
		        "<head> \n" +
		          "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"> \n" +
		          "<title> Meu primeiro JSP  </title> \n" +
		        "</head> \n" +
		        "<body> \n" +
		          "<font size=\"12px\" color=\"" + color + "\">" +
		            "Hello World" +
		          "</font> \n" +
		        "</body> \n" +
		      "</html>" 
		    );  
		  }

}
