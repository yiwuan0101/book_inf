<%@ page language="java" pageEncoding="gb2312"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>�޸��鱾</title>
</head>
<body>
<table>
<% String bookname= (String )request.getParameter("bookname"); 
out.println(bookname);
		
       //String studentName= (String )request.getAttribute("studentname"); 
%>
<form action="servlets/modifybook"  " method="post">
		��ţ�<input name="booknum" type="text" ><BR>
		���ߣ�<input name="auther" type="text"><BR>
		�۸�<input name="price" type="text"><BR>
		��ע��<input name="note" type="text"><BR>
		������<input name="bookname" type="text" value="<%=bookname %>" readonly><BR>
		<input type="submit" value="�޸��鱾">	
	</form>
</table>
</body>
</html>