package com.jsp.bms.Controller;

import java.io.IOException;
import java.io.PrintWriter;

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

@WebServlet("/approveonecustomer")
public class ApprovedOneCustomer extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int custId = Integer.parseInt(req.getParameter("cid"));
		String password = req.getParameter("password");

		HttpSession httpSession = req.getSession();
		int id = (int) httpSession.getAttribute("id");
		CustomerServices customerServices = new CustomerServices();
		CustomerDto customer = customerServices.getCustomerById(custId);
		ManagerService managerService = new ManagerService();
		ManagerDto manager = managerService.getManagerById(id);
		PrintWriter printWriter = resp.getWriter();
		if (customer != null) {
			if (manager.getPassword().equals(password)) {
				if (manager.getStatus().equals("approved")) {
					managerService.approvedCustomerById(id, custId);
					printWriter.print("<html><body><h1>" + "Customer  " + customer.getName()
							+ " is approved Successfully" + "</h1></body></html>");
					printWriter.print("<br><br>");
					printWriter.print(
							"<button type='button'><a href='ApprovedAllCustomer'>Approve All Customer<a/></button>");
				} else {
					printWriter.print("<html><body><h1>" + "You are not approved Manager" + "</h1></body></html>");
				}
			} else {
				printWriter.print("<html><body><h1>" + "Invalid Password" + "</h1></body></html>");
			}
		} else {
			printWriter.print("<html><body><h1>" + "Customer-id not Found" + "</h1></body></html>");
		}
		printWriter.print("<br><br>");
		printWriter.print("<button type='button'><a href='Manager1.jsp'>home page<a/></button>");
		printWriter.print("<br><br>");
		printWriter.print("<button type='button'><a href='managerlogout'>Logout</a></button>");

	}

}
