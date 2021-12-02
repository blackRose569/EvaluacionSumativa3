<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page='../template/header.jsp'/>

<body>
	<jsp:include page='../template/navbar.jsp'/>
	<div class="container">
	<h1>Proveedores</h1>
			<hr>
	<h2>Crear proveedores</h2>
	
		<form:form method="post" action="/proveedores/crear" modelAttribute="proveedor">
			<input type="hidden" name="_method" value="put">
			<form:label path="nombre" class="col-sm-2 col-form-label">Nombre:</form:label>
			<form:input type="text" path="nombre" class="form-control"/>
			<br>
			<form:label path="apellido" class="col-sm-2 col-form-label">Apellido:</form:label>
			<form:input type="text" path="apellido" class="form-control"/>
			<br>
			<form:label path="email" class="col-sm-2 col-form-label">Email:</form:label>
			<form:input type="text" path="email" class="form-control"/>
			<br>
			<form:label path="edad" class="col-sm-2 col-form-label">Edad:</form:label>
			<form:input type="number" path="edad" class="form-control"/>
			<br>
			<form:select class="form-control" path="clientes">
				<c:forEach items="${listaClientes}" var="cliente" >
					<form:option value="${cliente.getId()}">
						${cliente.getNombre()}
			     	</form:option>
				</c:forEach>
			</form:select>
			<br>		
			<a href="/proveedores" class="btn btn-success" role="button" data-bs-toggle="button">Limpiar</a>
			<input type="submit" class="btn btn-primary" value="Submit">
			
		</form:form>
	
		<br>
		
	</div>
	<jsp:include page='../template/footer.jsp'/>
</body>

</html>