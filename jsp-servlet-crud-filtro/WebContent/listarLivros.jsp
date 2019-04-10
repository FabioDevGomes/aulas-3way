<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Livro</title>
</head>
<body>
	<form method="get" action='livroController' name="frmBuscarLivro">
		<input type="text" name="buscarLivroFiltro" placeholder="Buscar por Título"/> 
		<input	type="submit" value="Buscar" />
	</form>
	<table border=1>
        <thead>
            <tr>
                <th>Código Livro</th>
                <th>Título</th>
                <th>Autor</th>
                <th>Descrição</th>
                <th>Preco</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${livros}" var="livro">
                <tr>
                    <td><c:out value="${livro.codigo}" /></td>
                    <td><c:out value="${livro.titulo}" /></td>
                    <td><c:out value="${livro.autor}" /></td>
                    <td><c:out value="${livro.descricao}" /></td>
                    <td><c:out value="${livro.preco}" /></td>
                    <td><a href="livroController?action=editar&livroId=<c:out value="${livro.codigo}"/>">Update</a></td>
                    <td><a href="livroController?action=deletar&livroId=<c:out value="${livro.codigo}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="/jsp-servlet-crud/livroController?action=insert">Livro</a></p>
</body>
</html>