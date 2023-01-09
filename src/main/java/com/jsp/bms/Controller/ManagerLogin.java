package com.jsp.bms.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.bms.Dto.ManagerDto;
import com.jsp.bms.Service.AdminService;
import com.jsp.bms.Service.ManagerService;

@WebServlet("/managerlogin")
public class ManagerLogin extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String password = req.getParameter("password");

//		ManagerService managerService=new ManagerService();
		AdminService adminService = new AdminService();

		List<ManagerDto> manager = adminService.getAllManager();
		for (ManagerDto m : manager) {
			if (m.getId() == id && m.getPassword().equals(password)) {
				HttpSession httpSession = req.getSession();
				httpSession.setAttribute("id", id);
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("Manager1.jsp");
				requestDispatcher.forward(req, resp);

			}
		}
		PrintWriter printWriter = resp.getWriter();
		printWriter.print("<html><body><h1>" + " invalid credential" + "</h1></body></html>");
		printWriter.print("<a href='ManagerLogin.jsp'>Login<a/>");

	}

}
