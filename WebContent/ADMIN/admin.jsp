<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String id = (String)session.getAttribute("id");
    String name = (String)session.getAttribute("name");
    String grade = (String)session.getAttribute("grade");
    %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr />
<h2>
<%=name %>님 환영합니다.
ID = [<%=id %>]
당신의 등급은 <%=grade %>입니다.
</h2>
<hr />
main screen
<form action="/webedu/ADMIN/adminLogoutOK.jsp" method="post">
<input type="submit" value="로그아웃"/>

</form>

</body>
</html>