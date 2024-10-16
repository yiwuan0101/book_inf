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
import beans.books;
import beans.studentUtil;
/**
 * Servlet implementation class borrowbook
 */
@WebServlet("/borrowbook")
public class borrowbook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public borrowbook() {
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
		boolean flag = false;
    	String bookname=request.getParameter("bookname");//获取表单中书名
		String strBooknum=request.getParameter("booknum");//获取表单中书号
		int booknum = Integer.parseInt(strBooknum);
    	String auther = request.getParameter("auther");//获取表单中作者名    	
    	String strPrice = request.getParameter("price");//获取表单中价格
    	float price = Float.parseFloat(strPrice); 
    	String note =request.getParameter("note");//获取表单中备注   
    	String strstu_id =request.getParameter("stu_id");
    	int stu_id = Integer.parseInt(strstu_id);
    	studentUtil studentUtil=new studentUtil();
    	int book_num =studentUtil.checkNum(stu_id);
    	System.out.println(book_num);
    	if(book_num<8) {
    	books books = new books();
    	books.setBooknum(booknum);
    	books.setBookname(bookname);
    	books.setAuther(auther);
    	books.setPrice(price);
    	books.setNote(note);
    	books.setStu_id(stu_id);
    	
    	studentUtil studentUtils= new studentUtil();
    	try {
			flag =studentUtils.modifyBook(books);//(studScore);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	if(flag)
    	{
    		studentUtil studentUtilss=new studentUtil();
    		try {
				int num =studentUtilss.addNum(stu_id);
				System.out.println("数量"+num);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		PrintWriter  out = response.getWriter();
    		out.println("借书成功");
    		out.println("<a href='http://localhost:8081/Library/student_showbooks.jsp'>"+"返回这里" +"</a>");
    		
    	}
		
    	}
    	else {
    		PrintWriter  out = response.getWriter();
    		out.println("每个人手上最多8本书，请先还书");
    		out.println("<a href='http://localhost:8081/Library/student_showbooks.jsp'>"+"返回这里" +"</a>");
    	}
		
		doGet(request, response);
	}

}
