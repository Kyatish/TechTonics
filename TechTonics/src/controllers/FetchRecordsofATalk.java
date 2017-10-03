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

import pojos.Audience;
import pojos.TechUser;
import dao.AudienceDao;

/**
 * Servlet implementation class FetchRecordsofATalk
 */
@WebServlet("/FetchRecordsofATalk")
public class FetchRecordsofATalk extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AudienceDao audianceDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FetchRecordsofATalk() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() throws ServletException {
		try {
			System.out.println("in init" + Thread.currentThread());
			// ServletConfig sc = getServletConfig();
			audianceDao = new AudienceDao();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException("Err in init", e);
		}
	}

	public void destroy() {
		System.out.println("in destroy" + Thread.currentThread());
		if (audianceDao != null)
			try {
				audianceDao.cleanUp();
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
		List<Audience> audienceListbyTalkId = new ArrayList<>();
		HttpSession session = request.getSession();
		int talkId = Integer.parseInt(request.getParameter("Id"));
		try {
			audienceListbyTalkId = audianceDao.getAudienceById(talkId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String status = "Audience List for TalkId: " + talkId;
		if (audienceListbyTalkId.isEmpty())
			status = "No members yet registered.";
		else
			session.setAttribute("audienceList", audienceListbyTalkId);
		session.setAttribute("statusMessageFetchDetail", status);
		response.sendRedirect("temolates/users/TalkDetails.jsp");
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
