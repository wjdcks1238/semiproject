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
	<c:if test="${empty lgnss }">
		<script>
			alert("로그인 해주시기 바랍니다.");
			location.href="<%=request.getContextPath() %>/"
		</script>
	</c:if>
	<section>
	<form action="<%=request.getContextPath() %>/myinfo" method="post">
		<h1>내정보 수정</h1>
		ID:
		<input type="text" value="${lgnss.id }" name="id" readonly style="border-style: none;">
		<br>
		이름:
		<input type="text" value="${lgnss.name }" name="name">
		<br>
		비밀번호:
		<input type="password" name="passwd" id="passwd">
		<span id="invaildChk"></span>
		<br>
		이메일:
		<input type="email" value="${lgnss.email }" name="email">
		<br><br>
		<button type="submit" disabled = "disabled">수정하기</button>
		<button type="button" class="btn main">취소</button>
	</form>
	</section>
	
	<script>
	
	let isNameNull = false; // 이름칸이 널인지?
	let isEmailNull = false; // 이메일칸이 널인지?
	let isPasswdVaild = false; // password 조건이 부합한지
	
	$("#passwd").on("input", invalidChkPasswd);
	$("#name").on("input", nullChkName);
	$("#email").on("input", nullChkEmail);
	$(".btn.main").on("click", handlerclickmail);
	
	function setButtonState() {
		if(!isNameNull && !isEmailNull && isPasswdValid) {
			$("button[type=submit]").removeAttr("disabled");
		} else {
			$("button[type=submit]").attr("disabled", "disabled");
		}
	}
	
	function invalidChkPasswd() {
			let pass = $("#passwd").val();
			
			if(pass.length < 5) {
				$("#invaildChk").html("패스워드가 5글자 이하입니다. 5글자 이상으로 작성해 주세요.");
				$("#invaildChk").css("color", "red");
				isPasswdValid = false;
				setButtonState();
			} else {
				$("#invaildChk").html("패스워드가 5글자 이상입니다.");
				$("#invaildChk").css("color", "green");
				isPasswdValid = true;
				setButtonState();
			}
		}
	
		function nullChkName() {
			let name = $("#name").val();
			if(name === "") {
				isNameNull = true;
				setButtonState();
			} else {
				isNameNull = false;
				setButtonState();
			}
		}
		
		function nullChkEmail() {
			let email = $("#email").val();
			if(email === "") {
				isEmailNull = true;
				setButtonState();
			} else {
				isEmailNull = false;
				setButtonState();
			}
		}
		
		function handlerclickmail() {
			console.log("메인으로");
			location.href="<%=request.getContextPath() %>/";
		}
	</script>
</body>
</html>