<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Join</title>
<!-- 자바 스크립트 파일 불러오기 -->
<script src="js/member.js"> </script>
</head>
<body>
<center>
<hr width=500 size=1/>
<h2>회원가입</h2>
<hr width=500 size=1/>
	<form action="" method="post" name="join_frm">
		아이디: <input type="text" name="id" /> <br />
		비밀번호: <input type="password" name="passwd" /> <br />
		비밀번호 확인: <input type="password" name="passwd_chk" /> <br />
		생년월일: 
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
		휴대폰: <input type="text" name="phone"/> <br />
			<input type="button" value="회원가입" onClick="js/member.js()"/> <input type="reset" value="취소"/>
			
	</form>
	</center>
</body>
</html>