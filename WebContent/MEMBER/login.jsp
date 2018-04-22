<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    if(session.getAttribute("chkMember") != null){
    	%>
    	<jsp:forward page="webedu/main.jsp"></jsp:forward>
    	<%
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 화면</title>
</head>
<style>
.btn {
  background-color: #4CAF50; color: white; padding: 16px 20px; 
  border: none; cursor: pointer;  width: 100px;  opacity: 0.9;}
 input[type=text], input[type=password] {
  width: 15%; padding: 15px; margin: 5px 0 22px 0; border: none; background: #f1f1f1;}
</style>
<body>
<hr />
<h1>Login</h1>
<hr />
<form action="/webedu/MEMBER/memLoginOK.jsp" method="post">
<p><b>Email</b></p>
<input type="text" name="id" placeholder="Enter Email"/><br />
<p><b>Password</b></p>
<input type="password" name="passwd" placeholder="Enter Password"/><br /><br />
<input type="submit" value="로그인" class="btn"/>
<input type="button" value="회원가입" class="btn"onClick="javascript:window.location='/webedu/MEMBER/MemJoin.jsp'"/>
</form>
</body>
</html>