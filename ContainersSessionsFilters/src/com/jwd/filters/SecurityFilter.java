package com.jwd.filters;

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
@WebFilter("/DynamicServlet")
public class SecurityFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		String user = "dimitar", password = "password123";
		String userFromReq = httpRequest.getParameter("username");
		String passwordFromReq = httpRequest.getParameter("pass");

		if (userFromReq != null && passwordFromReq != null) {
			if (user.equals(userFromReq) && password.equals(passwordFromReq)) {
				redirectToHome(response);
			} else {
				redirectToLogin(response);
			}
		} else if (session != null) {
			String userFromSession = (String) session.getAttribute("username");
			String passFromSession = (String) session.getAttribute("pass");
			if (userFromSession != null && passFromSession != null && userFromSession.equals(user)) {
				redirectToHome(response);
			}
		}

		else {
			redirectToLogin(response);
		}

		chain.doFilter(request, response);
		session.setAttribute("username", userFromReq);
		session.setAttribute("password", passwordFromReq);
	}

	private void redirectToHome(ServletResponse response) throws IOException {
		((HttpServletResponse) response).sendRedirect("HomePage");
	}

	private void redirectToLogin(ServletResponse response) throws IOException {
	
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
