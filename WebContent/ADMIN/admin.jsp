<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.edu.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.sql.*"%>
<%
    if(session.getAttribute("chkMember") != null){
    	%>
<jsp:forward page="/admin.jsp"></jsp:forward>
<%
    }
    %>
<%
	String id = (String) session.getAttribute("id");
	String name = (String) session.getAttribute("name");
	String grade = (String) session.getAttribute("grade");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/webedu/public/Origin.css" />
<title>Insert title here</title>
</head>
<body>
	<hr />
	<h2 style="margin:50px">
		<%=name%>님 환영합니다. <br />
		당신의 등급은 <%=grade%>등급입니다.
	</h2>
	<hr /><br />
	
		<input type="button" value="로그아웃" class="btn" onClick="javascript:window.location='/webedu/ADMIN/adminLogoutOK.jsp'"/>
		<input type="button" value="회원정보" class="btn" onClick="javascript:window.location='/webedu/ADMIN/memList.jsp'" />
	
	
</body>
</html>