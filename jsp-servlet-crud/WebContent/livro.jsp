<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<link type="text/css" href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
	<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
	<title>Add new livro</title>
</head>
<body>

	<form method="POST" action='LivroController' name="frmAddLivro">
			User ID : 
			<input type="text" readonly="readonly" name="livroCodigo" value="${livro.codigo}" /> 
			<br /> T�tulo : 
			<input type="text"	name="titulo" value="${livro.titulo}" /> 
			<br /> Autor : 
			<input	type="text" name="autor" value="${livro.autor}" /> 
			<br /> Descri豫o : 
			<input	type="text" name="descricao" value="${livro.descricao}" /> 
			<br /> Pre�o :
			<input type="text" name="preco" value="${livro.preco}" /> 
			<br /> 
			<input	type="submit" value="Submit" />
	</form>
</body>