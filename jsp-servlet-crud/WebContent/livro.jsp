<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
	<title>Adicionar livro</title>
</head>
<body>

	<form method="POST" action='livroController'>
			Código Livro : 
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