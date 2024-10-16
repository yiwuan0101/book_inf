package servlets;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import beans.adminUtil;

import beans.admin;
import dao.bookDao;
@WebServlet("/checklogin_Servlet")
public class checklogin_Servlet extends HttpServlet {
	
    public checklogin_Servlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("gb2312");
		String username=request.getParameter("username");//��ȡ�����û������ַ�����Ϣ
    	String password=request.getParameter("password");//��ȡ����������ַ�����Ϣ
    	
    	adminUtil adminUtil = new adminUtil();
    	admin admin = new admin();
    	admin.setUsername(username);
    	admin.setPassword(password);
    	if (adminUtil.findAdmin(admin)){
    		
    		bookDao bookDao = new bookDao();
			try {
				ArrayList books= bookDao.queryAllbook();

	    		request.setAttribute("books",books);
	    		System.out.println(books);
		    	RequestDispatcher requestDispatcher=request.getRequestDispatcher("/showbooks.jsp");//���         RequestDispatcher����
		    	requestDispatcher.forward(request,response);//ת��
			} catch (Exception e) {

				e.printStackTrace();
			}
    		

    	}
		
		
	}

}