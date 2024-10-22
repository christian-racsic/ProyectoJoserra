<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro</title>
    <!-- Cargar Bootstrap desde CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    
    <p>
    	<font color = "red">${errores}</font>
    </p>
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header">
                        <h3 class="text-center">Registrarse</h3>
                    </div>
                    <div class="card-body">
                        <mvc:form action="registro" method="post" modelAttribute="cliente">
    <div class="mb-3">
        <mvc:label path="usuario" class="form-label">Nombre:</mvc:label>
        <mvc:input path="usuario" type="text"  class="form-control" id="usuario" name="usuario"/>
    	<mvc:errors path= "usuario" cssClass="text-warning"/>
    </div>
    <div class="mb-3">
        <mvc:label path="email" class="form-label">Correo Electrónico:</mvc:label>
        <mvc:input path="email" type="email" class="form-control" id="correo" name="correo"/>
    	<mvc:errors path= "email" cssClass="text-warning"/>
    </div>
    <div class="mb-3">
        <mvc:label path="password" class="form-label">Contraseña:</mvc:label>
        <mvc:input path="password" type="password" class="form-control" id="contraseña" name="contraseña"/>
    	<mvc:errors path= "password" cssClass="text-warning"/>
    </div>
    <div class="d-grid">
        <button type="submit" class="btn btn-success">Registrarse</button>
    </div>
</mvc:form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Cargar Bootstrap JS desde CDN -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

