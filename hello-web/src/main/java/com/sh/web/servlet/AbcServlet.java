package com.sh.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AbcServlet
 */
public class AbcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/abc.do 요청!");
		
		// 리다이렉트 (302 응답) : 다시 연결할지 물어보지 않고, 바로 요청을 보냄
		// 클라이언트에게 location으로 재요청을 지시
		response.sendRedirect(request.getContextPath() + "/xyz.do"); // /hello-web/xyz.do
	}

}
