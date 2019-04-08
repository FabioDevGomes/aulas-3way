<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Tela de Listagem com JSTL</title>
	</head>
	<body>
		<table>
	<%-- 		<c:forEach items="${listaLivrosNoAtributo}" var="livro"> --%>
			<c:forEach items="${requestScope.listaLivrosNoAtributo}" var="livro">
				<tr>
					<td><c:out value="${livro.titulo}"></c:out></td>
					<td><c:out value="${livro.autor}"></c:out></td>
					<td><c:out value="${livro.descricao}"></c:out></td>
				</tr>
			</c:forEach>
		</table>
		<c:set var="operacao" scope="session" value="${4000*4}"/>  
		<c:out value="${operacao}"/>  
		
		<c:set var="usuario" scope="session" value="${requestScope.usuarioLogado}"/>
		<c:out value="${usuario}"/>  
		
		<c:out value="${sessionScope.userName}"/>  
	</body>
</html>