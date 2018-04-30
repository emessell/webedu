<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/webedu/public/bootstrap-4.1.0/dist/css/bootstrap.css">
<script src="/public/jquery/jquery-3.3.1.js"></script>
<script src="/bootstrap-4.1.0/dist/js/bootstrap.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
	<h1 class="display-4"><br />글쓰기<br /></h1>
	<table class="table table-hover">
		<form action="write.do" method="post">
			<tr>
				<th scope="col">제목</th>
				<td scope="col"><input type="text" name="bTitle"
					class="form-control" placeholder="제목"></td>
			</tr>
			<tr>
				<th scope="col">작성자</th>
				<td scope="col"><input type="text" name="bName"
					class="form-control" placeholder="작성자"></td>
			</tr>
			<tr>
				<th scope="col">내용</th>
				<td scope="col"><textarea class="form-control" name="bContent"
						placeholder="내용"></textarea></td>
			</tr>
				<table style="float: right">
					<tr><td>
						<ul class="pagination">
							<li class="page-item"><input type="submit" class="page-link" value="글쓰기" /></li>
							<li class="page-item"><a href="list.do" role="button" class="page-link" aria-pressed="true">목록으로</a></li>
						</ul>
					</td></tr>
					</table>
			</form>
	</table>
	</div>
</body>
</html>