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
import dao.bookDao;

/**
 * Servlet implementation class findbook
 */
@WebServlet("/findbook")
public class findbook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public findbook() {
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
		
		String bookname =request.getParameter("bookname");//获取表单中学生姓名
		
		adminUtil adminUtil = new adminUtil();
		if(adminUtil.findBook(bookname))
		{
			bookDao bookDao = new bookDao();
			try {
				ArrayList books=(ArrayList) bookDao.findBook(bookname);
				System.out.println(books);		
	    		request.setAttribute("books",books);	
	    		RequestDispatcher requestDispatcher=request.getRequestDispatcher("/findBook.jsp");//获得         RequestDispatcher对象
		    	requestDispatcher.forward(request,response);//转发	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		doGet(request, response);
	}
}