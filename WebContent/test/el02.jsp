<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="member" class="com.edu.MemDTO" scope="page"></jsp:useBean>
<jsp:setProperty property="name" name="member" value="홍길동"></jsp:setProperty>
<jsp:setProperty property="id" name="member" value="abc@naver.com"></jsp:setProperty>
<jsp:setProperty property="passwd" name="member" value="1234"></jsp:setProperty>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 
	[EL Expression Language]
	:표현식(<%= %>) 또는 액션태그 (표준태그, 커스텀태그)를 대신해서 값을 표현하는 언어
 --%>
<p>이름: <jsp:getProperty property="name" name="member"></jsp:getProperty></p>
<p>아이디: <jsp:getProperty property="id" name="member"></jsp:getProperty></p>
<p>비밀번호: <jsp:getProperty property="passwd" name="member"></jsp:getProperty></p>
<hr></hr>
이름 : ${member.name } <br />
아이디 : ${member.id } <br />
비밀번호 : ${member.passwd } <br />
</body>
</html>