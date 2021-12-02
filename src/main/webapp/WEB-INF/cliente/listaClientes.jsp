<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>clientes</title>
</head>
<body>
        <div class="container">
                <h1>Registro de clientes</h1>

		<a href="../clientes" class="btn btn-primary">Volver</a>
		
		<table class="table">
			<thead >
				<tr>
					<th>Rut</th>
					<th>Nombre</th>
					<th>Edad</th>
					<th>Sexo</th>
					<th>Plan</th>
					<th>Celular</th>
				</tr>
			</thead>
			<c:forEach items="${listaClientes}" var="lista">
				<tr>
					
					<td>${lista.getRut()}</td>
					<td>${lista.getNombre()}</td>
					<td>${lista.getEdad()}</td>
					<td>${lista.getSexo()}</td>
					<td>${lista.getPlan()}</td>
					<td>${lista.getCelular()}</td>
					<td>
						<a href="/clientes/${lista.getId()}/editar" class="btn btn-primary" role="button" data-bs-toggle="button">Editar</a>
					</td>
					
					<td>
						<form action="/clientes/eliminar" method="get">
							<input type="hidden" name="id" value="${lista.getId()}">
							<input type="submit" value="X">
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
		


	</div>
</body>
</html>