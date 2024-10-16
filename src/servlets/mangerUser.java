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
		String username=request.getParameter("username");//��ȡ�����û������ַ�����Ϣ
    	String password=request.getParameter("password");//��ȡ����������ַ�����Ϣ
    	System.out.println("����9��");
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
		    	RequestDispatcher requestDispatcher=request.getRequestDispatcher("/manageUser.jsp");//���         RequestDispatcher����
		    	requestDispatcher.forward(request,response);//ת��
			} catch (Exception e) {

				e.printStackTrace();
			}
    		

    	}
		
		
	}

}
