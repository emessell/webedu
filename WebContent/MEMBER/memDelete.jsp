<%@ page import="com.edu.MemberDAO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<%
	String id = (String)session.getAttribute("id");

	MemberDAO mdao = MemberDAO.getInstance();
	int n = mdao.deleteMember(id);
	
	if(n==1){ //modify complete
		session.invalidate();
%>
		<script>
		alert("회원 탈퇴가 되었습니다.");
		document.location.href = "/webedu/MEMBER/login.jsp"
		</script>
<%		
	}else{ //modify fail
%>		
		<script>
		alert("회원탈퇴 실패");
		document.history.back();
		</script>
<%	
	}
	
%>