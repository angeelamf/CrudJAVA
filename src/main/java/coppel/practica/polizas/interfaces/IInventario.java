package coppel.practica.polizas.interfaces;

import coppel.practica.polizas.entities.Empleado;
import coppel.practica.polizas.entities.Inventario;

import java.util.List;
import java.util.Optional;

public interface IInventario {
    List<Inventario> findAll();
    Optional<Inventario> findById(Integer id);
    Inventario saveInventario(Inventario inventario);
    Inventario updateInventario(Inventario inventario);
    void deleteInventario(Integer id);
}
