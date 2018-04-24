<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.edu.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
	%>
	<jsp:useBean id="mdto" class="com.edu.MemDTO" />
	<!-- 인스턴스화 -->
	<jsp:setProperty name="mdto" property="*" />
	<!-- get -->

	<c:set var="birth" value="${param.year}${param.month}${param.day}"></c:set>
	${mdto.setBirth(birth) } ${mdto.getId() } ${mdto.getPasswd() }
	${mdto.getName() } ${mdto.getBirth() } ${mdto.getPhone() }

	<%
		MemberDAO mdao = MemberDAO.getInstance();
		SqlResult sqlResult = mdao.checkId(mdto.getId());
	%>
	<c:choose>
	
		<c:when test="${sqlResult eq SqlResult.MEM_EXIST}">
			<script>
				alert("[ID], already exists.");
				window.history;
			</script>
		</c:when>
		
		<c:when
			test="${mdao.insertMember(mdto) eq SqlResult.MEM_JOIN_SUCCESS}">
			session.setAttribute("id", mdto.getId());
			<script>
				alert("Join Complete");
				document.location.href = "/webedu/MEMBER/login.jsp";
			</script>
		</c:when>
		<c:otherwise>
			<script>
				alert("Join Failed");
				document.location.href = "/webedu/MEMBER/login.jsp";
			</script>
		</c:otherwise>
		
	</c:choose>
</body>
</html>