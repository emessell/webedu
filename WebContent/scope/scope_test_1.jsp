<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="cnt" class="com.edu.CountBean" scope="page"/>
<jsp:setProperty property="count" name="cnt"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>cnt의 getCount 호출 (page)</title>
</head>
<body>
${cnt.getCount()}
${cnt.count }
<a href="scope_result_1.jsp">result_1</a>
</body>
</html>