package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.books;
import beans.adminUtil;

/**
 * Servlet implementation class modifybook
 */
@WebServlet("/modifybook")
public class modifybook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifybook() {
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
		request.setCharacterEncoding("gb2312");
		response.setCharacterEncoding("gb2312");
		boolean flag = false;
    	String bookname=request.getParameter("bookname");//��ȡ��������
		String strBooknum=request.getParameter("booknum");//��ȡ�������
		int booknum = Integer.parseInt(strBooknum);
    	String auther = request.getParameter("auther");//��ȡ����������    	
    	String strPrice = request.getParameter("price");//��ȡ���м۸�
    	float price = Float.parseFloat(strPrice); 
    	String note =request.getParameter("note");//��ȡ���б�ע   
    	books books = new books();
    	books.setBooknum(booknum);
    	books.setBookname(bookname);
    	books.setAuther(auther);
    	books.setPrice(price);
    	books.setNote(note);
    	adminUtil adminUtil = new adminUtil();
    	try {
			flag =adminUtil.modifyBook(books);//(studScore);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(flag)
    	{
    		PrintWriter  out = response.getWriter();
    		out.println("�ѳɹ������鱾��¼");
    		out.println("<a href='http://localhost:8081/Library/showbooks.jsp'>"+"��������" +"</a>");
    		
    	}
		
		
		
		doGet(request, response);
	}

}
