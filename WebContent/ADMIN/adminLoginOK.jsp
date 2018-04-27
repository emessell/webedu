<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.edu.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	
	AdminDAO adao = AdminDAO.getInstance();
	AdminSqlResult sqlresult = adao.adminCheck(id,passwd);
	
	if(sqlresult == AdminSqlResult.ADM_LOGIN_NOT){
		//not member
%>
	<script>
		window.alert("아이디가 존재하지 않습니다.");
		window.history.go(-1); //window.history.back()
	</script>
	<%
	}else if(sqlresult == AdminSqlResult.ADM_LOGIN_PW_NOT){
		//uncorrect pw
%>
	<script>
		window.alert("비밀번호가 일치하지 않습니다.");
		window.history.go(-1);
	</script>
	<% 
	}else if(sqlresult == AdminSqlResult.ADM_LOGIN_SUCCESS){
		//login success
		AdminDTO adto = adao.getAdmin(id);
		session.setAttribute("id", adto.getId());
		session.setAttribute("name", adto.getName());
		session.setAttribute("grade", adto.getGrade());
		session.setAttribute("chkAdmin","OK");
		response.sendRedirect("/webedu/ADMIN/admin.jsp");
	}
%>
</body>
</html>