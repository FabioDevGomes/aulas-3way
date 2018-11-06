<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
</head>
<body>
	<div class="col-sm-6">
		<div class="panel panel-primary">
			<div class="panel-heading">Cadastro</div>
			<div class="panel-body">
				<!--<form method="post" action="">-->
				<form action="helloServlet">
					<fieldset>
						<div class="form-group">
							<label>Nome Completo</label> 
							<input type="text" class="form-control" name="nome">
						</div>
						<div class="form-group">
							<label>Usuário</label> 
							<input type="text" class="form-control"	name="nome2">
						</div>
					</fieldset>
					<input type="submit" name="Salvar" class="btn btn-primary">
				</form>

			</div>
		</div>
	</div>

</body>
</html>