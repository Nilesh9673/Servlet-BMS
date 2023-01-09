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

import com.jsp.bms.Dto.BankAccountDto;
import com.jsp.bms.Dto.CustomerDto;
import com.jsp.bms.Service.CustomerServices;
import com.jsp.bms.Service.ManagerService;

@WebServlet("/checkbalance")
public class CheckBalance extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();
		int id = (int) httpSession.getAttribute("id");

		CustomerServices customerServices = new CustomerServices();
		CustomerDto customer = customerServices.getCustomerById(id);
		ManagerService managerService = new ManagerService();
		List<BankAccountDto> bank = managerService.allBankAccount();
		PrintWriter printWriter = resp.getWriter();
		for (BankAccountDto b : bank) {
			if (b.getCustomerDto().getId() == id) {
				printWriter
						.print("<html><body><h1>" + "Available Balance is " + b.getBalance() + "</h1></body></html>");
				printWriter.print("<br>");
				printWriter.print("<button type='button'><a href='Customer1.jsp'>Homepage<a/></button>");
				printWriter.print("<br>");
				printWriter.print("<button type='button'><a href='BankOperation.jsp'>Bank Domain<a/></button>");

			}

		}
		printWriter.print("<br>");
		printWriter.print("<button type='button'><a href='customerlogout'>Logout</a></button>");
	}

}
