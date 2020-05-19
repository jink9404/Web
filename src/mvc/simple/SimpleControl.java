package mvc.simple;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SimpleControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String jspDir = "/05_mvc_class/1_mvcSimple/";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// [1] user request analysis
		String type = request.getParameter("type");
		// [2] excute depending on user request
		String value = "";
		if(type == null) 	value="Nice to meet you";
		else				value="Hello";
		// [3] save result for requeset or session
		request.setAttribute("param", value);
		// [4] forwarding
		//		<jsp:forward> ---> java translation
		RequestDispatcher disp = request.getRequestDispatcher(jspDir+"simpleView.jsp");
		disp.forward(request, response);
		
	}
}
