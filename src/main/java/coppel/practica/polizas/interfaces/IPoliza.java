package coppel.practica.polizas.interfaces;

import coppel.practica.polizas.entities.Empleado;
import coppel.practica.polizas.entities.Poliza;
import coppel.practica.polizas.models.PolizaDetalle;

import java.util.List;
import java.util.Optional;

public interface IPoliza {
    List<Poliza> findAll();
    Optional<Poliza> findById(Integer id);

    List<PolizaDetalle> findAllWithDetail();

    Optional<PolizaDetalle> findDetailedById(Integer id);

    PolizaDetalle savePoliza(Poliza poliza) throws Exception;
    Poliza updatePoliza(Poliza poliza);
    void deletePoliza(Integer id);
}
