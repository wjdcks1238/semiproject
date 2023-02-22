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
	
	<script>
		$(".btn.update").on("click", handlerClickBtnUpdate);
		$(".btn.delete").on("click", handlerClickBtnDelete);
		$(".btn.main").on("click", handlerClickBtnMain);
		$(".btn.login").on("click", handlerClickBtnLogin);
		$(".btn.join").on("click", handlerClickBtnJoin);
		$(".btn.logout").on("click", handlerClickBtnLogout);
		$(".btn.myinfo").on("click", handlerClickBtnMyInfo);
		
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