<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	��ӭ��¼��ϵͳ
	<form action="http://localhost:8081/Library/student_checklogin.jsp"  " method="post">
		���������˺ţ�<input name="stu_id" type="text"><BR>
		�����������룺<input name="stu_pass" type="password"><BR>
		<input type="submit" value="��¼">	 <label>û���˺�<a href ="student_register.jsp">���ע��</a></label>
	</form>
</body>
</html>