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

import dao.UpcomingTalkDao;
import pojos.TechUser;
import pojos.UpcomingTalk;

/**
 * Servlet implementation class FetchUpcomingTalksOfAUser
 */
@WebServlet("/FetchUpcomingTalksOfAUser")
public class FetchUpcomingTalksOfAUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UpcomingTalkDao uptdao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FetchUpcomingTalksOfAUser() {
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

		TechUser tu = (TechUser) (session.getAttribute("UserDetails"));
		String email = tu.getEmail();
		try {
			talkList = uptdao.getUpcomingTalksByEmailId(email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in fetching details");
			e.printStackTrace();
		}
		if (talkList.isEmpty())
			session.setAttribute("statusMessageUserTalk",
					"You have not registered for any new tech talk.");
		else
			session.setAttribute("MytalkList", talkList);
		response.sendRedirect("WebPages/LoginRegistrationForm/UserTalkDetails.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
