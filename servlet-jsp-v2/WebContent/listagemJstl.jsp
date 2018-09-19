<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table>
		<c:forEach items="${requestScope.listaLivrosNoAtributo}" var="livro">
			<tr>
				<td><c:out value="${livro.titulo}"></c:out></td>
				<td><c:out value="${livro.autor}"></c:out></td>
				<td><c:out value="${livro.descricao}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>