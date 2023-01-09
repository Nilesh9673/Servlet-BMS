package com.jsp.bms.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.bms.Dto.AdminDto;
import com.jsp.bms.Service.AdminService;

@WebServlet("/updateadminname")
public class UpdateAdminName extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String password = req.getParameter("password");
		HttpSession httpSession = req.getSession();
		int id = (int) httpSession.getAttribute("id");
		AdminService adminService = new AdminService();
		AdminDto admin = adminService.getAdminById(id);
		PrintWriter printWriter = resp.getWriter();

		if (admin.getPassword().equals(password)) {
			adminService.updateAdminNameById(id, name);
			printWriter.print("<html><body><h1>" + "Name Updated Successfully" + "</h1></body></html>");
		} else {
			printWriter.print("<html><body><h1>" + "Invalid Password" + "</h1></body></html>");
		}
		printWriter.print("<br>");
		printWriter.print("<button type='button'><a href='Admin1.jsp'>home page<a/></button>");
		printWriter.print("<br>");
		printWriter.print("<button type='button'><a href='adminlogout'>Logout</a></button>");
	}

}
