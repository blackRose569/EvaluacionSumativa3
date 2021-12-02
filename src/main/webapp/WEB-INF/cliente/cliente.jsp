<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page='../template/header.jsp'/>

<body>
	<jsp:include page='../template/navbar.jsp'/>
	<div class="container">
	<h1>Cliente</h1>
			<hr>
	<h2>Crear clientes</h2>
	
		<form:form method="post" action="/clientes/crear" modelAttribute="cliente">
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
			<form:label path="plan" class="col-sm-2 col-form-label">Plan(true o false):</form:label>
			<form:input type="text" path="plan" class="form-control"/>
			<br>
			<form:label path="celular" class="col-sm-2 col-form-label">Celular:</form:label>
			<form:input type="text" path="celular" class="form-control"/>
			<br>		
			<a href="/clientes" class="btn btn-success" role="button" data-bs-toggle="button">Limpiar</a>
			<input type="submit" class="btn btn-primary" value="Submit">
			
		

		</form:form>
	
		<br>
		
	</div>
	<jsp:include page='../template/footer.jsp'/>
</body>

</html>