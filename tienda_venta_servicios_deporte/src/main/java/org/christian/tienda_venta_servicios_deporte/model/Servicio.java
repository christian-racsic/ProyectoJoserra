package org.christian.tienda_venta_servicios_deporte.model;

import java.util.ArrayList;
import java.util.List;

public class Servicio {

    public enum TipoServicio {
        NATACION, PADEL, TENIS, GYM, CROSSFIT
    }

    private TipoServicio tipoServicio;
    private List<Reservas> reservas;

    public Servicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
        this.reservas = new ArrayList<>();
    }

 
    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public List<Reservas> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reservas> reservas) {
        this.reservas = reservas;
    }

    public void agregarReserva(Reservas reserva) {
        this.reservas.add(reserva);
    }
}