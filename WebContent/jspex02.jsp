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
	int i=0;
	while(true){
		i++;
		out.println("하이"+i);
%>
	<br>
	<%
	if(i>10) break;
	}
%>
	<%!
	int i=100;
	String str="test";
	public int hap(int a, int b){
		return a+b;
	}
%>
	<%
	out.println("i="+i+"<br>");
	out.println("str="+str+"<br>");
	out.println("hap="+hap(2,10));
%>
	<hr>

	i=<%=i%><br> str=<%=str%><br> hap=<%=hap(2,0)%><br>
</body>
</html>