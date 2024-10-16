package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.students;
import beans.studentUtil;
import dao.bookDao;
import dao.studentDao;

/**
 * Servlet implementation class check
 */
@WebServlet("/check")
public class check extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public check() {
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
		response.setCharacterEncoding("gb2312");
		String strstu_id=request.getParameter("stu_id");//获取表单中用户名的字符串信息
    	String strstu_pass=request.getParameter("stu_pass");//获取表单中密码的字符串信息
    	int stu_id = Integer.parseInt(strstu_id);
    	int stu_pass = Integer.parseInt(strstu_pass);
    	studentUtil studentUtil = new studentUtil();
    	students students = new students();
    	students.setStu_id(stu_id);
    	students.setStu_pass(stu_pass);
    	if (studentUtil.findStudent(students)){
    		
    		bookDao bookDao = new bookDao();
			try {
				ArrayList books= bookDao.queryAllbook();

	    		request.setAttribute("books",books);
		    	
		    	RequestDispatcher requestDispatcher=request.getRequestDispatcher("/student_showbooks.jsp");//获得         RequestDispatcher对象
		    	requestDispatcher.forward(request,response);//转发
			} catch (Exception e) {

				e.printStackTrace();
			}
    		

    	}
		
		
	}

	
}
