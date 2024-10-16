package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.catalina.connector.OutputBuffer;

import beans.books;
import beans.students;
public class studentDao {
	public ArrayList queryAllstudent() throws Exception {
		Connection conn = null;
		ArrayList students= new ArrayList();
		try {
			//获取连接
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC","root","020721cy");
			// 运行SQL语句
			String sql = "SELECT stu_id,stu_pass,book_num from stu_login_k";
			System.out.println(sql);
			
						
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while (rs.next()) {
                //实例化VO
			    students student = new students();
			    student.setStu_id(rs.getInt("stu_id"));
			    student.setStu_pass(rs.getInt("stu_pass"));
			    student.setBook_num(rs.getInt("book_num"));				


				students.add(student);
			}
			System.out.println(students);
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
		System.out.println(students);
		return students;
	}
	
	public ArrayList queryAllbook() throws Exception {
		Connection conn = null;
		ArrayList books= new ArrayList();
		try {
			//获取连接
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC","root","020721cy");
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
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC","root","020721cy");
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
	public ArrayList findUser(int stu_id) throws Exception {
		Connection conn = null;
		ArrayList students= new ArrayList();
		try {
			//获取连接
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC","root","020721cy");
			// 运行SQL语句
			String sql="select * from stu_login_k where stu_id='"+stu_id+"'";
			System.out.println(sql);
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);			
			while (rs.next()) {
				students student = new students();
				student.setStu_id(rs.getInt("stu_id"));
				student.setStu_pass(rs.getInt("stu_pass"));
				student.setBook_num(rs.getInt("book_num"));	


				students.add(student);					
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
		return students;
	}

}

