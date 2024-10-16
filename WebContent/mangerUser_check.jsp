<%@ page language="java" pageEncoding="gb2312"%>
<%@page import="beans.adminUtil"%>
<jsp:useBean id="adminUtil" class="beans.adminUtil" scope="page"></jsp:useBean>
<jsp:useBean id="admin" class="beans.admin" scope="page"></jsp:useBean>
<jsp:setProperty name="admin" property="username" param="username"/>
<jsp:setProperty name="admin" property="password" param="password"/>
<%
	if (adminUtil.findAdmin(admin)){
%>
		<jsp:forward page="mangerUser"></jsp:forward>
<%
	} else {
%>
		<jsp:forward page="error.jsp"></jsp:forward>
<%	
	}
%>