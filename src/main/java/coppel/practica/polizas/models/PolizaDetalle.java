package coppel.practica.polizas.models;

import coppel.practica.polizas.entities.*;

public class PolizaDetalle {
    public Poliza Poliza;
    public Empleado empleado;
    public Inventario DetalleArticulo;

    public PolizaDetalle() {
    }

    public PolizaDetalle(coppel.practica.polizas.entities.Poliza poliza, Empleado empleado, Inventario detalleArticulo) {
        Poliza = poliza;
        this.empleado = empleado;
        DetalleArticulo = detalleArticulo;
    }
}
