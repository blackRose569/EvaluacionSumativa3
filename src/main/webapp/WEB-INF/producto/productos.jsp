<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page='../template/header.jsp'/>

<body>
	<jsp:include page='../template/navbar.jsp'/>
	<div class="container">
	<h1>Producto</h1>
			<hr>
	<h2>Crear producto</h2>
	
		<form:form method="post" action="/productos/crear" modelAttribute="productos">
		
			<form:label path="nombre" class="col-sm-2 col-form-label">Nombre:</form:label>
			<form:input type="text" path="nombre" class="form-control"/>
			<br>
			<form:label path="descripcion" class="col-sm-2 col-form-label">descripcion:</form:label>
			<form:input type="text" path="descripcion" class="form-control"/>
			<br>
			<form:label path="precio" class="col-sm-2 col-form-label">precio:</form:label>
			<form:input type="text" path="precio" class="form-control"/>
			
			<br>
			<form:select class="form-control" path="categorias">
				<c:forEach items="${listaCategorias}" var="categoria" >
					<form:option value="${categoria.getId()}">
						${categoria.getNombre()}
			     	</form:option>
				</c:forEach>
			</form:select>
			<br>		
			<a href="/categorias" class="btn btn-success" role="button" data-bs-toggle="button">Limpiar</a>
			<input type="submit" class="btn btn-primary" value="Submit">
			
		

		</form:form>
	
		<br>
		
	</div>
	<jsp:include page='../template/footer.jsp'/>
</body>

</html>