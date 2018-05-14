<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/webedu/public/bootstrap-4.1.0/dist/css/bootstrap.css">
<script src="/webedu/public/jquery/jquery-3.3.1.js"></script>
<script src="/webedu/public/bootstrap-4.1.0/dist/js/bootstrap.js"></script>
<link rel="stylesheet" href="/webedu/public/bootstrap-4.1.0/dist/css/bootstrap.css">
<style>
	#modifyDiv{
		width:500px; height:200px;
		background-color:gray;
		position:absolute;
		top:20%; left:30%;
		padding:20px;
		z-index:10;
	}
</style>
<script>
var bNum = 1562;

	$(function() {
		//댓글 수정양식 숨기기
		$("#modifyDiv").hide();
		
		//댓글 목록 가져오기
		replyList();

		// 댓글 목록 처리
		$("#reply").on("click", ".reList button", function() {
			var li = $(this).parent();
			console.log(li);
			var rNum = li.attr("data-rNum");
			var reContent = li.text();

			$(".title-dialog").html(rNum);
			$("#reContent").val(reContent);
			$("#modifyDiv").show("slow");
		});

		// 댓글 수정창 닫기
		$("#closeBtn").click(function() {
			$("#modifyDiv").hide();
		});

		//댓글 등록
		$("#replyBtn").click(function() {
			
			var writer = $("#writer").val();
			var replyContent = $("#replyContent").val();

			$.ajax({
				type : "POST",
				url : "/webedu/rbbs/write",
				dataType : "text",
				data : {
					bNum : bNum,
					rName : writer,
					rContent : replyContent
				},
				success : function(result) {
					alert("댓글 등록 성공");
					replyList();
				},
				error : function(e) {
					console.log("실패", error)
				}
			})
		});

		//댓글 수정
		$("#reModifyBtn").click(function(){
			alert("수정");
			var rNum = $(".title-dialog").html();
			var rContent = $("#reContent").val();
			$.ajax({
				type : 'POST',
				url : "/webedu/rbbs/modify",
				dataType : "text",
				data : {
					rNum : rNum,
					rContent : rContent
				},
				success : function(result) {
					replyList();
				},
				error : function(e) {
					console.log("실패" + e)
				}
			});
		});
		
		//댓글 삭제
		$("#reDelBtn").on("click",function(){
			alert("삭제");
			var rNum = $(".title-dialog").html();
			
			$.ajax({
				type : 'POST',
				url : "/webedu/rbbs/delete",
				dataType : "text",
				data : {
					rNum : rNum,
				},
				success : function(result) {
					replyList();
				},
				error : function(e) {
					console.log("실패" + e)
				}
			});
		});
	});

	//댓글 작성 클릭시 수행로직
	$("#replyBtn").click(function() {
		var writer = $("#writer").val();
		var replyContent = $("#replyContent").val();

		$.ajax({
			type : "POST",
			url : "/webedu/rbbs/write",
			dataType : "text",
			data : {
				bNum : bNum,
				rName : writer,
				rContent : replyContent
			},
			success : function(result) {
				alert("댓글등록성공");
				replyList();
			},
			error : function(e) {
				console.log("실패" + e)
			}
		});
	});
	
	//댓글 목록 가져오기
	function replyList() {
		var bNum = 1562;
		var str = "";
		$.ajax({
			type : "GET",
			url : "/webedu/rbbs/list?bNum=" + bNum,
			dataType : "json",
			success : function(data) {
				console.log(data);
				console.log(data.result);
				$.each(data.result, function(idx, rec) {
					console.log(rec);
					console.log(rec.RNUM);
					str += "<li data-rNum='" + rec.RNUM + "' class = 'reList'>"
						+ rec.BNUM + "|"
						+ rec.RCONTENT + "|"
						+ rec.RNAME + "|"
						+ "<button>수정</button>"
						+ "</li>";
				});
				$("#reply").html(str);
			},
			error : function(error) {
				console.log("실패" + error);
			}
		})
	}
</script>
<title>Insert title here</title>
</head>
<body>
<div id="modifyDiv">
<span class="title-dialog"></span>번 댓글
	<div>
		<textarea id="reContent" cols="30" rows="3"></textarea>
	</div>
	<div>
		<button id="reReplyBtn">댓글</button>
		<button id="reModifyBtn">수정</button>
		<button id="reDelBtn">삭제</button>
		<button id="closeBtn">닫기</button>
	</div>
</div> <br />
작성자: <input type="text" id="writer" /> <br />
댓글: <textarea name="" id="replyContent" cols="30" rows="3"></textarea><br />
<button id="replyBtn">댓글작성</button>
<br />
<h4>댓글리스트</h4>
<ul id="reply">

</ul>
</body>
</html>