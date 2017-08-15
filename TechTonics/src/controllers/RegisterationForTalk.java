package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AudienceDao;
import pojos.Audience;
import pojos.TechUser;
import pojos.UpcomingTalk;

/**
 * Servlet implementation class RegisterationForTalk
 */
@WebServlet("/RegisterationForTalk")
public class RegisterationForTalk extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AudienceDao audianceDao; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterationForTalk() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() throws ServletException
	{
		try
		{
			System.out.println("in init" + Thread.currentThread());
			//ServletConfig sc = getServletConfig();
			audianceDao = new AudienceDao();			
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new ServletException("Err in init", e);
		}
	}

	public void destroy()
	{
		System.out.println("in destroy" + Thread.currentThread());
		if (audianceDao != null)
			try
			{
				audianceDao.cleanUp();
			}
			catch (Exception e)
			{
				throw new RuntimeException("err in destroy", e);
			}		
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		TechUser techUser = (TechUser)session.getAttribute("UserDetails");
		//System.out.println(request.getParameter("talkIdEmployee"));
		int talkId = Integer.parseInt(request.getParameter("talkIdEmployee"));
		//System.out.println(talkId);
		Audience audience = new Audience(talkId,techUser.getEmail(),techUser.getUserName());
		String status = "You are successfully registered for TalkId: " + talkId;
		if(!audianceDao.insertNewAudience(audience))
			status = "You are already registered for this talk.";
		session.setAttribute("statusMessage", status);
		response.sendRedirect("WebPages/LoginRegistrationForm/employee.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
