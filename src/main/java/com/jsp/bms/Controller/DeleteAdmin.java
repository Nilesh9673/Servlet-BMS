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

@WebServlet("/deleteadmin")
public class DeleteAdmin extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String password = req.getParameter("password");
		HttpSession httpSession = req.getSession();
		int id = (int) httpSession.getAttribute("id");

		AdminService adminService = new AdminService();
		AdminDto admin = adminService.getAdminById(id);
		PrintWriter printWriter = resp.getWriter();

		if (admin.getPassword().equals(password)) {
			adminService.deletetAdminById(id);
			printWriter.print("<html><body><h1>" + "Deleted Successfully" + "</h1></body></html>");
			printWriter.print("<a href='AdminLogin.jsp'>home page<a/>");
		} else {
			printWriter.print("<html><body><h1>" + "Invalid Password" + "</h1></body></html>");
			printWriter.print("<a href='Admin1.jsp'>home page<a/>");

		}
		printWriter.print("<a href='adminlogout'>Logout</a>");
	}

}
