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
<title>view</title>
</head>
<body>
<div class="container" style="margin-top:4%">
	<br />
  <h2><small>#${view.getbNum() }</small>_         ${view.getbTitle() }</h2>
  
    <form action="delete.do" method="post">
  <div class="media">
    <div class="media-body">
    <%-- <h4 style="padding:15px;padding-left:30px">${view.getbTitle() }</h4> --%>
	<p align="right" class="media-body">
	글 번호 : ${view.getbNum() }<br />
	작성일 : ${view.getbCdate() }<br />
	작성자 : ${view.getbName() }</p>
	<!-- <hr style="width:95%"/> -->
	<p style="margin:100px;"><pre><center> ${view.getbContent() } </center></pre></p>
	<input type="hidden" name="bNum" value="${view.getbNum() }"/>
    </div>
  </div>
  <div style="float:right;">
  <nav aria-label="Page navigation example" >
  <ul class="pagination">
    <li class="page-item"><a class="page-link" href="/webedu/bbs/list.do">목록으로</a></li>
    <li class="page-item"><a class="page-link" href="/webedu/bbs/modify_form.do?bNum=${view.getbNum() }">수정</a></li>
    <li class="page-item"><a href="replyView.do?bNum=${view.bNum}" class="page-link" id="mybtn1" role="button" aria-pressed="true">답글</a></li>
    <li class="page-item"><input type="submit" class="page-link" value="삭제" /></li>
    <li class="page-item"><a class="page-link" href="view.do?bNum=${view.getpNum() }">Previous</a></li>
    <li class="page-item"><a class="page-link" href="view.do?bNum=${view.getnNum() }">Next</a></li>
  </ul>
</nav>
</div>
</form>
<jsp:include page="reply.jsp" />
</div>

</body>
</html>