<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome!</title>
</head>
<body>
	<!-- 메인 상단부 -->
	<jsp:include page="main_top.jsp" />
	<!-- 메인 컨텐츠 -->
	<%-- <jsp:include page="main_left.jsp"/> --%>
	<iframe src="/webedu/MEMBER/login.jsp" name="iframe_content"
		width=100%; height=70%; style="border: none;"></iframe>
	<!-- 메인 하단부 -->
	<jsp:include page="main_bottom.jsp" />
</body>
</html>