package beans;
import java.sql.*;

public class DBConnect {
Connection con=null;


static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
static final String DB_URL = "jdbc:mysql://localhost:3306/student?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";//����Ϊ�Լ������ڵ����ݿ�����


// ���ݿ���û��������룬��Ҫ�����Լ�������
static final String USER = "root";
static final String PASS = "021019lx";

public DBConnect() {		
}	
public Connection getConnection(){
	try{					
	Class.forName(JDBC_DRIVER);			
	con=DriverManager.getConnection(DB_URL,USER,PASS);
	System.out.println("���ݿ����ӳɹ���");
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}catch(SQLException e){
		e.printStackTrace();
	}
	return con;
	}	
}
