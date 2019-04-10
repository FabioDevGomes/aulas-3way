<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
	<link type="text/css" href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
	<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
	<title>Adicionar novo Livro</title>
</head>
<body>

	<form method="POST" action='livroController' name="frmAddLivro">
			Código do Livro : 
			<input type="text" readonly="readonly" name="livroCodigo" value="${livro.codigo}" /> 
			<br /> Título : 
			<input type="text"	name="titulo" value="${livro.titulo}" /> 
			<br /> Autor : 
			<input	type="text" name="autor" value="${livro.autor}" /> 
			<br /> Descrição : 
			<input	type="text" name="descricao" value="${livro.descricao}" /> 
			<br /> Preço :
			<input type="text" name="preco" value="${livro.preco}" /> 
			<br /> 
			<input	type="submit" value="Submit" />
	</form>
</body>