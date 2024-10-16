package beans;
import java.sql.*;

public class DBConnect {
Connection con=null;


static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
static final String DB_URL = "jdbc:mysql://localhost:3306/student?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";//这里为自己表所在的数据库名称


// 数据库的用户名与密码，需要根据自己的设置
static final String USER = "root";
static final String PASS = "021019lx";

public DBConnect() {		
}	
public Connection getConnection(){
	try{					
	Class.forName(JDBC_DRIVER);			
	con=DriverManager.getConnection(DB_URL,USER,PASS);
	System.out.println("数据库连接成功！");
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}catch(SQLException e){
		e.printStackTrace();
	}
	return con;
	}	
}
