<%@ page import="beans.students"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" pageEncoding="gb2312"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>查询用户</title>
</head>
<body>
<form action="servlets/findUser"  " method="post">
		学号：<input name="stu_id" type="text"><BR>
	
		<input type="submit" value="查询">	
	</form>
	<%
		ArrayList students = (ArrayList)request.getAttribute("students");
	%>
		<%
			if(students != null)
			{
		%>
		<table border=2>
			<tr>
				<td>学号</td>
				<td>用户密码</td>
				<td>借书数量</td>	
				<td>删除</td>
				
			</tr>
			<%
				out.print(students.size());
			%>
			<%
				for (int i = 0; i < students.size(); i++) {
					students student=(students)students.get(i);
						System.out.println(student);
						int stu_id = student.getStu_id();
			%>
			<tr>
				<td><%=student.getStu_id()   %></td>
				<td><%=student.getStu_pass() %></td>
				<td><%=student.getBook_num() %></td>


				<td><a href="http://localhost:8081/Library/servlets/deleteUser?stu_id=<%= stu_id %>">删除</a></td>

			</tr>
			<%
				}
			%>
		</table>
		<%
			}
		%>

		
</body>
</html>