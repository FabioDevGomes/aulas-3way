<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Tela de Listagem com JSTL</title>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	</head>
	<body>
		<table class="table table-striped">
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