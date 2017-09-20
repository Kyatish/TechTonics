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

import dao.UpcomingTalkDao;
import pojos.UpcomingTalk;

/**
 * Servlet implementation class CreateTalk
 */
@WebServlet("/CreateTalk")
public class CreateTalk extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UpcomingTalkDao uptdao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateTalk() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void service() throws ServletException {

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
		// System.out.println(request.getParameter("timeTalk")+":00");
		Time time = Time.valueOf(request.getParameter("timeTalk") + ":00");
		String description = request.getParameter("descriptionTalk");
		UpcomingTalk newTalk = new UpcomingTalk(title, presenter, venue, date,
				time, description);
		String status = "Insertion Successful";
		try {
			if (!uptdao.setNewTechTalk(newTalk))
				status = "Sorry Insertion failed";
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
		doGet(request, response);
	}

}
