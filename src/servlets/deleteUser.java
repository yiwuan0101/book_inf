package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.adminUtil;

/**
 * Servlet implementation class deleteUser
 */
@WebServlet("/deleteUser")
public class deleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("gb2312");
		response.setCharacterEncoding("gb2312");
		boolean flag = false;
		String strstu_id = (String) request.getParameter("stu_id");
		int stu_id = Integer.parseInt(strstu_id);
    	adminUtil adminUtil = new adminUtil();
    	try {
			flag =adminUtil.deleteUser(stu_id);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    	if(flag)
    	{
    		PrintWriter  out = response.getWriter();
    		out.println("已成功删除用户");
    		out.println("<a href='http://localhost:8081/Library/manageUser.jsp'>"+"返回这里" +"</a>");
    		
    	}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
