<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 작성</h1>
	<form action="/boardcontent" method="get">
		제목:
		<input type="text" name="btitle" value="" disabled>
		<br>
		<textarea rows="100" cols="100" name="bcontent"></textarea>
	</form>
</body>
</html>