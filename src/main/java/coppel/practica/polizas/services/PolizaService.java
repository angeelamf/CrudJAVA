package coppel.practica.polizas.services;

import coppel.practica.polizas.entities.Inventario;
import coppel.practica.polizas.entities.Poliza;
import coppel.practica.polizas.interfaces.IPoliza;
import coppel.practica.polizas.models.PolizaDetalle;
import coppel.practica.polizas.repositories.PolizaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PolizaService implements IPoliza {
    private final PolizaRepository polizaRepository;
    private final InventarioService inventarioService;

    private final EmpleadoService empleadoService;

    public PolizaService(PolizaRepository polizaRepository, InventarioService inventarioService, EmpleadoService empleadoService) {
        this.polizaRepository = polizaRepository;
        this.inventarioService = inventarioService;
        this.empleadoService = empleadoService;
    }

    @Override
    public List<Poliza> findAll() {
        return polizaRepository.findAll();
    }

    @Override
    public Optional<Poliza> findById(Integer id) {
        return polizaRepository.findById(id);
    }
    @Override
    public List<PolizaDetalle> findAllWithDetail() {
        List<PolizaDetalle> polizaDetalles = new ArrayList<PolizaDetalle>();
        List<Poliza> polizas = polizaRepository.findAll();

        if(polizas.isEmpty())
            return polizaDetalles;

        for (Poliza p : polizas)
        {
            polizaDetalles.add(new PolizaDetalle(p, empleadoService.findById(p.empleado_id).get(), inventarioService.findById(p.inventario_id).get()));
        }

        return polizaDetalles;
    }
    @Override
    public Optional<PolizaDetalle> findDetailedById(Integer id) {

        Poliza p = polizaRepository.findById(id).get();

        return Optional.of(new PolizaDetalle(p, empleadoService.findById(p.empleado_id).get(), inventarioService.findById(p.inventario_id).get()));
    }
    @Override
    public PolizaDetalle savePoliza(Poliza poliza) throws Exception {

        Optional<Inventario> inventario = inventarioService.findById(poliza.inventario_id);
        if(inventario.isEmpty())
            throw new Exception("Articulo seleccionado no existe");

        Inventario inv = inventario.get();
        if(inv.Cantidad < poliza.Cantidad)
            throw new Exception("No hay suficiente inventario para suplir poliza");

        inventario.get().Cantidad = inv.Cantidad - poliza.Cantidad;

        inventarioService.saveInventario(inv);

        Poliza polizaGuardada = polizaRepository.save(poliza);

        return new PolizaDetalle(poliza, empleadoService.findById(poliza.empleado_id).get(), inv);

    }

    @Override
    public Poliza updatePoliza(Poliza poliza) {
        return polizaRepository.save(poliza);
    }

    @Override
    public void deletePoliza(Integer id) {
        deletePoliza(id);
    }
}
