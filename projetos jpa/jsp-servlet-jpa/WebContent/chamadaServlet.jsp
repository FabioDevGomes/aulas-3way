<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<html>
	<head>
		<title>Tela de Listagem com JSTL</title>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	</head>
	<body>
		<form action="livroController" >
			 <input type="hidden" name="action" value="listarLivros">
			<br/>
			<div align="center">
			    <input type="submit" value="Chamar Servlet de listagem de Livros" class="btn btn-primary">
			</div>
		</form>
		
		<form action="pessoaController" >
			 <input type="hidden" name="action" value="listarPessoas">
			<br/>
			<div align="center">
			    <input type="submit" value="Chamar Servlet de listagem de Pessoas" class="btn btn-primary">
			</div>
		</form>
	</body>
</html>