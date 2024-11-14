package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bean.User;
import com.dao.UserDao;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String friendsStr = req.getParameter("friends");
        List<String> friends = Arrays.asList(friendsStr.split(","));
        User user = new User(name, phone);
        user.setFriends(friends);
        UserDao userDao = new UserDao();
        Boolean isInserted = userDao.addUser(user);
        if (!isInserted) {
            resp.setStatus(404);
            req.getRequestDispatcher("updatefail.jsp").forward(req, resp);
            return;
        }
        req.setAttribute("model", user);
        req.getRequestDispatcher("showuser.jsp").forward(req, resp);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
