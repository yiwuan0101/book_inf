<%@ page import="beans.students"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" pageEncoding="gb2312"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>²éÑ¯ÓÃ»§</title>
</head>
<body>
<form action="servlets/findUser"  " method="post">
		Ñ§ºÅ£º<input name="stu_id" type="text"><BR>
	
		<input type="submit" value="²éÑ¯">	
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
				<td>Ñ§ºÅ</td>
				<td>ÓÃ»§ÃÜÂë</td>
				<td>½èÊéÊýÁ¿</td>	
				<td>É¾³ý</td>
				
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


				<td><a href="http://localhost:8081/Library/servlets/deleteUser?stu_id=<%= stu_id %>">É¾³ý</a></td>

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