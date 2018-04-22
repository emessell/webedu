<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Document</title>
</head>
<style>
  *{margin: 0; text-align: center;}
  html, body{margin: 0px; padding: 0px; height:100%;}
  #header1{background-color: white; height: 10%; font-size: 40px;}
  
  #section1{background-color: rgb(108, 45, 75); width:70%; height:30%; float:left;}
  #section2{background-color: rgb(60, 26, 185); width:70%; height:40%; float:left;}
  #article{background-color: rgb(20, 224, 52); width:30%; height:20%; float:right;}
  #aside{background-color: rgb(45, 71, 167); width:30%; height:50%; float:right;}
  #header2{background-color: rgb(123, 176, 40); height:10%; }
  #footer1{background-color: rgb(176, 150, 40); height:10%; }
  #footer2 {position: fixed; height:12.3%; width: 100%; background-color: #f2f2f2; color: black; font-size:25px;text-align: center;}
  #p1{height: 65%;}
  .topnav {overflow: hidden;background-color: #333;}
  .topnav a {float: left;color: #f2f2f2;text-align: center; padding: 1.2% 20px ; text-decoration: none;font-size: 17px;
  -webkit-transition-duration: 0.3s; transition-duration: 0.3s;}
  .topnav a:hover {background-color: #ddd;color: black;}
  .topnav a.active {background-color: #4CAF50;color: white;}
</style>
<body>
  <header id="header1">Welcome to our Homepage</header>
  <nav id="nav" class="topnav">
  		<a class="active" href="/webedu/index.jsp">홈</a>
  		<a href="/webedu/MEMBER/login.jsp" target="iframe_content">로그인</a>
  		<a href="/webedu/MEMBER/MemJoin.jsp" target="iframe_content">회원가입</a>
  		<a href="/webedu/ADMIN/adminLogin.jsp" target="iframe_content">Admin 로그인</a>
  		<a href="/webedu/MEMBER/MemJoin.jsp" target="iframe_content">회원가입</a>
  </nav>
</body>
</html>