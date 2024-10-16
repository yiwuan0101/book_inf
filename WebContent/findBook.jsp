<%@ page import="beans.books"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" pageEncoding="gb2312"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>²éÑ¯Êé±¾</title>
</head>
<body>
<form action="servlets/findbook"  " method="post">
		ÊéÃû£º<input name="bookname" type="text"><BR>
	
		<input type="submit" value="²éÑ¯">	
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
				<td>ÊéºÅ</td>
				<td>ÊéÃû</td>
				<td>×÷Õß</td>
				<td>¼Û¸ñ</td>
				<td>±¸×¢</td>
				<td>½èÊéÈË</td>
				<td>ÐÞ¸Ä</td>
				<td>É¾³ý</td>
				
			</tr>
			<%
				out.print(books.size());
			%>
			<%
				for (int i = 0; i < books.size(); i++) {
						books book=(books)books.get(i);
						System.out.println(book);
						System.out.println("´íÎóÒ»");
						String bookname = book.getBookname();
			%>
			<tr>
				<td><%=book.getBooknum()   %></td>
				<td><%=book.getBookname() %></td>
				<td><%=book.getAuther() %></td>
				<td><%=book.getPrice()  %></td>
				<td><%=book.getNote()   %></td>
				<td><%=book.getStu_id()   %></td>

				<td><a href="http://localhost:8081/Library/modifybook.jsp?bookname=<%= bookname %>">ÐÞ¸Ä</a></td>
				<td><a href="http://localhost:8081/Library/servlets/deletebook?bookname=<%= bookname %>">É¾³ý</a></td>

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