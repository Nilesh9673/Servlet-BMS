package com.jsp.bms.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.bms.Dto.CustomerDto;
import com.jsp.bms.Dto.ManagerDto;
import com.jsp.bms.Service.CustomerServices;
import com.jsp.bms.Service.ManagerService;

@WebServlet("/deletecustomerbyid")
public class DeleteCustomer extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int custId = Integer.parseInt(req.getParameter("cid"));
		String password = req.getParameter("password");

		HttpSession httpSession = req.getSession();
		int id = (int) httpSession.getAttribute("id");

		PrintWriter printWriter = resp.getWriter();
		ManagerService managerService = new ManagerService();
		CustomerServices customerServices = new CustomerServices();
		CustomerDto customer = customerServices.getCustomerById(custId);

		if (customer != null) {
			if (customer.getManagerDto().getId() == id) {
				managerService.deleteCustomerById(custId);
			} else {
				printWriter.print("<html><body><h1>" + "Not your Customer " + "</h1></body></html>");
				printWriter.print("<a href='Manager1.jsp'>home page<a/>");
			}
		} else {
			printWriter.print("<html><body><h1>" + "No Such CustomerId " + custId + " found" + "</h1></body></html>");
			printWriter.print("<a href='Manager1.jsp'>home page<a/>");

		}
		printWriter.print("<a href='managerlogout'>Logout</a>");

	}
}
