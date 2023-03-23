package coppel.practica.polizas.services;

import coppel.practica.polizas.entities.Inventario;
import coppel.practica.polizas.interfaces.IInventario;
import coppel.practica.polizas.repositories.InventarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventarioService implements IInventario {

    private final InventarioRepository inventarioRepository;

    public InventarioService(InventarioRepository inventarioRepository) {
        this.inventarioRepository = inventarioRepository;
    }

    @Override
    public List<Inventario> findAll() {
        return inventarioRepository.findAll();
    }

    @Override
    public Optional<Inventario> findById(Integer id) {
        return inventarioRepository.findById(id);
    }

    @Override
    public Inventario saveInventario(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    @Override
    public Inventario updateInventario(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    @Override
    public void deleteInventario(Integer id) {
        deleteInventario(id);
    }
}
