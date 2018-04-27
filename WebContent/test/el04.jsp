<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
%>

	아이디:
	<%=id %>
	<br /> 비밀번호:
	<%=passwd %>
	<br />
	<hr />
	아이디: ${param.id}
	<br /> 비밀번호: ${param.passwd }
	<br />
	<hr />
	아이디: ${param["id"]}
	<br /> 비밀번호: ${param["passwd"] }
	<br />
	<hr />
	applicationScope: ${applicationScope.appName}
	<br /> sessionScope: ${sessionScope.sessionName}
	<br /> pageScope: ${pageScope.pageName}
	<br /> requestScope: ${requestScope.reqName}
	<br />
	<hr />
	- context 초기화 파라미터
	<br />

	<!-- 
설정은 web.xml에서 <context-param>
	<param-name>key값</param-name>
	<param-value>value값</param-value>
</context-param> -->
	${initParam.key_1 }
	<br /> ${initParam.key_2 }
	<br /> ${initParam.key_3 }
	<br />
</body>
</html>