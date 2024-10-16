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

@WebServlet("/addbook")
public class addbook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public addbook() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		response.setCharacterEncoding("gb2312");
		int count=0 ;
		String strBooknum=request.getParameter("booknum");//��ȡ�������
		int booknum = Integer.parseInt(strBooknum);
    	String bookname=request.getParameter("bookname");//��ȡ��������
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
			count =adminUtil.addbook(books);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(count==1)
    	{
    		PrintWriter  out = response.getWriter();
    		out.println("�ѳɹ����" +count+"����¼");
    		out.println("<a href='showbooks.jsp'>"+"��������" +"</a>");
    		
    	}
		doGet(request, response);
	}

}
