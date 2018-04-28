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
<script src="/webedu/public/jquery/jquery-3.3.1.js"></script>
<script>
	$(document).ready(function(){
	//축약1) jQuery(function())
	//축약2) $(function())
	$("form").submit(function(){
		if($("#id").val()==""){
			alert("아이디를 입력해주세요!");
			$("#id").focus();
			return false;
		}else if($("#passwd").val()==""){
			alert("비밀번호를 입력해주세요!");
			$("#passwd").focus();
			return false;
		}
	});
	});
</script>
</head>
<link rel="stylesheet" type="text/css" href="/webedu/public/Origin.css" />
<body>
	<hr /> <br />
	<h1>Login</h1>
	<br /> <hr />
	<form action="/webedu/MEMBER/memLoginOK.jsp" method="post">
		<p>
		<br />	<b>Email</b>
		</p>
		<input type="text" name="id" id="id" placeholder="Enter Email" /><br />
		<p>
			<b>Password</b>
		</p>
		<input type="password" name="passwd" id="passwd"
			placeholder="Enter Password" /><br />
		<br /> <input type="submit" value="로그인" class="btn" /> <input
			type="button" value="회원가입" class="btn"
			onClick="javascript:window.location='/webedu/MEMBER/MemJoin.jsp'" />
	</form>
</body>
</html>