package controller;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.registry.infomodel.User;

import model.*;

/**
 * Servlet implementation class RegProc
 */
@WebServlet("/RegProc")
public class RegProc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegProc() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserInfo uBean = (UserInfo) request.getAttribute("userInfo");
		List<UserInfo> uBeanList = DBUser.findAllUsers();
		for (UserInfo u : uBeanList) {//有冲突，失败
			if (u.getId() == uBean.getId()) {
				request.getRequestDispatcher("register_failure.jsp").forward(request, response);
			}
		}
		//无冲突，存入
		DBUser.AddUser(uBean);
		request.getRequestDispatcher("register_success.jsp").forward(request, response);
		

		// response.sendRedirect("register_failure.jsp");
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
