<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="cnt" class="com.edu.CountBean" scope="request"/>
<jsp:setProperty property="count" name="cnt"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>cnt의 getCount 호출 request</title>
</head>
<body>
${cnt.getCount()}
<jsp:getProperty property="count" name="cnt"></jsp:getProperty>
${cnt.count }
<% request.setAttribute("cnt", cnt); %>
<%-- <jsp:forward page="scope_result_2.jsp"/> --%>
<% response.sendRedirect("scope_result_1.jsp"); %>
<!-- <a href="scope_result_1.jsp">result_1</a> -->
</body>
</html>