<%@ page import="beans.books"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" pageEncoding="gb2312"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>查询书本</title>
</head>
<body>
<form action="servlets/student_findbook"  " method="post">
		书名：<input name="bookname" type="text"><BR>
	
		<input type="submit" value="查询">	
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
				<td>书号</td>
				<td>书名</td>
				<td>作者</td>
				<td>价格</td>
				<td>备注</td>
				<td>借书人</td>
				<td>借书</td>
				
			</tr>
			<%
				out.print(books.size());
			%>
			<%
				for (int i = 0; i < books.size(); i++) {
						books book=(books)books.get(i);
						System.out.println(book);
						String bookname = book.getBookname();
			%>
			<tr>
				<td><%=book.getBooknum()   %></td>
				<td><%=book.getBookname() %></td>
				<td><%=book.getAuther() %></td>
				<td><%=book.getPrice()  %></td>
				<td><%=book.getNote()   %></td>
				<td><%=book.getStu_id()   %></td>

				<td><a href="http://localhost:8081/Library/borrowbook.jsp?bookname=<%= bookname %>">借书</a></td>

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