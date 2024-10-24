<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tus Reservas</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Tus Reservas ${cliente.usuario}</h1>
        
        <table class="table table-bordered table-hover">
            <thead class="table-dark">
                <tr>
                    <th scope="col">Servicio</th>
                    <th scope="col">Fecha</th>
                    <th scope="col">Hora</th>
                </tr>
            </thead>
            <tbody>
                <c:if test="${not empty reservas}">
                    <c:forEach var="reserva" items="${reservas}">
                        <tr>
                            <td>${reserva.servicio.nombre}</td>
                            <td>${reserva.fecha}</td>
                            <td>${reserva.tiempo}</td>
                        </tr>
                    </c:forEach>
                </c:if>
                
                <c:if test="${empty reservas}">
                    <tr>
                        <td colspan="3" class="text-center text-muted">No tienes reservas aún.</td>
                    </tr>
                </c:if>
            </tbody>
        </table>

        <div class="text-center mt-3">
            <a href="servicios" class="btn btn-primary">Reservar un servicio</a>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

