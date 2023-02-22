<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/view/header.jsp" />
	<div>
		제목:
		<input type="text" name="btitle" value="${btitle }" disabled style="border-style: none; background-color: #ffffff">
		작성자:
		<input type="text" name="buser" value="${buser }" disabled style="border-style: none; background-color: #ffffff">
		등록일자:
		<input type="text" name="submitdate" value="${submitdate }" disabled style="border-style: none; background-color: #ffffff"">
		조회수:
		<input type="text" name="readcount" value="${readcount }" disabled style="border-style: none; background-color: #ffffff"">
		<br><br>
		<textarea rows="15" cols="72" name="bcontent" disabled style="border-style: none; background-color: #ffffff">${bcontent }</textarea>
		<br>
		<c:if test="${lgnss.id eq buser }">
			<button type="button" class="btn update">게시글수정</button>
			<button type="button" class="btn delete">게시글삭제</button>
		</c:if>
		<button type="button" class="btn main">메인화면으로</button>
	</div>
	<hr>
	댓글
	<hr>
	<div>
	
		<table style="text-align: center">
			<c:forEach items="${commentlist }" var="vo" varStatus="s">
				<tr>
					<td hidden="hidden" id="bid">${vo.boardId }</td>
					<td hidden="hidden" id="cid">${vo.commentId }</td>
					<td>${vo.userName }&nbsp;&nbsp;</td>
					<td>${vo.commentContent }&nbsp;&nbsp;</td>
					<td>${vo.submitDate }&nbsp;</td>
					<c:if test="${lgnss.id eq vo.userName }">
						<td><a href="<%=request.getContextPath() %>/deletecomment?board=${vo.boardId}&&comment=${vo.commentId}">게시글 삭제</a></td>
					</c:if>
				</tr>
				<c:if test=""></c:if>
			</c:forEach>
		</table>
		<c:if test="${not empty lgnss }">
			<form action="<%=request.getContextPath() %>/insertcomment?id=${boardid}" method="post">
				<input type="text" name="uid" value="${lgnss.id }" hidden>
				<textarea rows="4" cols="40" name="insertcomment"></textarea>
				<button type="submit">댓글 등록</button>
			</form>
		</c:if>
	</div>
	
	<script>
		$(".btn.deleteComment").on("click", handlerClickBtnCommentDelete);
		$(".btn.update").on("click", handlerClickBtnUpdate);
		$(".btn.delete").on("click", handlerClickBtnDelete);
		$(".btn.main").on("click", handlerClickBtnMain);
		$(".btn.login").on("click", handlerClickBtnLogin);
		$(".btn.join").on("click", handlerClickBtnJoin);
		$(".btn.logout").on("click", handlerClickBtnLogout);
		$(".btn.myinfo").on("click", handlerClickBtnMyInfo);
		
		function handlerClickBtnCommentUpdate() {
			let open=0;
			
			if(open === 0) {
				open = 1;
				$("span").removeAttr("hidden");
			} else {
				open = 0;
				$("span").attr("hidden", "hidden");
			}
		}
		
		function handlerClickBtnCommentDelete() {
			console.log("댓글삭제");
			let cid=$("#cid").val();
			location.href="<%=request.getContextPath() %>/deletecomment?board=${boardid}";
		}
		
		function handlerClickBtnUpdate() {
			console.log("게시글수정");
			location.href="<%=request.getContextPath() %>/updateboard?id=${boardid}";
		}
		
		function handlerClickBtnDelete() {
			console.log("게시글삭제");
			location.href="<%=request.getContextPath() %>/deleteboard?id=${boardid}";
		}
		
		function handlerClickBtnMain() {
			console.log("메인화면으로");
			location.href="<%=request.getContextPath() %>/main";
		}
		
		function handlerClickBtnLogin() {
			console.log("로그인");
			location.href="<%=request.getContextPath()%>/login";
		}
		
		function handlerClickBtnJoin() {
			console.log("회원가입");
			location.href="<%=request.getContextPath() %>/join";
		}
		
		function handlerClickBtnLogout() {
			console.log("로그아웃");
			location.href="<%=request.getContextPath()%>/logout";
			
		}
		
		function handlerClickBtnMyInfo() {
			console.log("내정보");
			location.href="<%=request.getContextPath() %>/myinfo";
			
		}
	</script>
</body>
</html>