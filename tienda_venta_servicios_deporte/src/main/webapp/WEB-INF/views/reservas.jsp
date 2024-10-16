<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Servicios Disponibles</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <div class="d-flex justify-content-between">
            <h1 class="text-center mb-4">Nuestros Servicios</h1>
            <div>
                <a href="logoutServ" class="btn btn-secondary">Cerrar Sesión</a>
                <a href="paginaPrincipalServ" class="btn btn-primary">Volver</a>
            </div>
        </div>

        <div class="row mt-4">
            <c:if test="${not empty servicios}">
                <c:forEach var="servicio" items="${servicios}">
                    <div class="col-md-4 mb-4">
                        <div class="card h-100 shadow-sm">
                            <img src="${servicio.imagen}" class="card-img-top" alt="Imagen de ${servicio.nombre}">
                            <div class="card-body">
                                <h5 class="card-title text-center">${servicio.nombre}</h5>
                            </div>
                            <div class="card-footer text-center">
                                <a href="hacerReserva?nombreServicio=${servicio.nombre}" class="btn btn-primary">Reservar</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </c:if>

            <c:if test="${empty servicios}">
                <div class="col-12">
                    <div class="alert alert-warning text-center">
                        No hay servicios disponibles en este momento.
                    </div>
                </div>
            </c:if>
        </div>

    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
