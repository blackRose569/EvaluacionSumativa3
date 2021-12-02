<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page='../template/header.jsp'/>

<body>
	<jsp:include page='../template/navbar.jsp'/>
	<div class="container">
	<h1>Ventas</h1>
			<hr>
	<h2>Crear ventas</h2>
	
		<form:form method="post" action="/ventas/crear" modelAttribute="venta">
			<input type="hidden" name="_method" value="put">
			<form:label path="producto" class="col-sm-2 col-form-label">Producto:</form:label>
			<form:input type="text" path="producto" class="form-control"/>
			<br>
			<form:label path="cantidad" class="col-sm-2 col-form-label">Cantidad:</form:label>
			<form:input type="text" path="cantidad" class="form-control"/>
			<br>
			<form:label path="total" class="col-sm-2 col-form-label">Total:</form:label>
			<form:input type="number" path="total" class="form-control"/>	
			
			<br>		
			<a href="/ventas" class="btn btn-success" role="button" data-bs-toggle="button">Limpiar</a>
			<input type="submit" class="btn btn-primary" value="Submit">
			
		</form:form>
	
		<br>
		
	</div>
	<jsp:include page='../template/footer.jsp'/>
</body>

</html>