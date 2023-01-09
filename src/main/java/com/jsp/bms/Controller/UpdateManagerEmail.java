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

@WebServlet("/updatemanageremail")
public class UpdateManagerEmail extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");
		HttpSession httpSession = req.getSession();
		int id = (int) httpSession.getAttribute("id");

		ManagerService managerService = new ManagerService();
		ManagerDto manager = managerService.getManagerById(id);
		PrintWriter printWriter = resp.getWriter();

		if (manager.getPassword().equals(password)) {
			managerService.updateManagerGmailById(id, email);
			printWriter.print("<html><body><h1>" + "Email Updated Successfully" + "</h1></body></html>");
		} else {
			printWriter.print("<html><body><h1>" + "Invalid Password" + "</h1></body></html>");
		}
		printWriter.print("<br>");
		printWriter.print("<button type='button'><a href='Manager1.jsp'>home page<a/></button>");
		printWriter.print("<br>");
		printWriter.print("<button type='button'><a href='managerlogout'>Logout</a></button>");
	}

}
