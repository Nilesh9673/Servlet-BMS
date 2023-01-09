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

@WebServlet("/tranfermaoney")
public class TransferMoney extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int bankid = Integer.parseInt(req.getParameter("bid"));
		double amount = Integer.parseInt(req.getParameter("depositemoney"));
		String password = req.getParameter("password");

		HttpSession httpSession = req.getSession();
		int id = (int) httpSession.getAttribute("id");
		PrintWriter printWriter = resp.getWriter();
		if (amount > 0) {

			CustomerServices customerServices = new CustomerServices();
			CustomerDto customer = customerServices.getCustomerById(id);
			ManagerService managerService = new ManagerService();
			List<BankAccountDto> bankAccountDto = managerService.allBankAccount();
			for (BankAccountDto b : bankAccountDto) {
				if (b.getCustomerDto().getId() == id) {
					httpSession.setAttribute("bid", b.getId());
				}
			}
			int bid = (int) httpSession.getAttribute("bid");

			BankAccountDto bankAcc = customerServices.getBankAccById(bankid);

			if (bankAcc != null) {
				if (bankAcc.getBalance() >= amount) {
					if (customer.getPassword().equals(password)) {
						customerServices.transferMoney(id, bid, bankid, amount);
						printWriter.print("<html><body><h1>" + "Transaction Succesfull" + "</h1></body></html>");
					} else {
						printWriter.print("<html><body><h1>" + "Invalid password" + "</h1></body></html>");
					}
				} else {
					printWriter.print("<html><body><h1>" + "Insufficent Balance" + "</h1></body></html>");
				}
			} else {
				printWriter.print("<html><body><h1>" + "No Such Bank Id" + "</h1></body></html>");
			}
		} else {
			printWriter.print("<html><body><h1>" + "Amount must be more then zero " + "</h1></body></html>");
		}
		printWriter.print("<br>");
		printWriter.print("<a href='BankOperation.jsp'>Bank Homepage<a/>");
		printWriter.print("<br>");
		printWriter.print("a href='./Customer1.jsp'>CustomerHomePage</a>");
		printWriter.print("<br>");
		printWriter.print("<a href='customerlogout'>Logout</a>");

	}

}
