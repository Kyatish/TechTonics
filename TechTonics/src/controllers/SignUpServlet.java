package controllers;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

//import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TechUserDao;
import pojos.TechUser;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUp")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TechUserDao tudao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUpServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() throws ServletException {
		try {
			System.out.println("in init" + Thread.currentThread());
			// ServletConfig sc = getServletConfig();
			tudao = new TechUserDao();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException("Err in init", e);
		}
	}

	public void destroy() {
		System.out.println("in destroy" + Thread.currentThread());
		if (tudao != null)
			try {
				tudao.cleanUp();
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
		TechUser tu = new TechUser(request.getParameter("emailsignup"),
				request.getParameter("namesignup"),
				request.getParameter("passwordsignup"), Date.valueOf(LocalDate
						.now()));
		String status = "Registeration Successful. Please login for further details";
		try {
			if (!tudao.setTechUserDetails(tu))
				status = "Registeration failed";
			else
				response.getWriter().write("Registeration failed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HttpSession session = request.getSession();
		session.setAttribute("signupStatus", status);
		// RequestDispatcher
		// rd=request.getRequestDispatcher("WebPages/LoginRegistrationForm/index.jsp");
		// servlet2 is the url-pattern of the second servlet

		// rd.forward(request, response);//method may be include or forward
		response.sendRedirect("WebPages/LoginRegistrationForm/index.jsp");
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
