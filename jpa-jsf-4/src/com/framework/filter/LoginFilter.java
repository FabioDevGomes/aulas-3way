package com.framework.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/restrito/*")
public class LoginFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		 HttpSession sess = ((HttpServletRequest) request).getSession(true);
		 //recuperar o atributo logado da sessão
		 boolean logado = false;
		 if(sess.getAttribute("logado") != null) {
			 logado = (Boolean) sess.getAttribute("logado");
		 }

		// caso a variável logado seja false saberemos que
		// o usuário não está logado
		if (!logado) {
			String contextPath = ((HttpServletRequest) request).getContextPath();

			// Redirecionamos o usuário imediatamente
			// para a página de login.xhtml
			((HttpServletResponse) response).sendRedirect(contextPath + "/login/login.xhtml");
		} else {
			// Caso ele esteja logado, apenas deixamos
			// que o fluxo continue
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}

}