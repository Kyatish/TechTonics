package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojos.TechUser;
import dao.TechUserDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TechUserDao tudao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException
	{
		try
		{
			System.out.println("in init" + Thread.currentThread());
			//ServletConfig sc = getServletConfig();
			tudao = new TechUserDao();			
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
		if (tudao != null)
			try
			{
				tudao.cleanUp();
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
		TechUser techUser = null;
		//List<TechUser> userList= new ArrayList<>();
		String status = "Logged in successful";
		HttpSession session = request.getSession();
		try {
			techUser = tudao.getTechUserDetails(request.getParameter("emaillogin"), request.getParameter("passwordlogin"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		System.out.println(techUser);
		if(techUser == null){
			status = "Sorry!Invalid credentials.";			
			session.setAttribute("loginStatus", status);
			response.sendRedirect("WebPages/LoginRegistrationForm/index.jsp");
		}
		else{
			//userList.add(techUser);
			//session.setAttribute("listUsers", userList);
			session.setAttribute("UserDetails", techUser);
			response.sendRedirect("TalkDesk");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
