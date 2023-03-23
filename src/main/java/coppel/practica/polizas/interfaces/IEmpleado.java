package coppel.practica.polizas.interfaces;

import coppel.practica.polizas.entities.Empleado;

import java.util.List;
import java.util.Optional;

public interface IEmpleado {
    List<Empleado> findAll();
    Optional<Empleado> findById(Integer id);
    Empleado saveEmpleado(Empleado empleado);
    Empleado updateEmpleado(Empleado empleado);
    void deleteEmpleado(Integer id);
}
