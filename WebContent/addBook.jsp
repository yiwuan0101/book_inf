<%@page language="java" pageEncoding="gb2312"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>创建书本</title>
</head>
<body>
<table>
<form action="addbook"  " method="post">
		请您输入书号：<input name="booknum" type="text"><BR>
		请您输入书名：<input name="bookname" type="text"><BR>
		请您输入作者名：<input name="auther" type="text"><BR>
		请您输入价格：<input name="price" type="text"><BR>
		请您输入备注：<input name="note" type="text"><BR>
		<input type="submit" value="创建">	
	</form>

</table>
</body>
</html>