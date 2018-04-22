<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.edu.*"  %>
<%@ page import="java.util.ArrayList"%>
    <%
    String id = (String)session.getAttribute("id");
    String name = (String)session.getAttribute("name");
    String grade = (String)session.getAttribute("grade");
    %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="mdto" class="com.edu.MemDTO" /> <!-- 인스턴스화 -->
<jsp:setProperty name="mdto" property="*"/> <!-- get -->
<hr />
<h2>
<%=name %>님 환영합니다. <br />
당신의 등급은 <%=grade %>입니다.
</h2>
<hr />
<%=mdto.getId() %>
<%=mdto.getName() %>
<%=mdto.getBirth() %>
<%=mdto.getPhone() %>
<%=mdto.getCdate() %>
<%=mdto.getUdate() %>
<%
	/* MemberDAO mdao = MemberDAO.getInstance();
	ArrayList<Object> list = new ArrayList<Object>();
	list.add(mdao.getMemberAll());
	list.add(mdao.getMemberAll());
	list.add(mdao.getMemberAll());
	if(list.size()!=0){
		for(Object data:list){
			out.println(data);
		}
	} */
	MemberDAO mdao = MemberDAO.getInstance();
	mdao.getMemberAll();
	out.println(mdto.getId());
	out.println(mdto.getName());
	out.println(mdto.getBirth());
	out.println(mdto.getPhone());
	out.println(mdto.getCdate());
	out.println(mdto.getUdate());
%>


<form action="/webedu/ADMIN/adminLogoutOK.jsp" method="post">
<input type="submit" value="로그아웃"/>

</form>

</body>
</html>