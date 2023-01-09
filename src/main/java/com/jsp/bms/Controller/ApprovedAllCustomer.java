package com.jsp.bms.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.bms.Dto.ManagerDto;
import com.jsp.bms.Service.ManagerService;

@WebServlet("/ApprovedAllCustomer")
public class ApprovedAllCustomer extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();
		int id = (int) httpSession.getAttribute("id");

		ManagerService managerService = new ManagerService();
		managerService.approvedAllCustomers(id);
		PrintWriter printWriter = resp.getWriter();
		printWriter.print("<html><body><h1>" + "All Customers are  approved Successfully" + "</h1></body></html>");
		printWriter.print("<br><br>");
		printWriter.print("<button type='button'><a href='Manager1.jsp'>home page<a/></button>");
		printWriter.print("<br><br>");
		printWriter.print("<button type='button'><a href='managerlogout'>Logout</a></button>");

	}
}
