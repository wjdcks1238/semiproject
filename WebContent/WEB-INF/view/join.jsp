<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
</head>
<body>
	<section>
		<form action="<%=request.getContextPath() %>/join" method="post">
			이름:<input type="text" name="name" id="name">
			<br>
			ID:<input type="text" name="id">
			<button type="button" id="dupId">아이디중복확인</button>
			<span></span>
			<br>
			비밀번호:<input type="password" name="passwd" id="passwd">
			<span id="invaildResult"></span>
			<br>
			비밀번호 확인:<input type="password" name="chkPasswd" id="chkPasswd">
			<span id="passwdChkResult"></span>
			<br>
			email:<input type="email" name="email" id="email">
			<br>
			<button type="submit" disabled="disabled" class="btn submit">회원가입하기</button>
			<button type="reset" class="btn reset">양식초기화</button>
			<button type="button" class="btn main">메인으로</button>
		</form>
	</section>
	<script>
	
		let isNameVaild = false;
		let isIdchkVaild = false;
		let chkinputpwd = false;
		let isPwdchkVaild = false;
		let isEmailVaild = false;
		
		$(".btn.main").on("click", handlerClickMain);
		$("#name").on("input", chkName);
		$("#passwd").on("input", invaildChkPasswd);
		$("#chkPasswd").on("input", chkPasswd);
		$("#email").on("input", chkEmail);
		$(".btn.reset").on("click", handlerClickReset);
		$(".btn.submit").on("click", handlerClickSubmit);
		
		function handlerClickReset() {
			$("button[type=submit]").attr("disabled", "disabled");
			$("#invaildResult").html("");
			$("#invaildResult").css("color", "black");
			$("#dupId").next().html("");
			$("#dupId").next().css("color", "black");
			$("#passwdChkResult").html("");
			$("#passwdChkResult").css("color", "black");
		}
		
		function chkName() {
			let chkName = $("#name").val();
			
			if(chkName === "") {
				isNameVaild = false;
			} else {
				isNameVaild = true;
			}
			setButtonState();
		}
		
		function invaildChkPasswd() {
			let inputPw=$("#passwd").val();
			
			if(inputPw.length < 5) {
				$("#invaildResult").html("패스워드가 5글자 밑입니다. 5글자 이상으로 작성해 주세요.");
				$("#invaildResult").css("color", "red");
				chkPasswd();
				chkinputpwd = false;
			} else {
				$("#invaildResult").html("패스워드가 5글자 이상입니다.");
				$("#invaildResult").css("color", "green");
				chkPasswd();
				chkinputpwd = true;
			}
			setButtonState();
		}
	
		$("#dupId").click(chkDupId);
		function chkDupId() {
			$.ajax({
				url:"<%=request.getContextPath()%>/dupId"
				, type:"post"
				, async:false
				, data: {id:$("input").next().next().val()}
				, success: function(result) {
					console.log(result);
					if(result === "fail") {
						$("#dupId").next().html("중복아이디가 있습니다. 다시 입력바랍니다.");
						$("#dupId").next().css("color", "red");
						isIdchkVaild = false;
					} else {
						$("#dupId").next().html("사용가능한 아이디입니다.");
						$("#dupId").next().css("color", "green");
						isIdchkVaild = true;
					}
					setButtonState();
				}
				, error: function(request, status, error) {
					alert(request, status);
				}
			});
		}
		
		function chkPasswd() {
			let pass = $("#passwd").val();
			let chkPass = $("#chkPasswd").val();
			
			if(chkPass === ""){
				$("#passwdChkResult").html("정확한 패스워드 확인을 위해 다시 한번 입력 바랍니다.");
				$("#passwdChkResult").css("color", "red");
				isPwdchkVaild = false;
			} else {
				if(pass === chkPass) {
					$("#passwdChkResult").html("패스워드가 동일합니다.");
					$("#passwdChkResult").css("color", "green");
					$("#invaildResult").html("");
					$("#invaildResult").css("color", "black");
					isPwdchkVaild = true;
				} else {
					$("#passwdChkResult").html("패스워드가 동일하지 않습니다.");
					$("#passwdChkResult").css("color", "red");
					isPwdchkVaild = false;
				}
			}
			setButtonState();
		}
		
		function chkEmail() {
			let chkEmail = $("#email").val();
			
			if(chkEmail === "") {
				isEmailVaild = false;
			} else {
				isEmailVaild = true;
			}
			setButtonState();
		}
		
		function setButtonState() {
			if(isNameVaild && isIdchkVaild && chkinputpwd && isPwdchkVaild && isEmailVaild) {
				$("button[type=submit]").removeAttr("disabled");
			} else {
				$("button[type=submit]").attr("disabled", "disabled");
			}
		}
		
		function handlerClickMain() {
			console.log("메인화면으로 이동");
			location.href="<%=request.getContextPath() %>/";
		}
		
	</script>
</body>
</html>