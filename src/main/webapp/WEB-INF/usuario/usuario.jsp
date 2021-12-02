<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Usuarios</title>
</head>
<body>
        <div class="container">
                <h1>Registro de usuarios</h1>
                <form action="usuarios/login" method="post">
                        <table class="table table-bordered">
                                <tr>
                                        <td><label for="nombre">Nombre: </label></td>
                                        <td><input type="text" name="nombre" id="nombre" ></td>
                                        
                                </tr>
                                <tr>
                                        <td><label for="apellido">Apellido: </label></td>
                                        <td><input type="text" name="apellido" id="apellido" ></td>
                                        
                                </tr>
                                <tr>
                                        <td><label for="telefono">telefono: </label></td>
                                        <td><input type="number" name="telefono" id="telefono"></td>
                                        
                                </tr>
                                
								<tr>
                                        <td><span style="color:red;">${mensajeError}</span></td>
                                        <td><input type="reset" value="limpiar" class="btn btn-warning"> <input type="submit" value="enviar" class="btn btn-success"></td>
                                        
                                </tr>
                                
                        </table>
                </form>
                
                
        
        </div>
</body>
</html>