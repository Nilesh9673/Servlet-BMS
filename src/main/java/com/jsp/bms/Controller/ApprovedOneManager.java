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
import com.jsp.bms.Dto.ManagerDto;
import com.jsp.bms.Service.AdminService;
import com.jsp.bms.Service.ManagerService;

@WebServlet("/approveonemanager")
public class ApprovedOneManager extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int managerId = Integer.parseInt(req.getParameter("mid"));
		String password = req.getParameter("password");

		HttpSession httpSession = req.getSession();
		int id = (int) httpSession.getAttribute("id");

		AdminService adminService = new AdminService();
		ManagerService managerService = new ManagerService();
		AdminDto adminDto = adminService.getAdminById(id);
		ManagerDto manager = managerService.getManagerById(managerId);
		PrintWriter printWriter = resp.getWriter();
		if (manager != null) {

			if (adminDto.getPassword().equals(password)) {
				adminService.approvedManagerById(id, managerId);
				printWriter.print("<html><body><h1>" + "Manager" + manager.getName() + " is approved Successfully"
						+ "</h1></body></html>");
				printWriter.print("<br><br>");
				printWriter.print("<button type='button'><a href='ApproveAllManager'>Approve All Manager<a/></button>");
			} else {
				printWriter.print("<html><body><h1>" + "Invalid Password" + "</h1></body></html>");
			}
		} else {
			printWriter.print("<html><body><h1>" + "Manager-id not Found" + "</h1></body></html>");
		}
		printWriter.print("<br>");
		printWriter.print("<button type='button'><a href='Admin1.jsp'>home page<a/></button>");
		printWriter.print("<br>");
		printWriter.print("<button type='button'><a href='adminlogout'>Logout</a></button>");

	}

}
