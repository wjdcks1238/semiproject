<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/insertboard" method="post">
		<input type="text" name="id" value="${lgnss.id }" hidden="hidden">
		제목:
		<input type="text" name="btitle">
		<br>
		<textarea rows="5" cols="20" name="bcontent"></textarea>
		<br>
		<button type="submit">게시글등록</button>
		<button type="button">취소</button>
	</form>
</body>
</html>