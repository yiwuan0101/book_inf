<%@ page import="beans.students"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" pageEncoding="gb2312"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>��ѯ�û�</title>
</head>
<body>
<form action="servlets/findUser"  " method="post">
		ѧ�ţ�<input name="stu_id" type="text"><BR>
	
		<input type="submit" value="��ѯ">	
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
				<td>ѧ��</td>
				<td>�û�����</td>
				<td>��������</td>	
				<td>ɾ��</td>
				
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


				<td><a href="http://localhost:8081/Library/servlets/deleteUser?stu_id=<%= stu_id %>">ɾ��</a></td>

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