<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/webedu/public/bootstrap-4.1.0/dist/css/bootstrap.css">
<script src="/webedu/public/jquery/jquery-3.3.1.js"></script>
<script src="/webedu/public/bootstrap-4.1.0/dist/js/bootstrap.js"></script>
<script>
$(function() {
	$("input[value='검색']").click(function() {
		self.location = "list.do?reqPage=1"
		+"&option="+$("[name=option]").val()+"&search="+$("[name=search]").val();
	});	
});
</script>
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
		</table>
		<table width="100%">
			<tr>
				<td width="95%">
					<ul id="pageing"
						class="pagination pagination-sm justify-content-center">
						<c:if test="${page.prev }">
							<li class="page-item"><a class="page-link"
								href="list.do?page.finalEndPage">처음</a></li>
							<li class="page-item"><a class="page-link"
								href="list.do?${page.getmakeURL(page.startPage-1) }" aria-label="Previous">
									<span aria-hidden="true">&laquo;</span> <span class="sr-only">Previous</span>
							</a></li>
						</c:if>

						<c:forEach begin="${page.startPage }" end="${page.endPage }"
							var="PAGE">
							<c:if test="${page.recordCriteria.reqPage == PAGE }">
								<li class="page-item active"><a class="page-link" href="#">${PAGE }</a></li>
							</c:if>
							<c:if test="${page.recordCriteria.reqPage != PAGE }">
								<li class="page-item"><a class="page-link"
									href="list.do?${page.getmakeURL(PAGE) }">${PAGE }</a></li>
							</c:if>
						</c:forEach>

						<c:if test="${page.next }">
							<li class="page-item"><a class="page-link"
								href="list.do?${page.getmakeURL(page.endPage+1) }" aria-label="Next">
									<span aria-hidden="true">&raquo;</span> <span class="sr-only">Next</span>
							</a></li>
							<li class="page-item"><a class="page-link"
								href="list.do?${page.getmakeURL(page.finalEndPage) }">마지막</a></li>
						</c:if>
					</ul>
				</td>
			</tr>
			<tr>
				<td>
					<select name="option" class="form-control-sm">
						<option <c:out value="${option == '제목 내용' ? 'selected' : ''}" />>제목+내용</option>
						<option <c:out value="${option == '작성자' ? 'selected' : ''}" />>작성자</option>
						<option <c:out value="${option == '제목' ? 'selected' : ''}" />>제목</option>
						<option <c:out value="${option == '내용' ? 'selected' : ''}" />>내용</option>
					</select>
				<input type="text" name="search" id="" class="form-control-sm" value="${search }"/>
				<input type="button" class="btn-sm btn-secondary" id="searchBtn" value="검색" />
				</td>
			</tr>
			</table>
	</div>
</body>
</html>