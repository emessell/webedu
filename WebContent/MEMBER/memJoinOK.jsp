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
<%request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="mdto" class="com.edu.MemDTO" /> <!-- 인스턴스화 -->
<jsp:setProperty name="mdto" property="*"/> <!-- get -->

<%
	String year = request.getParameter("year");
	String month = request.getParameter("month");
	String day = request.getParameter("day");
	mdto.setBirth(year+month+day);
%>

<%=mdto.getId() %>
<%=mdto.getPasswd() %>
<%=mdto.getName() %>
<%=mdto.getBirth() %>
<%=mdto.getPhone() %>
<%
	MemberDAO mdao = new MemberDAO();
	SqlResult sqlResult = mdao.checkId(mdto.getId());
	if(sqlResult == SqlResult.MEM_EXIST){
%>
	<script>
		alert("[ID], already exists.");
		window.history;
	</script>
<%
	}else{
		if(mdao.insertMember(mdto) == SqlResult.MEM_JOIN_SUCCESS){
			session.setAttribute("id", mdto.getId());
%>
		<script>
			alert("Join Complete");
			document.location.href="login.jsp";
		</script>
<%
		}else{
%>
		<script>
			alert("Join Failed");
			document.location.href="login.jsp";
		</script>
<%		
		}
	}
%>
</body>
</html>