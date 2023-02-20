<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인페이지</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
</head>
<body>
	<section>
		<form action="login" method="post">
			<span>ID : </span>
			<input type="text" name="id">
			<br>
			<span>패스워드 : </span>
			<input type="password" name="passwd">
			<br>
			<button type="submit" >로그인</button>
			<button type="button" class="btn join">회원가입</button>
		</form>
	</section>
	<script>
		$(".btn.join").on("click", handlerClickBtnJoin);
		
		function handlerClickBtnJoin() {
			console.log("로그인 -> 회원가입");
			location.href="<%=request.getContextPath() %>/join";
		}
	</script>
</body>
</html>