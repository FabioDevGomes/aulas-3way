<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
	<title>Adicionar novo Livro</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
</head>
<body>
	<div class="panel panel-primary">
		<div class="panel-heading">Cadastro</div>
			<div class="panel-body">

				<form method="POST" action='livroController' name="frmAddLivro">
					<fieldset>
						<div class="form-group">
							Código do Livro : 
							<input type="text" readonly="readonly" name="livroCodigo" value="${livro.codigo}" class="form-control"/> 
						</div>
						<div class="form-group">
							Título : 
							<input type="text"	name="titulo" value="${livro.titulo}" class="form-control"/> 
						</div>
						<div class="form-group">
							Autor : 
							<input	type="text" name="autor" value="${livro.autor}" class="form-control"/> 
						</div>
						<div class="form-group">
							Descrição : 
							<input	type="text" name="descricao" value="${livro.descricao}" class="form-control"/> 
						</div>
						<div class="form-group">
							Preço :
							<input type="text" name="preco" value="${livro.preco}" class="form-control"/> 
						</div>
						<div class="form-group">
							<input	type="submit" value="Submit" class="btn btn-primary"/>
						</div>
					</fieldset>
				</form>
			</div>
		</div>
	</html>
</body>