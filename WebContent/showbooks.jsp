<%@ page language="java" import="java.util.*,java.sql.*"
	pageEncoding="gb2312"%>
<!DOCTYPE html>
<%@page import="beans.books"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border=2>
			<tr>
				<td><a href="addBook.jsp">����鱾</a></td>
				<td><a href="findBook.jsp">��ѯ�鱾</a></td>
				<td><a href="checkindex.jsp">�����û�</a></td>
				
			</tr>
			
		</table>
		<%
			ArrayList books = (ArrayList)request.getAttribute("books");
		%>
		<%
			if(books != null)
			{
		%>
		<table border=2>
			<tr>
				<td>���</td>
				<td>����</td>
				<td>����</td>
				<td>�۸�</td>
				<td>��ע</td>
				<td>ѧ��</td>				
			</tr>
			����鵥
			<%
				out.print(books.size());
			%>
			��
			<%
				for (int i = 0; i <books.size(); i++) {
						books book=(books)books.get(i);
			%>
			<tr>
				<td><%=book.getBooknum()   %></td>
				<td><%=book.getBookname() %></td>
				<td><%=book.getAuther() %></td>
				<td><%=book.getPrice()  %></td>
				<td><%=book.getNote()   %></td>
				<td><%=book.getStu_id()   %></td>
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