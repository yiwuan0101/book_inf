package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.catalina.connector.OutputBuffer;
import beans.books;

public class bookDao {
	
	
	public ArrayList queryAllbook() throws Exception {
		Connection conn = null;
		ArrayList books= new ArrayList();
		try {
			//获取连接
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC","root","021019lx");
			// 运行SQL语句
			String sql = "SELECT booknum,bookname,auther,price,note,stu_id from books";
			System.out.println(sql);
			
						
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while (rs.next()) {
                //实例化VO
				books book = new books();
				book.setBooknum(rs.getInt("booknum"));
				book.setBookname(rs.getString("bookname"));
				book.setAuther(rs.getString("auther"));				
				book.setPrice(rs.getFloat("price"));	
				book.setNote(rs.getString("note"));
				book.setStu_id(rs.getInt("stu_id"));

				books.add(book);
			}
			System.out.println(books);
			rs.close();
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {// 关闭连接
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Exception ex) {
			}
		}
		return books;
	}
	
	public ArrayList findBook(String bookname) throws Exception {
		Connection conn = null;
		ArrayList books= new ArrayList();
		try {
			//获取连接
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC","root","021019lx");
			// 运行SQL语句
			String sql="select * from books where bookname='"+bookname+"'";
			System.out.println(sql);
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			System.out.println("cuowu1");			
			while (rs.next()) {
				books book = new books();
				book.setBooknum(rs.getInt("booknum"));
				book.setBookname(rs.getString("bookname"));
				book.setAuther(rs.getString("auther"));	
				book.setPrice(rs.getFloat("price"));	
				book.setNote(rs.getString("note"));
				book.setStu_id(rs.getInt("stu_id"));

				books.add(book);
				System.out.println("cuowu2");					
			}
			rs.close();
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {// 关闭连接
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Exception ex) {
			}
		}
		return books;
	}
	

}
