<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 수정</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/updateboard" method="post">
		<input type="number" name="boardid" value="${boardid }" hidden="hidden">
		제목:
		<input type="text" name="btitle" value="${btitle }">
		<br>
		내용:
		<br>
		<textarea rows="10" cols="40" name="bcontent">${bcontent }</textarea>
		<br>
		<button type="submit">게시글등록</button>
		<button type="button">취소</button>
	</form>
</body>
</html>