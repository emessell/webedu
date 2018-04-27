<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.edu.*"%>
<%
   String id = (String)session.getAttribute("id");
   MemberDAO mdao = MemberDAO.getInstance();
   MemDTO mdto = mdao.getMember(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<!-- 자바 스크립트 파일 불러오기 -->
<script src="js/member.js"> </script>
<body>
	<hr />
	<h2>회원가입</h2>
	<hr />
	<form action="/webedu/MEMBER/memModifyOK.jsp" method="post"
		name="modify_frm">
		아이디: <input type="text" name="id" value="<%=mdto.getId() %>"
			disabled="disabled" /> <br /> 비밀번호: <input type="password"
			name="passwd" /> <br /> 비밀번호 확인: <input type="password"
			name="passwd_chk" /> <br /> 이름: <input type="text" name="name"
			value="<%=mdto.getName()%>" /> <br /> 생년월일: <select name="year"
			id="">
			<option value="2016">2016</option>
			<option value="2017">2017</option>
			<option value="2018">2018</option>
		</select>년 <select name="month" id="">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
			<option value="7">7</option>
			<option value="8">8</option>
			<option value="9">9</option>
			<option value="10">10</option>
			<option value="11">11</option>
			<option value="12">12</option>
		</select>월 <select name="day" id="">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
			<option value="7">7</option>
			<option value="8">8</option>
			<option value="9">9</option>
			<option value="10">10</option>
		</select>일 <br /> 휴대폰: <input type="text" name="phone"
			value="<%=mdto.getPhone()%>" /> <br /> <input type="button"
			value="수정" onClick="updateInfo()" /> <input type="reset" value="취소" />
		<input type="button" value="회원탈퇴"
			onClick="javascript:location.href='memDelete.jsp'" />


	</form>
</body>
</html>