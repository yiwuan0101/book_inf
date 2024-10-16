<%@ page language="java" pageEncoding="gb2312"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>½èÊéµÇ¼Ç</title>
</head>
<body>
<table>
<% String bookname= (String )request.getParameter("bookname"); 
out.println(bookname);
		
       //String studentName= (String )request.getAttribute("studentname"); 
%>
<form action="servlets/borrowbook"  " method="post">
		ÊéºÅ£º<input name="booknum" type="text" ><BR>
		×÷Õß£º<input name="auther" type="text"><BR>
		¼Û¸ñ£º<input name="price" type="text"><BR>
		±¸×¢£º<input name="note" type="text"><BR>
		½èÊéÈË£º<input name="stu_id" type="text"><BR>
		ÊéÃû£º<input name="bookname" type="text" value="<%=bookname %>" readonly><BR>
		<input type="submit" value="µÇ¼Ç">	
	</form>
</table>
</body>
</html>