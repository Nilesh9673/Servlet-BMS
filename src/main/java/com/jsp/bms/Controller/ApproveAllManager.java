package com.jsp.bms.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.bms.Service.AdminService;

@WebServlet("/ApprovedAllManager")
public class ApproveAllManager extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();
		int id = (int) httpSession.getAttribute("id");

		AdminService adminService = new AdminService();
		adminService.approvedAllManager(id);
		PrintWriter printWriter = resp.getWriter();
		printWriter.print("<html><body><h1>" + "All Manager are  approved Successfully" + "</h1></body></html>");
		printWriter.print("<br><br>");
		printWriter.print("<button type='button'><a href='Admin1.jsp'>home page<a/></button>");

	}

}
