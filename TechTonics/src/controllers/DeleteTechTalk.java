package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UpcomingTalkDao;

/**
 * Servlet implementation class DeleteTechTalk
 */
@WebServlet("/DeleteTalk")
public class DeleteTechTalk extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UpcomingTalkDao uptdao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTechTalk() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException
	{
		try
		{
			System.out.println("in init" + Thread.currentThread());
			//ServletConfig sc = getServletConfig();
			uptdao = new UpcomingTalkDao();			
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
		if (uptdao != null)
			try
			{
				uptdao.cleanUp();
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
		
		int talkId = Integer.parseInt(request.getParameter("talkIdEmployee"));
		System.out.println(talkId);
		String status = "Deletion Successful";
		try {
			if(!uptdao.deleteTalkById(talkId));
				status = "Sorry Deletion failed";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		session.setAttribute("statusMessage", status);
		response.sendRedirect("WebPages/LoginRegistrationForm/AdminHome.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
