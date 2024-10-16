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
import beans.studentUtil;
import beans.books;

/**
 * Servlet implementation class returnbook
 */
@WebServlet("/returnbook")
public class returnbook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public returnbook() {
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
		int count=0 ;
		String strBooknum=request.getParameter("booknum");//获取表单中书号
		int booknum = Integer.parseInt(strBooknum);
    	String strstu_id =request.getParameter("stu_id");
    	int stu_id =Integer.parseInt(strstu_id);
    	studentUtil studentUtils = new studentUtil();
    	int num = 0;
    	int sstu_id =studentUtils.checkStu_id(booknum);
    	System.out.println(sstu_id+"还书");
    	System.out.println(stu_id+"还书1");
    	if(sstu_id==stu_id) {
    	books books = new books();
    	books.setBooknum(booknum);
    	books.setStu_id(stu_id);
    	studentUtil studentUtil = new studentUtil();
    	count =studentUtil.returnBook(booknum);
    	studentUtil studentUtilss = new studentUtil();
    	
    	try {
			num = studentUtilss.reduceNum(stu_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(count==1)
    	{
    		PrintWriter  out = response.getWriter();
    		out.println("已成功归还" +count+"本");
    		out.println("<a href='http://localhost:8081/Library/student_showbooks.jsp'>"+"返回这里" +"</a>");
    		
    	}
		doGet(request, response);
    	}
    	else {
    		PrintWriter  out = response.getWriter();
    		out.println("您没有借这本书，不要开玩笑");
    		out.println("<a href='http://localhost:8081/Library/student_showbooks.jsp'>"+"返回这里" +"</a>");
    	}
	}

	
}
