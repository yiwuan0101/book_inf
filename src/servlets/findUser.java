package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.adminUtil;
import dao.studentDao;

/**
 * Servlet implementation class findUser
 */
@WebServlet("/findUser")
public class findUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public findUser() {
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
		
		String strstu_id =request.getParameter("stu_id");
		int stu_id = Integer.parseInt(strstu_id);
		adminUtil adminUtil = new adminUtil();
		if(adminUtil.findUser(stu_id))
		{
			studentDao studentDao = new studentDao();
			try {
				ArrayList students=(ArrayList) studentDao.findUser(stu_id);
				System.out.println(students);		
	    		request.setAttribute("students",students);	
	    		RequestDispatcher requestDispatcher=request.getRequestDispatcher("/findUser.jsp");//获得         RequestDispatcher对象
		    	requestDispatcher.forward(request,response);//转发	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		doGet(request, response);
	}

}
