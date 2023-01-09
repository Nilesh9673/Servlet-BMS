package com.jsp.bms.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.bms.Dto.CustomerDto;
import com.jsp.bms.Service.CustomerServices;
import com.jsp.bms.Service.ManagerService;

@WebServlet("/savecustomer")
public class SaveCustomer extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String Dob = req.getParameter("dob");
		String Adharno = req.getParameter("adharno");
		String password = req.getParameter("password");

		CustomerDto customer = new CustomerDto();
		customer.setName(name);
		customer.setGender(gender);
		customer.setDob(Dob);
		customer.setAdharno(Adharno);
		customer.setPassword(password);

		ManagerService managerService = new ManagerService();
		PrintWriter printWriter = resp.getWriter();
		List<CustomerDto> customers = managerService.getAllCustomer();
		for (CustomerDto c : customers) {
			if (c.getAdharno().equals(Adharno)) {

				printWriter.print("<html><body><h1>" + "User All ready exist" + "</h1></body></html>");
				printWriter.print("<button type='button'><a href='./Customer.jsp'> Home</a></button>");
				return;
			}
		}
		CustomerServices customerServices = new CustomerServices();
		customerServices.saveCustomer(customer);

		printWriter.print("<html><body><h1>" + customer.getName() + " save Succefully \t" + "</h1><br><br>"
				+ " Your Id is " + customer.getId() + "</body></html>");
		printWriter.print("<button type='button'><a href='./Customer.jsp'>Home</a></button>");

	}

}
