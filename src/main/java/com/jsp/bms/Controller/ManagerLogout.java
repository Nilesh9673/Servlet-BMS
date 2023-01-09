package com.jsp.bms.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/managerlogout")
public class ManagerLogout extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();
		httpSession.removeAttribute("id");
		httpSession.invalidate();

		PrintWriter printWriter = resp.getWriter();
		printWriter.print("<html><body><h1>" + "Logout Successfully" + "</h1>" + "<br><br>" + "</body></html>");
		printWriter.print("<br>");
		printWriter.print("<button type='button'><a href='./Manager.jsp'> Login</a></button>");

	}

}
