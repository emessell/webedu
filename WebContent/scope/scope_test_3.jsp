<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="cnt" class="com.edu.CountBean" scope="session" />
<jsp:setProperty property="count" name="cnt" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>cnt의 getCount호출(session)</title>
</head>
<body>
	<jsp:getProperty property="count" name="cnt" />
	${cnt.count }
	<hr />
	<b>세션id</b>
	<br /> 세션 유효 시간 :
	<%=session.getMaxInactiveInterval() %>
	세션 ID:
	<%=session.getId() %>
	<br /> 새로운 세션 여부 :
	<%=session.isNew() ? session.getId(): "기존 유지" %>
	<br />
	<%-- 
	session.getId(): 자동 생성된 세션 아이디를 얻어올 때 사용
	session.isNew(): 세션이 최초로 생성되었는지 여부를 알고자 할 때 사용
	session.getMaxInactiveInterval(): 세션의 유효시간을 얻어올 때 사용
	 --%>
	<%-- 	<jsp:forward page ="scope_result_3.jsp" /> --%>
	<%-- 	<% response.sendRedirect("scope_result_3.jsp"); %> --%>
	<a href="scope_result_3.jsp">result_3</a>
</body>
</html>