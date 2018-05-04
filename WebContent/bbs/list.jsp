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
<style>
.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
	transition: background-color .3s;
}
.pagination a:hover:not (.active ) {
	background-color: #ddd;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
	<br />
		<h2>게시판</h2>
		<p>쓰여진 글을 보여주는 목록입니다.</p>
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">#</th>
					<th scope="col">제목</th>
					<th scope="col">작성자</th>
					<th scope="col">작성일</th>
					<th scope="col">조회수</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${list }" var="dto">
				<tr>
					<th scope="row">${dto.bNum }</th>
					<td><c:forEach begin="1" end="${dto.bIndent }">[답]</c:forEach>
					<a href="view.do?bNum=${dto.bNum }">${dto.bTitle }</a></td>
					<td>${dto.bName }</td>
					<td>${dto.bCdate }</td>
					<td>${dto.bHit }</td>
				</tr>
				</c:forEach>
				</tbody>
				<tr></tr>
				<nav aria-label="Page navigation example" style="float:right">
					<ul class="pagination">
						<li class="page-item"><a class="page-link" href="/webedu/bbs/write_view.do">글쓰기</a></li>
					</ul>
				</nav>
			<div class="pagination">
				<a href="#">&laquo;</a>
				<a href="#">1</a>
				<a href="#">2</a>
				<a href="#">3</a>
				<a href="#">4</a>
				<a href="#">5</a>
				<a href="#">&raquo;</a>
			</div>
		</table>
	</div>
</body>
</html>