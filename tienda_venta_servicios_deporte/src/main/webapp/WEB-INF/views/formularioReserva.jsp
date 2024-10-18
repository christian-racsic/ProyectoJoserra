<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reservar Servicio</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center">Formulario de Reserva</h2>
        <form action="hacerReservaFinal" method="post"> <!-- Cambia la acción a tu controlador adecuado -->
            <div class="mb-3">
                <label for="nombreServicio" class="form-label">Nombre del Servicio</label>
                <input type="text" class="form-control" id="nombreServicio" name="nombreServicio" value="${servicio.nombre}" readonly>
            </div>
            <div class="mb-3">
                <label for="fechaReserva" class="form-label">Fecha de Reserva</label>
                <input type="date" class="form-control" id="fechaReserva" name="fechaReserva" required>
            </div>
            <div class="mb-3">
                <label for="horaReserva" class="form-label">Hora de Reserva</label>
                <input type="time" class="form-control" id="horaReserva" name="horaReserva" required>
            </div>
            <div class="text-center">
                <button type="submit" class="btn btn-primary">Confirmar Reserva</button>
            </div>
        </form>
        <div class="text-center mt-3">
            <a href="servicios" class="btn btn-secondary">Volver a Servicios</a>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>