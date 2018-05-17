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
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
	#modifyDiv{
		width:500px; height:200px;
		background-color:gray;
		top:20%; left:30%;
		padding:20px;
		z-index:10;
	}
	
	 #pageNumList>li{ /* 이민섭 바보멍청이해삼말미잘 열심히 하렴^^*너도 할 수 있다(everything)♥ */
		list-style:none;
		display:inline;
	} 
	
	input[type=text], select, textarea {
    width: 100%;
    padding: 12px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
    margin-top: 6px;
    margin-bottom: 16px;
    resize: vertical;
	}
	.page-link{
	float: right;
	}
	


</style>
<script>
var bNum = ${view.bNum};
var reReqPage = 1;
	$(function() {
		//댓글 수정양식 숨기기
		$("#modifyDiv").hide();
		$("#remodifyDiv").hide();
		
		//댓글 목록 가져오기
		//replyList();
		
		replyList(reReqPage);
		
		
		//댓글창 보이기, 댓글 목록 처리
		$("#reply").on("click", ".reList button#b1", function() {
			var li = $(this).parent();
			var rNum = li.attr("data-rNum");
			var reContent = li.text();

			$(".title-dialog").html(rNum);
			$("#reContent").val(reContent);
			$("#modifyDiv").show("slow");
			
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
						replyList(reReqPage);
					},
					error : function(e) {
						console.log("실패" + e)
					}
				});
			});
		});

		//대댓글창 보이기
		$("#b2").on("click", ".reList button", function() {
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
					replyList(reReqPage);
				},
				error : function(e) {
					console.log("실패", error)
				}
			})
		});

		//댓글 수정
		$("#reModifyBtn").click(function() {
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
					alert("수정 완료");
					replyList(reReqPage);
				},
				error : function(e) {
					console.log("실패" + e)
				}
			});
		});

		//댓글 삭제
		$("#reDelBtn").on("click", function() {
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
					replyList(reReqPage);
				},
				error : function(e) {
					console.log("실패" + e)
				}
			});
		});

	 	//페이지 번호 클릭시 이벤트 처리
		$("#pageNumList").on("click","a ",function(evt){
			evt.preventDefault();
			reqPage = $(this).attr("href");
			replyList(reqPage);
		});
	 	
		//좋아요
		$("#reply").on("click","#goodBtn",function() {
			var li = $(this).parent().parent();
			var Rnum = li.attr("data-rNum");
			$.ajax({
				type : "POST",
				url : "/webedu/rbbs/good",
				dataType : "text",
				data : {
					rNum : Rnum,
					goodOrBad : "good"
				},
				success : function(result) {
					replyList(reReqPage);
				},
				error : function(e) {
					console.log("실패" + e)
				}
			});
		});
		
		//나빠요
		$("#reply").on("click","#badBtn",function() {
			var li = $(this).parent().parent();
			var Rnum = li.attr("data-rNum");
			$.ajax({
				type : "POST",
				url : "/webedu/rbbs/bad",
				dataType : "text",
				data : {
					rNum : Rnum,
					goodOrBad : "bad"
				},
				success : function(result) {
					replyList(reReqPage);
				},
				error : function(e) {
					console.log("실패" + e)
				}
			});
		});
		S
	});

	//요청 댓글 목록 가져오기
		function replyList(reReqPage) {
			var str = "";
			$.ajax({
				type : "GET",
				url : "/webedu/rbbs/list?bNum=" + bNum + "&reReqPage=" + reReqPage,
				dataType : "json",
				success : function(data) {
					console.log(data);
					console.log(data.result);
					console.log(data.pageCriteria);
					$.each(data.result, function(idx, rec) {
						console.log(rec);
						console.log(rec.RNUM);
						str += "<span><li data-rNum='" + rec.RNUM + "' class = 'reList'></span>"
						/* + rec.BNUM + "|" */
						+ "<img src=\"/webedu/img/img_avatar1.png\" alt=\"John Doe\" class=\"mr-3 mt-3 rounded-circle\" style=\"width:60px;\">"
						+ "<div class=\"media-body\"><h4>" + rec.RNAME + "  "
						+ "<small><i>"+rec.RCDATE + "</i></small></h4>"
						+ "<p>"+rec.RCONTENT + "</p>"
						+ "<button id=\"goodBtn\" style=\"background-color:white;color:#007BFF;margin-right:5px; \"; class=\"btn btn-primary\">"
						+ "<i class=\"fa fa-thumbs-o-up\"></i>"+" "+rec.RGOOD+"</button>"
						+ "<button id=\"badBtn\" style=\"background-color:white;color:#007BFF;margin-right:5px;\"; class=\"btn btn-primary\">"
						+ "<i class=\"fa fa-thumbs-o-down\"></i>"+" "+rec.RBAD+"</button>"
						+ "<button id='b1' class=\"btn btn-primary\" style=\"background-color:#007BFF;color:white;float:right;border:0 \">수정</button>"
						+ "<button id='b2' class=\"btn btn-primary\" style=\"background-color:#007BFF;color:white;float:right;border:0 \">댓글</button>"
						+ "</div></li>";
					});
					$("#reply").html(str);
					//페이지 리스트 호출
					showPageList(data.pageCriteria);
				},
				error : function(error) {
					console.log("실패" + error);
				}
			});
		}
	/* 
	//전체 댓글 가져오기
		function replyListAll() {
			var bNum = 1584;
			var str = "";
			$.ajax({
				type : "GET",
				url : "/webedu/rbbs/list?bNum=" + bNum,
				dataType : "json",
				success : function(data) {
					console.log(data);
					console.log(data.result);
					console.log(data.pageCriteria);
					$.each(data.result, function(idx, rec) {
						console.log(rec);
						console.log(rec.RNUM);
						str += "<li data-rNum='" + rec.RNUM + "' class = 'reList'>"
							+ rec.BNUM + "|"
							+ rec.RCONTENT + "|"
							+ rec.RNAME + "|"
							+ rec.RGOOD + "|"
							+ rec.RBAD + "|"
							+ "<button>수정</button>"
							+ "</li>";
					});
					$("#reply").html(str);
					
					//페이지 리스트 호출
					showPageList(data.pageCriteria);
				},
				error : function(error) {
					console.log("실패" + error);
				}
			})
	} */

	// 페이지 리스트
	function showPageList(pageCriteria) {
 		console.log(pageCriteria);
		var str = "";
		// 이전표시
		if (pageCriteria.prev) {
		// 처음
		str += "<li><a class=\"page-link\" href='1'>◀</a></li>";
		// 이전
		str += "<li><a class=\"page-link\" href='" + (pageCriteria.startPage - 1) + "'>" + "◁</a></li>";
		}
		
		for (var i = pageCriteria.startPage, end = pageCriteria.endPage; i <= end; i++) {
			str += "<li><a class=\"page-link\" href='" + i + "'>" + i + "</a></li>";
		}
		// 다음표시
		if (pageCriteria.next) {
		// 다음
		str += "<li><a class=\"page-link\" href='" + (pageCriteria.endPage + 1) + "'>" + "▷</a></li>";
		// 마지막
		str += "<li><a class=\"page-link\" href='" + (pageCriteria.finalEndPage) + "'>" + "▶</a></li>";
		}
		
		$("#pageNumList").html(str); 
	}

	
</script>
<title>Insert title here</title>
</head>
<body>
<p></p>
 <br /><hr />
<input type="text" id="writer" style="width:100px;height:27px;margin-top:5%" placeholder="작성자"/> <br />
<p><textarea  id="replyContent" style="width:90%;height:151px" placeholder="댓글 내용"></textarea>
<button id="replyBtn" class="page-link" style="margin-top:11%">댓글작성</button></p>
<br />
<div class="container" id="modifyDiv">
<span class="title-dialog"></span>번 댓글
	<div class="container">
		<textarea id="reContent" cols="30" rows="3"></textarea>
	</div>
	<div class="container">
		<button id="reReplyBtn">댓글</button>
		<button id="reModifyBtn">수정</button>
		<button id="reDelBtn">삭제</button>
		<button id="closeBtn">닫기</button>
	</div>
</div>
<div id="reDiv" class="w3-container">
		<h2>댓글리스트</h2>
	<p>
		<ul id="reply" class="w3-ul w3-hoverable">
		</ul>
	</p>
		<ul id="pageNumList" class="pagination" style="float:right">
		</ul>
</div>
</body>
</html>