<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
    String id = (String)session.getAttribute("id");
    String name = (String)session.getAttribute("name");
    %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Join</title>
<!-- 자바 스크립트 파일 불러오기 -->
<!-- <script src="js/member.js"> </script> -->
<script src="/webedu/public/jquery/jquery-3.3.1.js"></script>
<script src="js/member2.js"> </script>
</head>
<style>
 input[type=text], input[type=password] {
  width: 15%; padding: 5px; margin: 5px 0 5px 0; border: none; background: #f1f1f1;}
.btn {
  background-color: #4CAF50; color: white; padding: 16px 20px; 
  border: none; cursor: pointer;  width: 100px;  opacity: 0.9;}
</style>
<body>

<hr/>
<h2>회원가입</h2>
<hr/>
	<form action="/webedu/MEMBER/memJoinOK.jsp" method="post" name="join_frm">
		<b>Email</b><br />
		<input type="text" name="id" placeholder="Email" id="id"/> <br />
		<b>Password</b><br />
		<input type="password" name="passwd" placeholder="Password" id="passwd"/> <br />
		<b>Password_Check</b><br />
		<input type="password" name="passwd_chk" placeholder="Password_Check" /> <br />
		<b>Name</b><br />
		<input type="text" name="name" placeholder="Name" id="name" /> <br />
		<b>Birth</b><br />
			<select name="year" id="">
			<option value="2016">2016</option>
			<option value="2017">2017</option>
			<option value="2018">2018</option>
			</select>년 
			<select name="month" id="">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
			<option value="7">7</option>
			<option value="8">8</option>
			<option value="9">9</option>
			<option value="10">10</option>
			<option value="11">11</option>
			<option value="12">12</option>
			</select>월 
			<select name="day" id="">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
			<option value="7">7</option>
			<option value="8">8</option>
			<option value="9">9</option>
			<option value="10">10</option>
			</select>일 <br />
		<b>Phone</b><br />
		<input type="text" name="phone" placeholder="Phone" id="phone"/> <br />
			<input type="button" value="회원가입" id="memJoin" onClick="mem_check()" class="btn"/>
			<input type="reset" value="Reset" class="btn"/>

			
	</form>
	
</body>
</html>