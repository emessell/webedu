<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/webedu/public/bootstrap-4.1.0/dist/css/bootstrap.css">
<script src="/public/jquery/jquery-3.3.1.js"></script>
<script src="/bootstrap-4.1.0/dist/js/bootstrap.js"></script>
<title>view</title>
<script>
	$(function(){ //html 모두 로딩 뒤 실행
		$("#mylink1").css({"display":""});
		$("#mylink2").css({"display":"none"});
		
		//편집모드 변환
		$("#mybtn1").click(function(){
			var status = $("#mylink2").css("display");
			if(status == "none"){
				$("#mylink1").css({"display":"none"});
				$("#mylink2").css({"display":""});
				/* $("#myinput1,#myinput2").removeAttr("readonly"); */
				$("[id^='myinput']").removeAttr("readonly");
			}
		});
		//읽기모드 변환
				$("#mybtn2").click(function(){
					if(status == "none"){
						$("#mylink1").css({"display":""});
						$("#mylink2").css({"display":"none"});
						/* $("#myinput1,#myinput2").Attr("readonly","readonly"); */
						$("[id^='myinput']").Attr("readonly","readonly");
					}
				});
	});
</script>
</head>
<body>
<div class="container">
	<br />
  <h2>글 수정</h2>
  <hr />
  <div class="media">
    <div class="media-body">
    <form action="modify.do?bNum=${view.getbNum() }" method="post">
    <h4 style="padding:15px;padding-left:30px">제목 <input name="bTitle" class="form-control" type="text" id="myinput1" value="${view.getbTitle() }"/></h4>
	<p align="right" class="media-body">
	글 번호 : ${view.getbNum() } <br />
	작성일 : ${view.getbCdate() } <br />
	작성자 : ${view.getbName() }</p>
	<b>내용</b><br />
	<textarea name="bContent" class="form-control" cols="30" rows="10" id="myinput2">${view.getbContent() }</textarea>
    </div>
  </div>
  <hr >
  <div style="float:right">
  <nav aria-label="Page navigation example" >
  <ul class="pagination" id="mylink1">
    <li class="page-item"><input type="submit" class="page-link" role="button" id="mybtn1" aria-pressed="true" value="수정" /></li>
    <li class="page-item"><input type="submit" class="page-link" role="button" aria-pressed="true" value="수정" /></li>
    <li class="page-item"><input type="submit" class="page-link" role="button" aria-pressed="true" value="수정" /></li>
  </ul>
  <ul class="pagination" id="mylink2">
    <li class="page-item"><input type="submit" class="page-link" role="button" id="mybtn2" aria-pressed="true" value="수정" /></li>
    <li class="page-item"><input type="submit" class="page-link" role="button" aria-pressed="true" value="수정" /></li>
  </ul>
  </form>
</nav>
</div>
</div>
</body>
</html>