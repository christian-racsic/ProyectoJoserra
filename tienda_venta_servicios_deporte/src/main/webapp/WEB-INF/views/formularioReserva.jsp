<!DOCTYPE html>
<html lang="es">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc"%>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reservar Servicio</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* Imagen de fondo */
        body {
            background: linear-gradient(rgba(0, 0, 0, 0.6), rgba(0, 0, 0, 0.6)), 
url('https://images.unsplash.com/photo-1521412644187-c49fa049e84d?auto=format&fit=crop&w=1950&q=80');            background-size: cover;
            background-position: center;
            height: 100vh;
            color: #fff;
        }

        /* Estilo del contenedor */
        .container {
            background-color: rgba(255, 255, 255, 0.8);
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.5);
        }

        /* Estilo de los títulos */
        h2 {
            font-family: 'Arial', sans-serif;
            color: #f8f9fa;
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.8);
            font-weight: bold;
            margin-bottom: 20px;
        }

        /* Estilo de los botones */
        .btn-secondary, .btn-primary {
            background-color: #6c757d;
            border-color: #6c757d;
        }

        .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
        }

        /* Estilo de los formularios */
        .form-label {
            color: #000;
            font-weight: bold;
        }

        .form-control {
            background-color: rgba(255, 255, 255, 0.9);
        }
    </style>
</head>
<body>
	<p>
    	<font color = "red">${errores}</font>
    </p>
    <div class="container mt-5">
        <h2 class="text-center">Formulario de Reserva</h2>
        <mvc:form action="hacerReservaFinal" method="post" modelAttribute="reservas"> 
    <div class="mb-3">
        <mvc:label path="servicio" class="form-label">Nombre del Servicio</mvc:label>
		<mvc:input path="servicio" type="text" class="form-control" id="nombreServicio" readonly/>
        <mvc:errors path="servicio" cssClass="text-warning"/>
    </div>
    <div class="mb-3">
        <mvc:label path="fecha" class="form-label">Fecha de Reserva</mvc:label>
        <mvc:input path="fecha" type="date" class="form-control" id="fechaReserva"/>
        <mvc:errors path="fecha" cssClass="text-warning"/>
    </div>
    <div class="mb-3">
        <mvc:label path="tiempo" for="horaReserva" class="form-label">Hora de Reserva</mvc:label>
        <mvc:input path="tiempo" type="time" class="form-control" id="horaReserva"/>
        <mvc:errors path="tiempo" cssClass="text-warning"/>
    </div>
    <div class="text-center">
        <button type="submit" class="btn btn-primary">Confirmar Reserva</button>
    </div>
</mvc:form>
        <div class="text-center mt-3">
            <a href="servicios" class="btn btn-secondary">Volver a Servicios</a>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
