<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Panel de Administrador</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            background-color: #ffffff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #343a40;
            margin-bottom: 30px;
        }
        table {
            margin-top: 20px;
        }
        .btn-container {
            margin-top: 20px;
            display: flex;
            justify-content: space-around;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Panel de Administración - Lista de Usuarios</h1>
        
        <!-- Mensaje de error si no se puede cargar la lista de usuarios -->
        <c:if test="${not empty errorMessage}">
            <div class="alert alert-danger text-center">${errorMessage}</div>
        </c:if>

        <table class="table table-bordered table-hover table-responsive">
            <thead class="table-dark">
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Usuario</th>
                    <th scope="col">Email</th>
                </tr>
            </thead>
            <tbody>
                <c:if test="${not empty listaClientes}">
                    <c:forEach var="cliente" items="${listaClientes}">
                        <tr>
                            <td>${cliente.id}</td>
                            <td>${cliente.usuario}</td>
                            <td>${cliente.email}</td>
                        </tr>
                    </c:forEach>
                </c:if>
                
                <!-- Mensaje si no hay usuarios -->
                <c:if test="${empty listaClientes}">
                    <tr>
                        <td colspan="3" class="text-center text-muted">No hay usuarios registrados.</td>
                    </tr>
                </c:if>
            </tbody>
        </table>

        <!-- Botones para volver al inicio o al login -->
        <div class="btn-container">
            <a href="inicio" class="btn btn-secondary">
                <i class="bi bi-arrow-left"></i> Volver al Inicio
            </a>
            <a href="login" class="btn btn-danger">
                <i class="bi bi-box-arrow-in-left"></i> Volver al Login
            </a>
        </div>
    </div>

    <!-- JavaScript de Bootstrap -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

