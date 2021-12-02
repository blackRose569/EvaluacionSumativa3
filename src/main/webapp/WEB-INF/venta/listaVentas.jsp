<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Lista de ventas</title>
</head>
<body>
        <div class="container">
                <h1>Lista de ventas</h1>

		<a href="../ventas" class="btn btn-primary">Volver</a>
		
		<table class="table">
			<thead >
				<tr>
					
					<th>Cantidad</th>
					<th>Total venta </th>
					<th>Producto </th>
					
				</tr>
			</thead>
			<c:forEach items="${listaVentas}" var="lista">
				<tr>
					
<%-- 					<td>${lista.getCantidad()}</td> --%>
					<td>1</td>
					<td>${lista.getTotalVenta()}</td>
					<td>${lista.getProductos()}</td>
					<td>
						<a href="/ventas/${lista.getId()}/editar" class="btn btn-primary" role="button" data-bs-toggle="button">Editar</a>
					</td>
					
					<td>
						<form action="/ventas/eliminar" method="get">
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