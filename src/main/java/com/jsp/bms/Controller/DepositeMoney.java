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

@WebServlet("/depositemoney")
public class DepositeMoney extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		double money = Integer.parseInt(req.getParameter("depositemoney"));

		HttpSession httpSession = req.getSession();
		int id = (int) httpSession.getAttribute("id");
		PrintWriter printWriter = resp.getWriter();
		if (money > 0) {
			ManagerService managerService = new ManagerService();
			CustomerServices customerServices = new CustomerServices();
			CustomerDto customer = customerServices.getCustomerById(id);

			if (customer.getStatus().equals("approved")) {
				List<BankAccountDto> bankAcc = managerService.allBankAccount();

				for (BankAccountDto b : bankAcc) {
					if (b.getCustomerDto().getId() == id) {
						customerServices.depositeMoney(id, b.getId(), money);
						printWriter.print("<html><body><h1>" + "Money Depositet Successfully" + "</h1></body></html>");
						printWriter.print("<br>");
						printWriter.print("<button type='button'><a href='Customer1.jsp'>home page<a/></button>");
						printWriter.print("<br>");
						printWriter
								.print("<button type='button'><a href='BankOperation.jsp'>Bank Homepage<a/></button>");
						printWriter.print("<br>");
						printWriter.print("<button type='button'><a href='customerlogout'>Logout</a></button>");
						return;
					}
				}
				BankAccountDto bankAccountDto = new BankAccountDto();

				bankAccountDto.setBalance(money);
				customerServices.savebankDetail(id, bankAccountDto);
				printWriter.print("<html><body><h1>" + "New Bank Account Account Created" + "</h1></body></html>");

			} else {
				printWriter.print("<html><body><h1>" + "your are not Approved " + "</h1></body></html>");
			}
		} else {
			printWriter.print("<html><body><h1>" + "Amount must be more then zero " + "</h1></body></html>");
		}
		printWriter.print("<br>");
		printWriter.print("<button type='button'><a href='BankOperation.jsp'>Bank Homepage<a/></button>");
		printWriter.print("<br>");
		printWriter.print("<button type='button'><a href='./Customer1.jsp'>CustomerHomePage</a></button>");
		printWriter.print("<br>");
		printWriter.print("<button type='button'><a href='customerlogout'>Logout</a></button>");
	}
}
