<%@ page language="java" pageEncoding="gb2312"%>
<%@page import="beans.studentUtil"%>
<jsp:useBean id="studentUtil" class="beans.studentUtil" scope="page"></jsp:useBean>
<jsp:useBean id="student" class="beans.students" scope="page"></jsp:useBean>
<jsp:setProperty name="student" property="stu_id" param="stu_id"/>
<jsp:setProperty name="student" property="stu_pass" param="stu_pass"/>
<%
	if (studentUtil.findStudent(student)){
%>
		<jsp:forward page="check"></jsp:forward>
<%
	} else {
%>
		<jsp:forward page="error.jsp"></jsp:forward>
<%	
	}
%>