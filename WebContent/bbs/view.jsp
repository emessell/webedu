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
    <c:set value="${view }" var="dto" />
      <h4 class="media-heading">${dto.getbTitle() }</h4>
	<p align="right" class="media-body">작성일 : ${dto.getbCdate() }</p>		
	<p align="right" class="media-body">작성자 : ${dto.getbName() }</p>
	<p align="center">${dto.getbContent() }</p>
    </div>
  </div>
  <hr >
  <div style="float:right">
  <nav aria-label="Page navigation example" >
  <ul class="pagination">
    <li class="page-item"><a class="page-link" href="#">Previous</a></li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">2</a></li>
    <li class="page-item"><a class="page-link" href="#">3</a></li>
    <li class="page-item"><a class="page-link" href="#">Next</a></li>
  </ul>
</nav>
</div>
</div>
</body>
</html>