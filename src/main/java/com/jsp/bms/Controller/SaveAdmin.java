package com.jsp.bms.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.bms.Dto.AdminDto;
import com.jsp.bms.Service.AdminService;

@WebServlet("/saveadmin")
public class SaveAdmin extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		AdminDto adminDto = new AdminDto();
		adminDto.setName(name);
		adminDto.setEmail(email);
		adminDto.setPassword(password);

		AdminService adminService = new AdminService();
		adminService.saveAdmin(adminDto);

		PrintWriter printWriter = resp.getWriter();
		printWriter.print("<html><body><h1>" + adminDto.getName() + "  save Succefully  And " + " Your Id is "
				+ adminDto.getId() + "</h1></body></html>");
		printWriter.print("<button type='button'><a href='./Admin.jsp'>Home</a></button>");

	}
}
