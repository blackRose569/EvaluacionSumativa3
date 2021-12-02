<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Lista</title>
</head>
<body>
        <div class="container">
                <h1>Registro de productos</h1>

		<a href="../productos" class="btn btn-primary">Volver</a>
		
		<table class="table">
			<thead >
				<tr>
					
					<th>Nombre producto</th>
					<th>Precio</th>
					<th>Categoria</th>
				</tr>
			</thead>
			<c:forEach items="${listaProductos}" var="lista">
				<tr>
					
					<td>${lista.getNombre()}</td>
<%-- 					<td>${lista.getCategoria()}</td> --%>
					<td>${lista.getPrecio()}</td>
					<td>${lista.getCategorias()}</td>
<!-- 					<td> -->
<%-- 						<a href="/productos/${lista.getId()}/editar" class="btn btn-primary" role="button" data-bs-toggle="button">Editar</a> --%>
<!-- 					</td> -->
					
					<td>
						<form action="/productos/eliminar" method="get">
							<input type="hidden" name="id" value="${lista.getId()}">
							<input type="submit" value="X">
						</form>
					</td>
					<td>
						<form action="/productos/agregar" method="post">
							<input type="hidden" name="id" value="${lista.getId()}">
							<input type="submit" value="Agregar al carro">
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
		


	</div>
</body>
</html>