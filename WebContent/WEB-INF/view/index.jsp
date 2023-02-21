<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<%--<script src="<%=request.getContextPath()%>/"></script> --%>
</head>
<body>
	<%-- <img src="<%=request.getContextPath()"/resources/images/***.jpg>--%>
	<jsp:include page="/WEB-INF/view/header.jsp" />
	<jsp:include page="/WEB-INF/view/board/boardlist.jsp" />
		<script>
			$(".btn.login").on("click", handlerClickBtnLogin);
			$(".btn.join").on("click", handlerClickBtnJoin);
			$(".btn.logout").on("click", handlerClickBtnLogout);
			$(".btn.myinfo").on("click", handlerClickBtnMyInfo);
			
			
			
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