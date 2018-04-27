<%@ page import="com.edu.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="mdto" class="com.edu.MemDTO" />
<jsp:setProperty name="mdto" property="*" />

<%
	String year = request.getParameter("year");
	String month = request.getParameter("month");
	String day = request.getParameter("day");
	mdto.setBirth(year+month+day);
%>

<%
	String id = (String)session.getAttribute("id");

	MemberDAO mdao = MemberDAO.getInstance();
	mdto.setId(id);
	int n = mdao.updateMember(mdto);
	
	if(n==1){ //modify complete
		session.setAttribute("name", mdto.getName());
%>
<script>
		alert("회원정보가 수정되었습니다.");
		document.location.href = "/webedu/main.jsp"
		</script>
<%		
	}else{ //modify fail
%>
<script>
		alert("회원정보 수정 실패");
		document.history.back();
		</script>
<%	
	}
	
%>