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
</head>
<body>
<div class="container">
	<br />
  <h2>게시판</h2>
  <hr />
  <div class="media">
    <div class="media-body">
    <h4 style="padding:15px;padding-left:30px">${view.getbTitle() }</h4>
	<p align="right" class="media-body">
	글 번호 : ${view.getbNum() } <br />
	작성일 : ${view.getbCdate() } <br />
	작성자 : ${view.getbName() }</p>
	<b>내용</b><br />
	<form action="modify.do" method="post">
	<textarea name="bContent" class="form-control" cols="30" rows="10">${view.getbContent() }</textarea>
	<input type="hidden" name="bNum" value="${view.getbNum() }"/>
    </div>
  </div>
  <hr >
  <div style="float:right">
  <nav aria-label="Page navigation example" >
  <ul class="pagination">
    <li class="page-item"><input type="submit" class="btn btn-primary" value="수정" /></li>
  </ul>
  </form>
</nav>
</div>
</div>
</body>
</html>