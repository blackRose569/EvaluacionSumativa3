<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Editar cliente</title>
</head>

<body>
	<div class="container">
		<form:form method="post" action="/clientes/update/${cliente.id}" modelAttribute="cliente">
			<input type="hidden" name="_method" value="put">
			<form:label path="rut" class="col-sm-2 col-form-label">Rut:</form:label>
			<form:input type="text" path="rut" class="form-control"/>
			<br>
			<form:label path="nombre" class="col-sm-2 col-form-label">Nombre:</form:label>
			<form:input type="text" path="nombre" class="form-control"/>
			<br>
			<form:label path="edad" class="col-sm-2 col-form-label">edad:</form:label>
			<form:input type="numbre" path="edad" class="form-control"/>
			<br>
			<form:label path="sexo" class="col-sm-2 col-form-label">Sexo:</form:label>
			<form:input type="text" path="sexo" class="form-control"/>
			<br>
			<form:label path="plan" class="col-sm-2 col-form-label">Plan:</form:label>
			<form:input type="text" path="plan" class="form-control"/>
			<br>
			<form:label path="celular" class="col-sm-2 col-form-label">Celular:</form:label>
			<form:input type="text" path="celular" class="form-control"/>
			<br>		
			<a href="/clientes" class="btn btn-success" role="button" data-bs-toggle="button">Limpiar</a>
			<input type="submit" class="btn btn-primary" value="Submit">

		</form:form>
	</div>
</body>

</html>