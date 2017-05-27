package com.wap.dao.imp;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class Loginfilter
 */
@WebFilter("/Loginfilter")
public class Loginfilter implements Filter {

    /**
     * Default constructor. 
     */
    public Loginfilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("I am inside filter");
		HttpServletRequest hreq = (HttpServletRequest) request;
		String uri = hreq.getRequestURI();
		if (uri.endsWith("HomePageServlet")) {
			System.out.println("Before chaiin  first");
			chain.doFilter(request, response);
		} else {
			HttpSession sess = hreq.getSession(false);
			if (sess == null) {
				request.setAttribute("USER_NAME_ERROR",
						"Session timeout.Please Login");
				request.getRequestDispatcher("login.jsp").forward(request,
						response);
			} else {
				System.out.println("I ambefore cjhain second");
				chain.doFilter(request, response);

			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
