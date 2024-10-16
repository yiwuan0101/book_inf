package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import beans.admin;
import beans.adminUtil;


import dao.studentDao;

/**
 * Servlet implementation class mangerUser
 */
@WebServlet("/mangerUser")
public class mangerUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mangerUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("gb2312");
		String username=request.getParameter("username");//获取表单中用户名的字符串信息
    	String password=request.getParameter("password");//获取表单中密码的字符串信息
    	System.out.println("错误9！");
    	adminUtil adminUtil = new adminUtil();
    	admin admin = new admin();
    	admin.setUsername(username);
    	admin.setPassword(password);
    	if (adminUtil.findAdmin(admin)){
    		
    		studentDao studentDao = new studentDao();
			try {
				ArrayList students= studentDao.queryAllstudent();

	    		request.setAttribute("students",students);
	    		System.out.println(students);
		    	RequestDispatcher requestDispatcher=request.getRequestDispatcher("/manageUser.jsp");//获得         RequestDispatcher对象
		    	requestDispatcher.forward(request,response);//转发
			} catch (Exception e) {

				e.printStackTrace();
			}
    		

    	}
		
		
	}

}
