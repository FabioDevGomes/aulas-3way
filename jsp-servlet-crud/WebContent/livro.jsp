<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
	<title>Adicionar livro</title>
</head>
<body>

	<form method="POST" action='livroController'>
			C�digo Livro : 
			<input type="text" readonly="readonly" name="livroCodigo" value="${livro.codigo}" /> 
			<br /> T�tulo : 
			<input type="text"	name="titulo" value="${livro.titulo}" /> 
			<br /> Autor : 
			<input	type="text" name="autor" value="${livro.autor}" /> 
			<br /> Descri��o : 
			<input	type="text" name="descricao" value="${livro.descricao}" /> 
			<br /> Pre�o :
			<input type="text" name="preco" value="${livro.preco}" /> 
			<br /> 
			<input	type="submit" value="Submit" />
	</form>
</body>