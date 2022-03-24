<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>CreatePage</title>
</head>
<body>
	createPage.jsp	<br />
	<form:form action="create" modelAttribute="dto" method="get">
	<!-- form:from은 form태그와 모델데이터로 전달받은 DTO 클래스를 자동으로 짝지어주는 역할해줌 -->
	<!-- 현재 dto는 없으므로 null -->
		작성자 : <input type="text" name="writer" value="${dto.writer}"><!-- 칸을 비우기 위함 -->
		<form:errors path="writer" delimiter=" "/> <!-- 디리미터? 에러가 여러 개 발생시구분자 넣어줌.  -->
		<br /> 
		내용 : <input type="text" name="content" value="${dto.content}">
		<form:errors path="content"/>
		<br /> <input type="submit" value="전송"> <br />
	</form:form>

</body>
</html>