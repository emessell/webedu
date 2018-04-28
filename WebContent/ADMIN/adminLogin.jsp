<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    if(session.getAttribute("chkAdmin") != null){
    	%>
<jsp:forward page="/ADMIN/admin.jsp"></jsp:forward>
<%
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/webedu/public/Origin.css" />
<title>admin 로그인 화면</title>
</head>
<body>
	<hr /> <br />
	<h1>Admin Login</h1>
	<br /> <hr />
	<form action="/webedu/ADMIN/adminLoginOK.jsp" method="post">
		<p>
			<br /><b>Email</b>
		</p>
		<input type="text" name="id" placeholder="Enter Email" /><br />
		<p>
			<b>Password</b>
		</p>
		<input type="password" name="passwd" placeholder="Enter Password" /><br />
		<input type="submit" value="로그인" class="btn" />

	</form>
</body>
</html>