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
 * Servlet implementation class deletebook
 */
@WebServlet("/deletebook")
public class deletebook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deletebook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		response.setCharacterEncoding("gb2312");
		boolean flag = false;
		String bookname = (String) request.getParameter("bookname");

    	adminUtil adminUtil = new adminUtil();
    	try {
			flag =adminUtil.deleteBook(bookname);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    	if(flag)
    	{
    		PrintWriter  out = response.getWriter();
    		out.println("已成功下架书本");
    		out.println("<a href='http://localhost:8081/Library/showbooks.jsp'>"+"返回这里" +"</a>");
    		
    	}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
		
	}

}
