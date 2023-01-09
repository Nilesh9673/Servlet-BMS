package com.jsp.bms.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.bms.Dto.CustomerDto;
import com.jsp.bms.Service.ManagerService;

@WebServlet("/customerlogin")
public class CustomerLogin extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String password = req.getParameter("password");

		ManagerService managerService = new ManagerService();
		List<CustomerDto> customer = managerService.getAllCustomer();
		for (CustomerDto c : customer) {
			if (c.getId() == id && c.getPassword().equals(password)) {
				HttpSession httpSession = req.getSession();
				httpSession.setAttribute("id", id);
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("Customer1.jsp");
				requestDispatcher.forward(req, resp);

			}
		}
		PrintWriter printWriter = resp.getWriter();
		printWriter.print("<html><body><h1>" + " invalid credential" + "</h1></body></html>");
		printWriter.print("<a href='Customer.jsp'>Home<a/>");

	}

}
