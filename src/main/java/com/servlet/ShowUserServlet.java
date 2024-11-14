package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bean.User;
import com.dao.UserDao;
import java.util.Collection;

/**
 * Servlet implementation class ShowUserServlet
 */
@WebServlet("/showuser")
public class ShowUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String userId = request.getParameter("id");
		System.out.println("OK");
        if (userId == null){
            throw new ServletException("Missing parameter id");
        }
        UserDao userDao = new UserDao();
        User user = userDao.getUser(userId);
        // user not found
        if (user == null){
        	response.setStatus(404);
        	request.getRequestDispatcher("notfound.jsp").forward(request, response);
            return;
        }
        // Forward the request to showuser.jsp to render the user page
        request.setAttribute("model", user);
        request.getRequestDispatcher("showuser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
