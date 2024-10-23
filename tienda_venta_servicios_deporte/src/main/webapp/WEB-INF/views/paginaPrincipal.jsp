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
    <style>
        
        /*url('https://images.unsplash.com/photo-1505839673365-e3971f8d9188?auto=format&fit=crop&w=1950&q=80');*/
        body {
            background: linear-gradient(rgba(0, 0, 0, 0.6), rgba(0, 0, 0, 0.6)), 
                url('https://images.unsplash.com/photo-1521412644187-c49fa049e84d?auto=format&fit=crop&w=1950&q=80');
            background-size: cover;
            background-position: center;
            height: 100vh;
            color: #fff;
        }

        
        h1, h2 {
            font-family: 'Arial', sans-serif; 
            color: #f8f9fa; 
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.8); 
            font-weight: bold;
            text-align: center;
            margin-bottom: 20px;
        }

        
        .table {
            background-color: rgba(255, 255, 255, 0.9);
        }

        .table-dark {
            background-color: #007bff;
        }

        .btn-secondary {
            background-color: #6c757d;
        }

        .btn-primary {
            background-color: #007bff;
        }

        
        .container {
            background-color: rgba(255, 255, 255, 0.8);
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.5);
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Tus Reservas ${cliente.usuario}</h1>
        <div class="d-flex justify-content-between mb-4">
            <h2></h2>
            <div>
                <a href="logoutServ" class="btn btn-secondary">Cerrar Sesión</a>
            </div>
        </div>
        <table class="table table-bordered table-hover">
            <thead class="table-dark text-white">
                <tr>
                    <th scope="col">Servicio</th>
                    <th scope="col">Fecha</th>
                    <th scope="col">Hora</th>
                </tr>
            </thead>
            <tbody>
                <c:if test="${not empty cliente.reservas}">
                    <c:forEach var="reserva" items="${cliente.reservas}">
                        <tr>
                            <td>${reserva.servicio.nombre}</td>
                            <td>${reserva.fecha}</td>
                            <td>${reserva.tiempo}</td>
                        </tr>
                    </c:forEach>
                </c:if>
                
                <c:if test="${empty cliente.reservas}">
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
