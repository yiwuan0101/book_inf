package beans;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class studentUtil {
	private static Connection con;
	public static boolean findStudent(students students){			
		con=(new DBConnect()).getConnection();
		boolean flag=false;
		Statement stmt;
		ResultSet rs;		
		String sql="select * from stu_login_k where stu_id='"+students.getStu_id()+"' and stu_pass='"+students.getStu_pass()+"'";
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
		
		String sql = "update books set booknum=? , auther=? , price=? ,note=?,stu_id=? where bookname=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, books.getBooknum());
		ps.setString(2, books.getAuther());
		ps.setFloat(3, books.getPrice());
		ps.setString(4, books.getNote());
		ps.setInt(5, books.getStu_id());
		ps.setString(6, books.getBookname());
		int i = ps.executeUpdate();
		System.out.println("成功修改" + i + "行数据");
		ps.close();
		con.close();
		if(i==1) 
			return true;
		else
			return false;
	}
	public int addStudent(students students) throws SQLException{			
		con=(new DBConnect()).getConnection();
		boolean flag=false;
		Statement stmt;
		ResultSet rs;		
		
		String sql = "INSERT INTO stu_login_k(stu_id,stu_pass) VALUES(?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, students.getStu_id());
		ps.setInt(2, students.getStu_pass());
		
		int i = ps.executeUpdate();
		System.out.println("成功添加" + i + "行");
		ps.close();
		con.close();
		return i;
	}
	
	public int checkNum(int stu_id){			
		con=(new DBConnect()).getConnection();
		boolean flag=false;
		Statement stmt;
		ResultSet rs;
		int book_num = 0;
		String sql="select book_num from stu_login_k where stu_id='"+stu_id+"'";
		try{
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			 
			 
			if (rs.next())
				book_num =rs.getInt(1);
				System.out.println(book_num);
				flag=true;
			rs.close();
			stmt.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return book_num;
	}
	public int checkStu_id(int booknum){			
		con=(new DBConnect()).getConnection();
		boolean flag=false;
		Statement stmt;
		ResultSet rs;
		int sstu_id =0;
		String sql="select stu_id from books where booknum='"+booknum+"'";
		try{
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			 
			 
			if (rs.next())
				sstu_id =rs.getInt(1);
				System.out.println(booknum);
				System.out.println(sstu_id+"功能");
				flag=true;
			rs.close();
			stmt.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return sstu_id;
	}
	public int returnBook(int booknum){			
		con=(new DBConnect()).getConnection();
		Statement stmt;
		ResultSet rs;
		int stu_id = 0;
		int i =0;
		String sql="update books set stu_id='"+stu_id+"'where booknum ='"+booknum+"'";
		int count = 1;
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			 i=ps.executeUpdate(sql);
			ps.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return i;
	}
	public int addNum(int stu_id) throws SQLException{			
		con=(new DBConnect()).getConnection();
		boolean flag=false;
		Statement stmts;
		ResultSet rss;
		int book_num = 0;
		String sql1="select book_num from stu_login_k where stu_id='"+stu_id+"'";
		stmts=con.createStatement();
		
		rss=stmts.executeQuery(sql1);
		if (rss.next())
			book_num =rss.getInt(1)+1;
			System.out.println(book_num);
			flag=true;

		String sql="update stu_login_k set book_num='"+book_num+"'where stu_id ='"+stu_id+"'";
		try{
			Statement stmt;
			ResultSet rs;
			PreparedStatement ps = con.prepareStatement(sql);
			int i=ps.executeUpdate(sql);
			ps.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return book_num;
	}
	public int reduceNum(int stu_id) throws SQLException{			
		con=(new DBConnect()).getConnection();
		boolean flag=false;
		Statement stmts;
		ResultSet rss;
		int book_num = 0;
		String sql1="select book_num from stu_login_k where stu_id='"+stu_id+"'";
		stmts=con.createStatement();
		
		rss=stmts.executeQuery(sql1);
		if (rss.next())
			book_num =rss.getInt(1)-1;
			System.out.println(book_num);
			flag=true;

		String sql="update stu_login_k set book_num='"+book_num+"'where stu_id ='"+stu_id+"'";
		try{
			Statement stmt;
			ResultSet rs;
			PreparedStatement ps = con.prepareStatement(sql);
			int i=ps.executeUpdate(sql);
			ps.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return book_num;
	}
	
}
