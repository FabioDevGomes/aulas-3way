<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
	<title>Adicionar novo Livro</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
</head>
<body>
<div class="container">
	<div class="panel panel-primary ">
		<div class="panel-heading">Cadastro</div>
			<div class="panel-body">

					<form method="POST" action='pessoaController' name="frmAddLivro">
						<fieldset>
							<div class="form-group">
								C�digo do Livro : 
								<input type="text" readonly="readonly" name="pessoaId" value="${pessoa.id}" class="form-control"/> 
							</div>
							<div class="form-group">
								T�tulo : 
								<input type="text"	name="nome" value="${pessoa.nome}" class="form-control"/> 
							</div>
							<div class="form-group">
								<input	type="submit" value="Submit" class="btn btn-primary"/>
							</div>
						</fieldset>
					</form>
			</div>
		</div>
		</div>
	</body>
</html>