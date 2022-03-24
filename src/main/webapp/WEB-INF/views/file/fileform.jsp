<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<title>파일 업로드</title>
</head>
<body>
<h3>파일을 선택하세요</h3>
<form method="post" enctype="multipart/form-data">  <!-- 멀티파트폼데이터 없으면 파일의 이름만 전송됨) -->
	파일 : <input type="file" name="file"><br>
	<!-- "file", 얘를 저장하려면 멀티파트 폼데이터 지정. 파일 타입의 파라미터는 업로드가 된 상황. 업로드가 된 상태에서 해당파일에 접근할 수 있도록. -->
	설명 : <input type="text" name="description">
	<input type="submit" value="upload">
</form>
</body>
</html>