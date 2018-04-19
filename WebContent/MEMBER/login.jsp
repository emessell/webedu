<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    if(session.getAttribute("chkMember") != null){
    	%>
    	<jsp:forward page="../main.jsp"></jsp:forward>
    	<%
    }
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 화면</title>
</head>
<body>
<hr />
<h2>로그인</h2>
<hr />
<form action="memLoginOK.jsp" method="post">
아이디 : <input type="text" name="id" /><br />
비밀번호 : <input type="password" name="passwd"/><br />
<input type="submit" value="로그인"/>
<input type="button" value="회원가입" onClick="javascript:window.location='MemJoin.jsp'"/>
</form>
</body>
</html>