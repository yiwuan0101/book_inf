package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.students;
import beans.studentUtil;

/**
 * Servlet implementation class student_register
 */
@WebServlet("/student_register")
public class student_register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public student_register() {
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
		
		String strstu_id =request.getParameter("stu_id");//获取表单中用户名
		String strstu_pass =request.getParameter("stu_pass");//获取表单中用户名
		students students = new students();
		 int stu_id = Integer.parseInt(strstu_id);
		 int stu_pass = Integer.parseInt(strstu_pass);
		students.setStu_id(stu_id);
		students.setStu_pass(stu_pass);
		studentUtil studentUtil = new studentUtil();
		try {
			if(studentUtil.addStudent(students)==1)
			{
				
				response.getWriter().println("用户成功注册");
					RequestDispatcher requestDispatcher=request.getRequestDispatcher("/student.jsp");//获得         RequestDispatcher对象
			    	requestDispatcher.forward(request,response);//转发
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			
		}

}
