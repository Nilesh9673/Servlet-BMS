package com.jsp.bms.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.bms.Dto.ManagerDto;
import com.jsp.bms.Service.ManagerService;

@WebServlet("/savemanager")
public class SaveManager extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		ManagerDto managerDto = new ManagerDto();
		managerDto.setName(name);
		managerDto.setEmail(email);
		managerDto.setPassword(password);

		ManagerService managerService = new ManagerService();
		managerService.saveManager(managerDto);
		PrintWriter printWriter = resp.getWriter();
		printWriter.print("<html><body><h1>" + managerDto.getName() + " \t save Succefully \t" + "</h1><br><br>"
				+ "\t Your Id is\t " + managerDto.getId() + "</body></html>");
		printWriter.print("<button type='button'><a href='./Manager.jsp'>Login</a></button>");

	}
}
