<%@ page import="beans.books"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" pageEncoding="gb2312"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>��ѯ�鱾</title>
</head>
<body>
<form action="servlets/findbook"  " method="post">
		������<input name="bookname" type="text"><BR>
	
		<input type="submit" value="��ѯ">	
	</form>
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
				<td>������</td>
				<td>�޸�</td>
				<td>ɾ��</td>
				
			</tr>
			<%
				out.print(books.size());
			%>
			<%
				for (int i = 0; i < books.size(); i++) {
						books book=(books)books.get(i);
						System.out.println(book);
						System.out.println("����һ");
						String bookname = book.getBookname();
			%>
			<tr>
				<td><%=book.getBooknum()   %></td>
				<td><%=book.getBookname() %></td>
				<td><%=book.getAuther() %></td>
				<td><%=book.getPrice()  %></td>
				<td><%=book.getNote()   %></td>
				<td><%=book.getStu_id()   %></td>

				<td><a href="http://localhost:8081/Library/modifybook.jsp?bookname=<%= bookname %>">�޸�</a></td>
				<td><a href="http://localhost:8081/Library/servlets/deletebook?bookname=<%= bookname %>">ɾ��</a></td>

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