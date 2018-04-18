<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.edu.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="mdto" class="com.edu.MemDTO" /> <!-- 인스턴스화 -->
<jsp:setProperty name="mdto" property="*"/> <!-- get -->
<%=mdto.getId() %>
<%=mdto.getPasswd() %>
<%=mdto.getName() %>
<%=mdto.getBirth() %>
<%=mdto.getPhone() %>
<%-- <%
	MemberDAO mdao = new MemberDAO();
	int n = mdao.insertMember(mdto);
%> --%>
</body>
</html>