<%@ page language="java" import="java.util.*,java.sql.*"
	pageEncoding="gb2312"%>
<!DOCTYPE html>
<%@page import="beans.students"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border=2>
			<tr>
				<td><a href="findUser.jsp">�����û�</a></td>
				
			</tr>
			
		</table>
		<%
			ArrayList students = (ArrayList)request.getAttribute("students");
		%>
		<%
			if(students != null)
			{
		%>
		<table border=2>
			<tr>
				<td>ѧ��</td>
				<td>�û�����</td>
				<td>��������</td>				
			</tr>
			�û�����
			<%
				out.print(students.size());
			%>
			��
			<%
				for (int i = 0; i <students.size(); i++) {
					students student=(students)students.get(i);
			%>
			<tr>
				<td><%=student.getStu_id()   %></td>
				<td><%=student.getStu_pass() %></td>
				<td><%=student.getBook_num() %></td>
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