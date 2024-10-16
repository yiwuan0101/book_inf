package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.adminUtil;
import beans.admin;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
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
		request.setCharacterEncoding("gb2312");
		response.setCharacterEncoding("gb2312");
		
		String username =request.getParameter("username");//获取表单中用户名
		String password =request.getParameter("password");//获取表单中用户名
		admin admin = new admin();
		admin.setUsername(username);
		admin.setPassword(password);
		adminUtil adminUtil = new adminUtil();
		try {
			if(adminUtil.addAdmin(admin)==1)
			{
				
				response.getWriter().println("用户成功注册");
					RequestDispatcher requestDispatcher=request.getRequestDispatcher("/admin.jsp");//获得         RequestDispatcher对象
			    	requestDispatcher.forward(request,response);//转发
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			
		}

}
