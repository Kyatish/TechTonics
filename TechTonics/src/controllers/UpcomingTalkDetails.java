package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojos.TechUser;
import pojos.UpcomingTalk;
import dao.TechUserDao;
import dao.UpcomingTalkDao;

/**
 * Servlet implementation class UpcomingTalkDetails
 */
@WebServlet("/TalkDesk")
public class UpcomingTalkDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UpcomingTalkDao uptdao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpcomingTalkDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() throws ServletException {
		try {
			System.out.println("in init" + Thread.currentThread());
			// ServletConfig sc = getServletConfig();
			uptdao = new UpcomingTalkDao();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException("Err in init", e);
		}
	}

	public void destroy() {
		System.out.println("in destroy" + Thread.currentThread());
		if (uptdao != null)
			try {
				uptdao.cleanUp();
			} catch (Exception e) {
				throw new RuntimeException("err in destroy", e);
			}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<UpcomingTalk> talkList = new ArrayList<>();
		HttpSession session = request.getSession();
		try {
			talkList = uptdao.getAllUpcomingTalks();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (talkList.isEmpty())
			session.setAttribute("statusMessage",
					"No upcoming tech talks to show.");
		else
			session.setAttribute("talkLists", talkList);
		if (((TechUser) session.getAttribute("UserDetails")).getEmail().equals(
				"yatish@atmecs.com"))
			response.sendRedirect("WebPages/LoginRegistrationForm/AdminHome.jsp");
		else
			response.sendRedirect("WebPages/LoginRegistrationForm/employee.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
