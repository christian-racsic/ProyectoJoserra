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
            background: linear-gradient(rgba(0, 0, 0, 0.6), rgba(0, 0, 0, 0.6)), 
                url('https://images.unsplash.com/photo-1506748686214-e9df14d4d9d0?auto=format&fit=crop&w=1950&q=80');
            background-size: cover;
            background-position: center;
            color: #fff;
        }
        .container {
            background-color: rgba(255, 255, 255, 0.9);
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.5);
        }
        h1 {
            color: #343a40;
            margin-bottom: 30px;
            text-align: center;
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.8);
        }
        table {
            margin-top: 20px;
        }
        .btn-container {
            margin-top: 20px;
            display: flex;
            justify-content: space-around;
        }
        .alert {
            color: #000;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <h1>Panel de Administración - Lista de Usuarios</h1>
        
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
                
                <c:if test="${empty listaClientes}">
                    <tr>
                        <td colspan="3" class="text-center text-muted">No hay usuarios registrados.</td>
                    </tr>
                </c:if>
            </tbody>
        </table>
        
        <div class="btn-container">
            <a href="inicio" class="btn btn-secondary">Volver al Inicio</a>
            <a href="login" class="btn btn-danger">Volver al Login</a>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>


