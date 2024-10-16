package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class adminUtil {
		private static Connection con;	
		//查询数据库表中的信息是否存在
		public static boolean findAdmin(admin admin){			
			con=(new DBConnect()).getConnection();
			boolean flag=false;
			Statement stmt;
			ResultSet rs;		
			String sql="select * from admin_login_k where admin_id='"+admin.getUsername()+"' and admin_pass='"+admin.getPassword()+"'";
			try{
				stmt=con.createStatement();
				rs=stmt.executeQuery(sql);
				if (rs.next())
					flag=true;
				rs.close();
				stmt.close();
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			return flag;
		}
		public int addbook(books books) throws SQLException{			
			con=(new DBConnect()).getConnection();
			boolean flag=false;
			Statement stmt;
			ResultSet rs;		
			
			String sql = "INSERT INTO books(booknum,bookname,auther,price,note) VALUES(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, books.getBooknum());
			ps.setString(2, books.getBookname());
			ps.setString(3, books.getAuther());
			ps.setFloat(4, books.getPrice());
			ps.setString(5, books.getNote());
			int i = ps.executeUpdate();
			System.out.println("成功添加" + i + "行");
			ps.close();
			con.close();
			return i;
		}
		//查询数据库表中的信息是否存在
		public boolean findBook(String bookName){			
			con=(new DBConnect()).getConnection();
			boolean flag=false;
			Statement stmt;
			ResultSet rs;		
			String sql="select * from books where bookname='"+bookName+"'";
			try{
				stmt=con.createStatement();
				rs=stmt.executeQuery(sql);
				if (rs.next())
					flag=true;
				rs.close();
				stmt.close();
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			return flag;
		}
		public boolean modifyBook(books books) throws SQLException
		{
			
			con=(new DBConnect()).getConnection();
			boolean flag=false;
			Statement stmt;
			ResultSet rs;		
			
			String sql = "update books set booknum=? , auther=? , price=? ,note=? where bookname=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, books.getBooknum());
			ps.setString(2, books.getAuther());
			ps.setFloat(3, books.getPrice());
			ps.setString(4, books.getNote());
			ps.setString(5, books.getBookname());
			int i = ps.executeUpdate();
			System.out.println("成功修改" + i + "行数据");
			ps.close();
			con.close();
			if(i==1) 
				return true;
			else
				return false;
		}
		
		public boolean deleteBook(String bookname) throws SQLException
		{
			
			con=(new DBConnect()).getConnection();
			boolean flag=false;
			Statement stmt;
			ResultSet rs;		
			
			String sql = "delete from books  where bookname=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,bookname);
			System.out.println("下架书本："+bookname);
			
			int i = ps.executeUpdate();
			System.out.println("成功删除" + i + "行");
			ps.close();
			con.close();
			if(i==1) 
				return true;
			else
				return false;
		}
		public boolean findUser(int stu_id){			
			con=(new DBConnect()).getConnection();
			boolean flag=false;
			Statement stmt;
			ResultSet rs;		
			String sql="select * from stu_login_k where stu_id='"+stu_id+"'";
			try{
				stmt=con.createStatement();
				rs=stmt.executeQuery(sql);
				if (rs.next())
					flag=true;
				rs.close();
				stmt.close();
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			return flag;
		}
		public boolean deleteUser(int stu_id) throws SQLException
		{
			
			con=(new DBConnect()).getConnection();
			boolean flag=false;
			Statement stmt;
			ResultSet rs;		
			
			String sql = "delete from stu_login_k  where stu_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,stu_id);
			System.out.println("删除用户："+stu_id);
			
			int i = ps.executeUpdate();
			System.out.println("成功删除" + i + "行");
			ps.close();
			con.close();
			if(i==1) 
				return true;
			else
				return false;
		}
		
		public int addAdmin(admin admin) throws SQLException{			
			con=(new DBConnect()).getConnection();
			boolean flag=false;
			Statement stmt;
			ResultSet rs;		
			
			String sql = "INSERT INTO admin_login_k(admin_id,admin_pass) VALUES(?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, admin.getUsername());
			ps.setString(2, admin.getPassword());
			
			int i = ps.executeUpdate();
			System.out.println("成功添加" + i + "行");
			ps.close();
			con.close();
			return i;
		}

}


