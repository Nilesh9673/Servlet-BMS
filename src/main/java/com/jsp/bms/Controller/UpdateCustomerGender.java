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
import com.jsp.bms.Service.CustomerServices;

@WebServlet("/updatecustomergender")
public class UpdateCustomerGender extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String gender = req.getParameter("gender");
		String password = req.getParameter("password");

		HttpSession httpSession = req.getSession();
		int id = (int) httpSession.getAttribute("id");
		CustomerServices customerServices = new CustomerServices();
		CustomerDto customerDto = customerServices.getCustomerById(id);
		PrintWriter printWriter = resp.getWriter();
		if (customerDto.getPassword().equals(password)) {
			customerServices.updateCustomersGenderById(id, gender);
			printWriter.print("<html><body><h1>" + "Gender Updated Successfully" + "</h1></body></html>");
		} else {
			printWriter.print("<html><body><h1>" + "Invalid Password" + "</h1></body></html>");
		}
		printWriter.print("<br>");
		printWriter.print("<button type='button'><a href='Customer1.jsp'>home page<a/></button>");
		printWriter.print("<br>");
		printWriter.print("<button type='button'><a href='customerlogout'>Logout</a></button>");
	}

}
