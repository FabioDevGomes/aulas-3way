<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Livro</title>
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
</head>
<body>
	<br/>
	<div class="container">
		<form method="get" action='livroController' name="frmBuscarLivro">
			<div class="input-group">
				<input type="text" name="livroFiltro" placeholder="Buscar por T�tulo" class="form-control"/> 
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
	                <th>Id</th>
	                <th>Nome</th>
	                <th>Data Nascimento</th>
	                <th>E-mail</th>
	                <th colspan=2>Action</th>
	            </tr>
	        </thead>
	        <tbody>
	            <c:forEach items="${pessoas}" var="pessoa">
	                <tr>
	                    <td><c:out value="${pessoa.id}" /></td>
	                    <td><c:out value="${pessoa.nome}" /></td>
	                    <td><c:out value="${pessoa.dataNascimento}" /></td>
	                    <td><c:out value="${pessoa.email}" /></td>
	                    <td><a href="pessoaController?action=editar&pessoaId=<c:out value="${pessoa.id}"/>">Update</a></td>
	                    <td><a href="pessoaController?action=deletar&pessoaId=<c:out value="${pessoa.id}"/>">Delete</a></td>
	                </tr>
	            </c:forEach>
	        </tbody>
	    </table>
	    <p><a href="/jsp-servlet-jpa/pessoaController?action=insert">Nova Pessoa</a></p>
    </div>
</body>
</html>