<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Livro</title>
 	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<form method="get" action='livroController' name="frmBuscarLivro">
			<div class="input-group">
				<input type="text" name="buscarLivroFiltro" placeholder="Buscar por Título" class="form-control"/> 
				<div class="input-group-btn">
			      <button class="btn btn-default" type="submit">
			        <i class="glyphicon glyphicon-search"></i>
			      </button>
			    </div>
			</div>
		</form>
	</div>
	<div class="container">
		<table  class="table">
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
	    <p><a href="/jsp-servlet-crud/livroController?action=insert">Novo Livro</a></p>
    </div>
</body>
</html>