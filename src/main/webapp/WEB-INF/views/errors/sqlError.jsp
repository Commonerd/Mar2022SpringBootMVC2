<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isErrorPage="true" %> <!-- 예외가 발생했을 때 보여지는 예외페이지라는 의미 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
</head>
<body>
<h1><font color="red">SQLException 발생!</font></h1>
<a href="/"> index로 이동 </a><hr>
<table>
<tr>
	<th bgcolor="red" align="left">예외 메세지 : [[${exception.message}]]</th>
</tr>

</table>
</body>
</html>


