<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>게시글 쓰기</title>
</head>
<body>
	게시글 등록됨:
	<%-- <br> 제목: ${ command.title }
	<br> 내용: ${ command.content } --%>
	<br> 제목: ${ newArticleCommand.title }
	<br> 내용: ${ newArticleCommand.content }
	<br>작성일: ${ newArticleCommand.regdate }
</body>
</html>