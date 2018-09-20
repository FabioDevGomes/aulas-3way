<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Meu primeiro JSP</title>
	</head>
	<body>
		<form action="helloServlet">
			Informe a cor <br> 
			<input type="text" name="color"	size="20px"> 
			<input type="submit" value="submit">
		</form>
		<c:out value="${Income}"/>  
		<c:out value="${usuario}"/>  
	</body>
</html>