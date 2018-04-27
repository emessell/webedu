<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	변수 선언
	<c:set var="num1" value="10"></c:set>
	<c:set var="num2" value="5"></c:set>
	<c:set var="result" value="${num1*num2 }"></c:set>
	<br /> 출력
	<c:out value="${result }"></c:out>
	${num1 }와 ${num2 }의 곱은 ${result }입니다.
	<br /> 예외처리
	<c:catch var="except">
		<%=10/0 %>
	</c:catch>
	<c:out value="${except }"></c:out>
	<br /> if 제어문
	<br />
	<c:if test="${10+10==100 }">
		참
</c:if>
	<c:if test="${10+10!=100 }">
		거짓
</c:if>
	<br />

	<c:forEach var="aa" begin="0" end="10" step="2">
		<font size=${aa }>안녕하세요</font>
		<br />
	</c:forEach>

</body>
</html>