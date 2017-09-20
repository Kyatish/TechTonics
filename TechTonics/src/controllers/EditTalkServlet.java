package controllers;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojos.UpcomingTalk;
import dao.UpcomingTalkDao;

/**
 * Servlet implementation class EditTalkServlet
 */
@WebServlet("/UpdateTalk")
public class EditTalkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UpcomingTalkDao uptdao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditTalkServlet() {
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
		String title = request.getParameter("titleTalk");
		String venue = request.getParameter("venueTalk");
		String presenter = request.getParameter("presenterTalk");
		Date date = Date.valueOf(request.getParameter("dateTalk"));
		System.out.println(request.getParameter("talkIdEmployee"));
		String timeString = request.getParameter("timeTalk");
		if (timeString.length() == 5) {
			timeString = timeString.concat(":00");
		}
		Time time = Time.valueOf(timeString);

		String description = request.getParameter("descriptionTalk");
		int talkId = Integer.parseInt(request.getParameter("talkIdEmployee"));
		UpcomingTalk newTalk = new UpcomingTalk(title, presenter, venue, date,
				time, description);
		String status = "Updation Successful";
		try {
			if (!uptdao.updateTalkById(newTalk, talkId))
				status = "Sorry Updation failed";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		session.setAttribute("statusMessage", status);
		response.sendRedirect("TalkDesk");
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
